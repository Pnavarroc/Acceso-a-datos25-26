package iesch.org.DocumentosReferenciadosBiblioteca.controller;

import iesch.org.DocumentosReferenciadosBiblioteca.model.Libros;
import iesch.org.DocumentosReferenciadosBiblioteca.service.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libros")
public class LibrosController {

    @Autowired
    LibrosService librosService;


    //=============CRUD==========

    //GetAll
    @GetMapping
    public ResponseEntity<List<Libros>> conseguirTodosLosLibros(){

        return ResponseEntity.ok(librosService.getAll());
    }

    //GetOne

    @GetMapping("/{id}")
    public ResponseEntity<Libros> conseguirUno(@PathVariable Long id){
        return ResponseEntity.ok(librosService.getOne(id));
    }


    //UpdateOne
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarUno(@PathVariable Long id, @RequestBody Libros libro){
        return ResponseEntity.ok(librosService.updateOne(id, libro));
    }

    //Post
    @PostMapping
    public ResponseEntity<?> crearUno(@RequestBody Libros libro) {

        Libros guardado = (Libros) librosService.addOne(libro);
        if (guardado == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El ID ya existe");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id){
        return ResponseEntity.ok(librosService.deleteOne(id));
    }


    /*📘 Consultas básicas sobre libros

Obtener todos los libros.

Buscar un libro por su id.

Listar todos los libros de un autor específico.

Listar todos los libros de un género determinado.

Buscar libros publicados en un año concreto.

Buscar libros publicados después de 1980.

Obtener los libros que tengan más de 400 páginas.

Buscar libros cuyo título contenga una palabra (sin importar mayúsculas).

📗 Consultas combinadas

Obtener los libros de un autor específico y de un género concreto.

Listar los libros de una editorial determinada.

Obtener los libros publicados entre 1960 y 1990.

Buscar libros de un autor ordenados por año de publicación descendente.

Obtener los libros de un género ordenados por cantidad de páginas.

📕 Consultas con paginación

Listar los libros de un género usando paginación (por ejemplo, 5 por página).

Obtener la segunda página de libros ordenados por año de publicación.

📙 Consultas tipo negocio (muy típicas)

Obtener los libros que nunca han sido prestados.

Obtener los libros que están actualmente prestados (no devueltos).

Obtener los libros prestados por un usuario específico.

Listar los libros prestados que ya deberían haberse devuelto.

Obtener cuántas veces ha sido prestado cada libro.

🧠 Consultas un poco más pro

Obtener los libros junto con el nombre del autor.

Obtener los libros junto con el nombre de la editorial.

Listar los libros de autores que hayan ganado el Premio Nobel.

Obtener el autor con más libros registrados.

Obtener el libro más largo (más páginas).*/

    //====CONSULTAS===

    //Listar todos los libros de un autor especifico
    //GetMapping

    @GetMapping("/autor/{nombreAutor}")
    public ResponseEntity<List<Libros>> mostrarLibrosPorNombreAutor(@PathVariable String nombreAutor){
        return ResponseEntity.ok(librosService.conseguirLibrosPorNombreAutor(nombreAutor));
    }

    //Listar todos los libros de un género determinado.

    @GetMapping("/genero")
    public ResponseEntity<List<Libros>> mostrarLibrosPorGenero(@RequestParam String genero){
        return ResponseEntity.ok(librosService.listarLibrosPorGenero(genero));
    }

//Buscar libros publicados después de 1980.
    @GetMapping("/anio")
    public ResponseEntity<List<Libros>> mostrarLibrosPublicadosDespuesDe(@RequestParam Integer anio){
        return ResponseEntity.ok(librosService.mostrarLibrosPublicadosDespuesDe(anio));
    }

    //Obtener los libros que tengan más de 400 páginas.

    @GetMapping("/paginas")
    public ResponseEntity<List<Libros>> mostrarLibrosDeMasDeXpaginas(@RequestParam Integer paginas){
        return ResponseEntity.ok(librosService.mostrarLibrosPorPaginas(paginas));
    }

    //Obtener los libros de un autor específico y de un género concreto.
    @GetMapping("/nombreAutor/genero")
    public ResponseEntity<List<Libros>> mostrarLibrosPorNombreAutorYGenero(@RequestParam String nombreAutor ,@RequestParam String genero){
        return ResponseEntity.ok(librosService.mostrarLibrosPorNombreAutorYGenero(nombreAutor, genero));
    }


}
