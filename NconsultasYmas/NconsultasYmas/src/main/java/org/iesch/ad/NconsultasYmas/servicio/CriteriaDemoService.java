package org.iesch.ad.NconsultasYmas.servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.iesch.ad.NconsultasYmas.modelo.Autor;
import org.iesch.ad.NconsultasYmas.modelo.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CriteriaDemoService {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void ejemploConsultaSimple() {
        System.out.println("SELECT * FROM autores");

        //1 - Creamos el builder.
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //2 - Entidad a obtener
        CriteriaQuery<Autor> criteriaQuery = cb.createQuery(Autor.class);

        //3 - Crear root (FROM)
        Root<Autor> autor = criteriaQuery.from(Autor.class);
        //4 - Crear el SELECT
        criteriaQuery.select(autor);

        //5 - Crear y ejecutar la consulta
        TypedQuery<Autor> query = entityManager.createQuery(criteriaQuery);

        List<Autor> autores = query.getResultList();

        System.out.println("Resultados encontrados :" + autores.size());
        for (Autor a: autores){
            System.out.println(" - "+ a.getNombre()+" "+a.getApellido());
        }
    }

    @Transactional
    public void ejemploConsultaConWhere() {
        System.out.println("SELECT * FROM autores WHERE nacionalidad ='Argentina'");

        //1 - Creamos el builder.
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //2 - Entidad a obtener
        CriteriaQuery<Autor> criteriaQuery = cb.createQuery(Autor.class);

        //3 - Crear root (FROM)
        Root<Autor> autor = criteriaQuery.from(Autor.class);
        //WHERE
        criteriaQuery.select(autor).
                where(cb.equal(autor.get("nacionalidad"),"Argentina"));

        //5 - Crear y ejecutar la consulta
        TypedQuery<Autor> query = entityManager.createQuery(criteriaQuery);

        List<Autor> autores = query.getResultList();

        System.out.println("Resultados encontrados :" + autores.size());
        for (Autor a: autores){
            System.out.println(" - "+ a.getNombre()+" "+a.getApellido()+" "+a.getNacionalidad());
        }

    }

    @Transactional
    public void ejemploConsultaConLike() {
        System.out.println("Consulta con LIKE='' ");
        System.out.println("SELECT * FROM autores WHERE nombre LIKE='%jorge%'");

        //1 - Creamos el builder.
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //2 - Entidad a obtener
        CriteriaQuery<Autor> criteriaQuery = cb.createQuery(Autor.class);

        //3 - Crear root (FROM)
        Root<Autor> autor = criteriaQuery.from(Autor.class);

        //Where nombre LIKE '%jorge%'
        criteriaQuery.select(autor).where(cb.like(autor.get("nombre"),"%Jorge%"));

        TypedQuery<Autor> consulta = entityManager.createQuery(criteriaQuery);
        List<Autor> autores= consulta.getResultList();

        for (Autor a: autores){
            System.out.println(" - "+a.getNombre()+" "+a.getApellido());
        }
    }

    @Transactional
    public void ejemploConsultaConJoin() {
        System.out.println("Consulta con Join");
        System.out.println("SELECT l FROM libro l JOIN l.autor a WHERE a.nacionalidad ='Colombiana'");
        //1 - Creamos el builder.
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //2 - Entidad a obtener
        CriteriaQuery<Libro> criteriaQuery = cb.createQuery(Libro.class);

        //3 - Crear root (FROM)
        Root<Libro> libro = criteriaQuery.from(Libro.class);

        //JOIN con la tabla autor
        Join<Libro,Autor> autorJoin = libro.join("autor");

        //WHERE
        criteriaQuery.select(libro).where(cb.equal(autorJoin.get("nacionalidad"),"Colombiana"));

        TypedQuery<Libro> consulta = entityManager.createQuery(criteriaQuery);
        List<Libro> libros = consulta.getResultList();
        System.out.println("Libros de autores colombianos");
        for (Libro l : libros){
            System.out.println(" - "+l.getTitulo()+" "+l.getAnioPublicacion());
        }


    }
    @Transactional
    public void ejemploConsultaMultiplesCondiciones() {
        System.out.println("Consulta con AND, OR ...");
        System.out.println("SELECT * FROM libros WHERE precio >15 AND anio_publicacion>1960");
        //1 - Creamos el builder.
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //2 - Entidad a obtener
        CriteriaQuery<Libro> criteriaQuery = cb.createQuery(Libro.class);

        //3 - Crear root (FROM)
        Root<Libro> libro = criteriaQuery.from(Libro.class);

        //Multiples condiciones.
        Predicate precioMayor15 = cb.gt(libro.get("precio"),15.0);
        Predicate anioPublicacionMayor1960 = cb.gt(libro.get("anioPublicacion"),1960);
        //WHERE
        criteriaQuery.select(libro).where(cb.and(precioMayor15,anioPublicacionMayor1960));
        TypedQuery<Libro> consulta = entityManager.createQuery(criteriaQuery);

        List<Libro> libros = consulta.getResultList();
        System.out.println("Libros>15  && año publicacion>1960");
        for (Libro l : libros){
            System.out.println(" - "+l.getTitulo()+" "+l.getAnioPublicacion()+" "+l.getPrecio());
        }

    }

    @Transactional
    public void ejemploConsultaDinamica(String nacionalidad, Double precioMinimo, Integer anioPubliMinimo) {
        System.out.println("Consulta dinámica");
        System.out.println("SELECT l FROM libro l JOIN l.autor a WHERE a.nacionalidad " +
                "='parametro' AND l.precio > parametro AND anio_publicacion> parametro");

        //1 - Creamos el builder.
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //2 - Entidad a obtener
        CriteriaQuery<Libro> criteriaQuery = cb.createQuery(Libro.class);

        //3 - Crear root (FROM)
        Root<Libro> libro = criteriaQuery.from(Libro.class);

        //Join con autor
        Join<Libro,Autor> autorJoin = libro.join("autor");

        //Lista de precicados
        List<Predicate> predicates = new ArrayList<>();

        //Añado condiciones.
        if (nacionalidad!=null && !nacionalidad.isEmpty()){
            predicates.add(cb.equal(autorJoin.get("nacionalidad"),nacionalidad));
        }
        if (precioMinimo !=null){
            predicates.add(cb.gt(libro.get("precio"),precioMinimo));
        }
        if (anioPubliMinimo !=null){
            predicates.add(cb.gt(libro.get("anioPublicacion"),anioPubliMinimo));
        }

        //Combinar
        if (!predicates.isEmpty()){
            criteriaQuery.select(libro).
                    where(cb.and(predicates.toArray(new Predicate[0])));
        }else {
            criteriaQuery.select(libro);
        }

        TypedQuery<Libro> consulta = entityManager.createQuery(criteriaQuery);
        List<Libro> libros = consulta.getResultList();

        System.out.println("Libros con criterios dinamicos");
        for (Libro l : libros){
            System.out.println(" - "+l.getTitulo()+" "+l.getAnioPublicacion()+ " "+l.getPrecio());
        }





    }

    @Transactional
    public void ejemploConsultaConOrderBy() {
        System.out.println("Consulta con OrderBy");
        System.out.println("SELECT * FROM libros ORDER BY anio_publicacion");

        //1 - Creamos el builder.
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //2 - Entidad a obtener
        CriteriaQuery<Libro> criteriaQuery = cb.createQuery(Libro.class);

        //3 - Crear root (FROM)
        Root<Libro> libro = criteriaQuery.from(Libro.class);

        //Order by anio publicacion
        criteriaQuery.select(libro).orderBy(cb.desc(libro.get("anioPublicacion")));


        TypedQuery<Libro> consulta = entityManager.createQuery(criteriaQuery);

        List<Libro> libros = consulta.getResultList();
        System.out.println("Libros ordenados por año de publicacion");
        for (Libro l : libros){
            System.out.println(" - "+l.getTitulo()+" "+l.getAnioPublicacion());
        }
    }
    @Transactional
    public void ejemploConsultaConGroupBy() {
        System.out.println("Consulta con GROUP BY y contamos libros por autor");


        //1 - Creamos el builder.
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //2 - Entidad a obtener
        CriteriaQuery<Object[]> countQuery = cb.createQuery(Object[].class);
        //3 - Crear root (FROM)
        Root<Libro> libro = countQuery.from(Libro.class);

        //Join
        Join<Libro,Autor> autorJoin = libro.join("autor");

        //GROUP BY Vamos a contar por autor, es decir un autor tiene tantos libros.
        // Del autor sacamos el nombre y apellido
        countQuery.multiselect(
          autorJoin.get("nombre"),
          autorJoin.get("apellido"),
          cb.count(libro)
        ).groupBy(autorJoin.get("Id"),autorJoin.get("nombre"),autorJoin.get("apellido"));

        TypedQuery<Object[]> consulta = entityManager.createQuery(countQuery);

        List<Object[]> resultados = consulta.getResultList();

        System.out.println("Contamos:");
        for (Object[] resultado : resultados){
            System.out.println(" - "+ resultado[0]+ " "
                    +resultado[1]+" "+resultado[2]+" : Libros");
        }

        //Buscar el Libro con el precio maximo
        System.out.println("Precio máximo");
        CriteriaQuery<Double> maxQuery = cb.createQuery(Double.class);

        Root<Libro> libroRoot = maxQuery.from(Libro.class);
        maxQuery.select(cb.max(libroRoot.get("precio")));

        Double precioMaximo = entityManager.createQuery(maxQuery).getSingleResult();
        System.out.println("\t -El precio maximo: "+ precioMaximo);


    }
}
