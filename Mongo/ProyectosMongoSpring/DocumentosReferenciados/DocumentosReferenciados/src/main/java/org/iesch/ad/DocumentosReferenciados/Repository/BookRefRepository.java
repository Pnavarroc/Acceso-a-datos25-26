package org.iesch.ad.DocumentosReferenciados.Repository;

import org.iesch.ad.DocumentosReferenciados.model.BookRef;
import org.jspecify.annotations.Nullable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRefRepository extends MongoRepository<BookRef,String> {

    //========CONSULTAS==========

    //Buscar libros por id del autor
    List<BookRef> findByAutoresId(String id);

    //Consulta con  @Query
    //Buscar libros con precio inferior a x y año de publicacion mayor a y

    @Query("{'precio': {$lte: ?0}, 'anioPublicacion': {$gte: ?1}}")
    List<BookRef> buscarPorPrecioInferiorYanioSuperior(Double precio, Integer anio);

    @Query("{$or: [{'precio': {$lt: ?0}}, {'anioPublicacion': {$lt: ?1} }  ]}'")
    List<BookRef> buscarLibrosEconomicosOAntiguos(Double precio, Integer anio);
}
