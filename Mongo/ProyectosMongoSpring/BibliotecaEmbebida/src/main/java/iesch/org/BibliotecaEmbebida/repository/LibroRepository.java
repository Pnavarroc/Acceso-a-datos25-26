package iesch.org.BibliotecaEmbebida.repository;

import iesch.org.BibliotecaEmbebida.model.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends MongoRepository<Libro, String> {

    //Consultas con mongoRepository

    //Buscar libros con precio mayor que X

    List<Libro> findByPrecioGreaterThan(Double precio);

    //Libros entre dos precios min y max
    List<Libro> findByPrecioBetween(Double precioMin, Double precioMax);

    //Libros que tenga categoria Programación
    List<Libro> findByCategorias(String categoria);

    //Buscar libros por nombre del autor
    List<Libro> findByAutoresNombre(String nombre);
    //8️⃣ Buscar libros con más de 400 páginas y precio menor a 30€
    List<Libro> findByNumeroPaginasGreaterThanAndPrecioLessThan(Integer paginas, Double precio);

    //🔟 Buscar libros que NO pertenezcan a la categoría "Ficción"
    List<Libro> findByCategoriasNot(String categoria);

    //Ahora quiero buscar libros con mas de un autor ,
    @Query("{'autores.1': {'$exists': true}}")
    List<Libro> masDeUnAutor();

       /*
13️⃣ Buscar libros cuyo autor se llame "George Orwell" Y sea de nacionalidad "Reino Unido"
    */

    List<Libro> findByAutoresNombreAndAutoresNacionalidad(String nombre, String nacionalidad);

}
