package iesch.org.DocumentosReferenciadosBiblioteca.repository;

import iesch.org.DocumentosReferenciadosBiblioteca.model.Libros;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends MongoRepository<Libros,Long> {


    //Consultas

    //Mostrar todos los libros de un autor por su nombre.

    @Aggregation(pipeline = {
            "{ $lookup: { from: 'autores', localField: 'autor_id', foreignField: '_id', as: 'autor' } }",
            "{ $unwind: '$autor' }",
            "{ $match: { 'autor.nombre': ?0 } }"
    })
    List<Libros> findByAutoresNombre(String nombre);



    //Mostrar libros por genero

    List<Libros> findByGenero(String genero);


    //Mostrar libros que han sido publicados despues de x año

    List<Libros> findByAnioPublicacionGreaterThan(Integer anio);

    //Mostrar libros que tengas ma de X paginas
    List<Libros> findByPaginasGreaterThan(Integer paginas);

    //MostrarLibrosPorNombreAutorYGenero
    @Aggregation(pipeline = {
            "{ $lookup: { from: 'autores', localField: 'autor_id', foreignField: '_id', as: 'autor' } }",
            "{ $unwind: '$autor' }",
            "{ $match: { 'autor.nombre': ?0 }, {'genero' : ?1} }"
    })
    List<Libros> findByAutoresNombreYGenero(String nombre, String genero);
}


