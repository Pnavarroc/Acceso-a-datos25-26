package org.iesch.ad.DocumentosReferenciados.Repository;

import org.iesch.ad.DocumentosReferenciados.model.BookRef;
import org.jspecify.annotations.Nullable;
import org.springframework.data.mongodb.repository.Aggregation;
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


    //db.libros_ref.aggregate([
    //    {$lookup:{from : "autores",localField:"autores",foreignField: "_id",as: "autor"}},
    //    {$project:{"titulo":1,"precio":1,"autor.nombre":1,"_id":0}}
    //])
    @Aggregation(pipeline = {
            "{$lookup:{from : \"autores\",localField:\"autores\",foreignField: \"_id\",as: \"autor\"}},",
            "{$project:{\"titulo\":1,\"precio\":1,\"autor.nombre\":1,\"_id\":0}}"
    })
    List<BookRef> findLibrosConNombreAutor();

    /* Obtener libros publicados después del 2000 cuyos autores sean de "Estados Unidos".
👉 $match + $lookup + $match

*/
    @Aggregation(pipeline = {
            "{ $match:{ \"anioPublicacion\":{$gt: ?0} }}",
            "    {$lookup:{from : \"autores\",localField:\"autores\",foreignField: \"_id\",as: \"autor\" }}",
            "    {$match:{\"autor.nacionalidad\": ?1}}"

    })
    List<BookRef> librosPublicadosDespuesDeYNacionalidad(Integer anio, String nacionalidad);
    /*/
(Ojo con el orden)

🔥 NIVEL 3 – Con unwind
6️⃣ Mostrar cada libro repetido por cada autor (uno por línea).

👉 $lookup + $unwind

7️⃣ Contar cuántos libros hay por nacionalidad de autor.

👉 $lookup + $unwind + $group

🔥 NIVEL 4 – Aggregate más interesante
8️⃣ Obtener el autor que ha participado en más libros.

👉 $unwind + $group + $sort + $limit + $lookup

9️⃣ Calcular el precio promedio de los libros por nacionalidad del autor.

👉 $lookup + $unwind + $group + $avg

🔟 Mostrar las editoriales y el número total de autores distintos que han publicado en cada una.

👉 $unwind + $group + $addToSet + $size*/
}
