package org.iesch.ad.DocumentosReferenciados.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.iesch.ad.DocumentosReferenciados.Repository.BookRefRepository;

import org.iesch.ad.DocumentosReferenciados.model.BookRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Book", description = "Esto es la descripcion")
@RestController
@RequestMapping("api/books-ref")
public class BookRefController {

    //CRUD

    @Autowired
    BookRefRepository bookRefRepository;

    //Get all
    //Get api/books-ref

    @Operation(summary = "Obtener todos los libros", description = "Devuelve la lista completa de libros referenciados")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200", description ="Se encuentran los libros correctamente")
    })
    @GetMapping
    public ResponseEntity<List<BookRef>> getAllBooks(){
        return ResponseEntity.ok(bookRefRepository.findAll());
    }

    //GetOne
    @Operation(summary = "Obtener un libro dado su id", description = "Devuelve un libro")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200", description ="Se encuentra el libro correctamente"),
            @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<BookRef> getOneBooks(
            @Parameter(description = "Id del libro", required = true, example = "sldjhfal3q42423lk23")
            @PathVariable String id){
        Optional<BookRef> book = bookRefRepository.findById(id);
        return book.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //Vamos a crear un nuevo book
    //Create One
    //Post
    @PostMapping
    public ResponseEntity<BookRef> createOne(@RequestBody BookRef book){
        BookRef bookRef = bookRefRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookRef);
    }

    //UpdateOne
    //Vamos a modificar un book
    //Put
    @PutMapping("/{id}")
    public ResponseEntity<BookRef> updateOne(@PathVariable String id, @RequestBody BookRef book){
        if (!bookRefRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        book.setId(id);
        BookRef bookRefUpdated = bookRefRepository.save(book);
        return ResponseEntity.ok(bookRefUpdated);
    }

    //Borrar book
    //Si borrais un book, lo libros referenciados no se borran, se quedan huerfanos
    //Se deberia validar y eliminar en cascada si se elimina un book
    //Delete api/books-ref/{id}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable String id){
        if (!bookRefRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        bookRefRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    //Buscar libros por el id del autor.

    @GetMapping("/search/{autorId}")
    public ResponseEntity<List<BookRef>> buscarPoridAutor(@PathVariable String autorId){
        return ResponseEntity.ok(bookRefRepository.findByAutoresId(autorId));
    }

    //Buscar libros por precio menor a y año publicacion mayor a
    @GetMapping("/search/precio-anio")
    public ResponseEntity<List<BookRef>> buscarPorPrecioMenorYAnioPublicacionMayor(@RequestParam Double precio, @RequestParam Integer anio){
        return ResponseEntity.ok(bookRefRepository.buscarPorPrecioInferiorYanioSuperior(precio, anio));
    }

    //Buscar los libros mas baratos de x o que sean más antiguos a un determinado año

    @GetMapping("/search/economicos-antiguos")
    public ResponseEntity<List<BookRef>> buscarPorBaratosOantiguos(@RequestParam Double precio, @RequestParam Integer anio){
        return ResponseEntity.ok(bookRefRepository.buscarLibrosEconomicosOAntiguos(precio, anio));
    }


    /*🔹 NIVEL 1 – Lookup básico
1️⃣ Mostrar todos los libros junto con los datos completos de sus autores.

👉 Solo $lookup.

2️⃣ Mostrar solo:

título

precio

nombre de los autores

👉 $lookup + $project

🔹 NIVEL 2 – Lookup + filtro
3️⃣ Obtener libros cuyos autores sean de nacionalidad "España".

👉 $lookup + $match

4️⃣ Obtener libros cuyo autor se llame "George Orwell".

👉 $lookup + $match

5️⃣ Obtener libros publicados después del 2000 cuyos autores sean de "Estados Unidos".

👉 $match + $lookup + $match

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

👉 $unwind + $group + $addToSet + $size

(Esta es nivel notable alto)*/
    //Consultas

    /*título
    precio
    nobre de los autores*/

    @GetMapping("/search")
    public ResponseEntity<?> buscarLibrosYAutoresFiltrandoDatos(){
        return ResponseEntity.ok(bookRefRepository.findLibrosConNombreAutor());
    }
}
