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




}
