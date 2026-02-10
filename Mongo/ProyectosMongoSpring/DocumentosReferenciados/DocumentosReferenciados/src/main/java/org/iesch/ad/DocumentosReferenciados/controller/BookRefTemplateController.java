package org.iesch.ad.DocumentosReferenciados.controller;

import org.iesch.ad.DocumentosReferenciados.model.BookRef;
import org.iesch.ad.DocumentosReferenciados.service.BookRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books-ref/template")
public class BookRefTemplateController {

    @Autowired
    BookRefService bookRefService;

    //CRUD

    //GetAll

    @GetMapping
    public ResponseEntity<List<BookRef>> getAll(){
        return ResponseEntity.ok(bookRefService.buscaTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id){
        return ResponseEntity.ok(bookRefService.buscarPorId(id));
    }

    //Buscar libros por título

    @GetMapping("/search/titulo")
    public ResponseEntity<List<BookRef>> buscarPorTitulo(@RequestParam String q){
        return ResponseEntity.ok(bookRefService.findByTituloContainingIgnoreCase(q));
    }

    //Buscar libros por el id de autor
    @GetMapping("/search/autor/{autorId}")
    public ResponseEntity<List<BookRef>> buscarLibrosPorAutorId(@PathVariable String autorId){
        return ResponseEntity.ok(bookRefService.findByAutorId(autorId));
    }

    //Buscar Libros de un autor especifico (por nombre del autor), Usando  Lookup
    @GetMapping("/search/autor-nombre")
    public ResponseEntity<List<BookRef>> buscarPorNombreAutor(@RequestParam String nombreAutor){
        return ResponseEntity.ok(bookRefService.findByAutorNombre(nombreAutor));
    }
}
