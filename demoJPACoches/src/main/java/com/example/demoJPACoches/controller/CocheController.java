package com.example.demoJPACoches.controller;

import com.example.demoJPACoches.model.Coche;
import com.example.demoJPACoches.service.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coches")
public class CocheController {

    @Autowired
    CocheService cocheService;

    @PostMapping
    public ResponseEntity<Coche> guardar(@RequestBody Coche coche){
        Coche cocheGuardado = cocheService.guardar(coche);

        return ResponseEntity.ok(cocheGuardado);
    }

    @GetMapping
    public ResponseEntity<List<Coche>> getAll(){
        return ResponseEntity.ok(cocheService.getAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Coche> getById(@PathVariable Long id){
        return ResponseEntity.ok(cocheService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coche> updateOne(@PathVariable Long id, @RequestBody Coche coche){
        return ResponseEntity.ok(cocheService.updateOne(id, coche));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Coche cocheBorrado = cocheService.deleteById(id);
        if (cocheBorrado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscaporcolor/{color}")
    public ResponseEntity<List<Coche>> getByColor(@PathVariable String color){
        return ResponseEntity.ok(cocheService.getByColor(color));
    }

    @GetMapping("/buscaporcolorymarca/{color}/{marca}")
    public ResponseEntity<List<Coche>> getByColorYmarca(@PathVariable String color, @PathVariable String marca){
        return ResponseEntity.ok(cocheService.getByColorYmarca(color,marca));
    }

    @GetMapping("/buscaporcolorymarcaypotenciamenor/{color}/{marca}/{potencia}")
    public ResponseEntity<List<Coche>> getByColorYmarcaPotenciaMenor(@PathVariable String color, @PathVariable String marca, @PathVariable int potencia){
        return ResponseEntity.ok(cocheService.getByColorYmarcaYpotenciaMenor(color,marca,potencia));
    }
}
