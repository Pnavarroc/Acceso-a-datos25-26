package org.iesch.ad.DocumentosReferenciados.controller;

import org.iesch.ad.DocumentosReferenciados.Repository.AutoresRefRepository;
import org.iesch.ad.DocumentosReferenciados.model.AutoresRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/autores")
public class AutorRefController {

    //CRUD

    @Autowired
    AutoresRefRepository autoresRefRepository;

    //Get all
    //Get /api/autores

    @GetMapping
    public ResponseEntity<List<AutoresRef>> getAllAutores(){
        return ResponseEntity.ok(autoresRefRepository.findAll());
    }

    //GetOne
    @GetMapping("/{id}")
    public ResponseEntity<AutoresRef> getOneAutores(@PathVariable String id){
        Optional<AutoresRef> autor = autoresRefRepository.findById(id);
        return autor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //Vamos a crear un nuevo autor
    //Create One
    //Post
    @PostMapping
    public ResponseEntity<AutoresRef> createOne(@RequestBody AutoresRef autor){
        AutoresRef autoresRef = autoresRefRepository.save(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(autoresRef);
    }

    //UpdateOne
    //Vamos a modificar un autor
    //Put
    @PutMapping("/{id}")
    public ResponseEntity<AutoresRef> updateOne(@PathVariable String id, @RequestBody AutoresRef autor){
        if (!autoresRefRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        autor.setId(id);
        AutoresRef autoresRefUpdated = autoresRefRepository.save(autor);
        return ResponseEntity.ok(autoresRefUpdated);
    }

    //Borrar autor
    //Si borrais un autor, lo libros referenciados no se borran, se quedan huerfanos
    //Se deberia validar y eliminar en cascada si se elimina un autor
    //Delete api/autores/{id}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable String id){
        if (!autoresRefRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        autoresRefRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/nombre")
    public ResponseEntity<List<AutoresRef>> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(autoresRefRepository.findByNombreContainingIgnoreCase(nombre));
    }

    @GetMapping("/search/nacionalidad")
    public ResponseEntity<List<AutoresRef>> buscarPorNacionalidad(@RequestParam String nacionalidad){
        return ResponseEntity.ok(autoresRefRepository.findByNacionalidadContainingIgnoreCase(nacionalidad));
    }

    //Buscar por varias nacionalidades
    @PostMapping("/search/nacionalidades")
    public ResponseEntity<List<AutoresRef>> buscarPorNacionalidades(@RequestBody List<String> nacionalidades){
        return ResponseEntity.ok(autoresRefRepository.findByNacionalidadIn(nacionalidades));
    }


}
