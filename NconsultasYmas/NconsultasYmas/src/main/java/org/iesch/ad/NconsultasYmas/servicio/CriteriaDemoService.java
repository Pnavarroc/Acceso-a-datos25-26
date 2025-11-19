package org.iesch.ad.NconsultasYmas.servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.iesch.ad.NconsultasYmas.modelo.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
