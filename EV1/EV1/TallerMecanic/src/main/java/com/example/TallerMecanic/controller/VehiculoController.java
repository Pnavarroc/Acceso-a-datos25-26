package com.example.TallerMecanic.controller;

import com.example.TallerMecanic.model.Vehiculo;
import com.example.TallerMecanic.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController
{
    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        return ResponseEntity.ok(vehiculoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(vehiculoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> postOne(@RequestBody Vehiculo vehiculo)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoService.createOne(vehiculo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOne(@PathVariable Long id, @RequestBody Vehiculo vehiculo)
    {
        return ResponseEntity.ok(vehiculoService.updateOne(id,vehiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable Long id)
    {
        vehiculoService.deleteOne(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //#region consultas

    @GetMapping("/por-cliente/{clienteId}")
    public ResponseEntity<?> getVehiculosByClienteId(@PathVariable Long clienteId)
    {
        return ResponseEntity.ok(vehiculoService.getVehiculosByClienteId(clienteId));
    }

    //Vehiculos cuyo cliente sea de una ciudad concreta

    @GetMapping("/por-ciudad")
    public ResponseEntity<?> getVehiculosByClienteCiudad(@RequestParam String ciudad)
    {
        return ResponseEntity.ok(vehiculoService.getVehiculosByClienteCiudad(ciudad));
    }

    //GET /api/vehiculos/por-marca?marca=Alfa Romeo

    @GetMapping("/por-marca")
    public ResponseEntity<?> getVehiculosByMarca(@RequestParam String marca)
    {
        return ResponseEntity.ok(vehiculoService.getVehiculosByMarca(marca));
    }

    //GET /api/vehiculos/por-anio?anio=2010

    @GetMapping("/por-anio")
    public ResponseEntity<?> getVehiculosDespuesDeAnio(@RequestParam int anio)
    {
        return ResponseEntity.ok(vehiculoService.getByAnioDespues(anio));
    }

}
