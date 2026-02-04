package org.iesch.ad.DocumentosReferenciados.controller;


import org.iesch.ad.DocumentosReferenciados.Repository.BookRefRepository;

import org.iesch.ad.DocumentosReferenciados.model.BookRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/books-ref")
public class BookRefController {

    //CRUD

    @Autowired
    BookRefRepository bookRefRepository;

    //Get all
    //Get api/books-ref
    @GetMapping
    public ResponseEntity<List<BookRef>> getAllBooks(){
        return ResponseEntity.ok(bookRefRepository.findAll());
    }

    //GetOne
    @GetMapping("/{id}")
    public ResponseEntity<BookRef> getOneBooks(@PathVariable String id){
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
}
