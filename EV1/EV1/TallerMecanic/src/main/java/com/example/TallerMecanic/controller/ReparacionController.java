package com.example.TallerMecanic.controller;

import com.example.TallerMecanic.model.Estado;
import com.example.TallerMecanic.service.ReparacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/reparaciones")
public class ReparacionController
{
    @Autowired
    private ReparacionesService reparacionesService;

    @GetMapping("/por-vehiculo/{vehiculoId}")
    public ResponseEntity<?> getByVehiculoId(@PathVariable Long vehiculoId)
    {
        return ResponseEntity.ok(reparacionesService.getByVehiculoId(vehiculoId));
    }

    @GetMapping("/por-estado")
    public ResponseEntity<?> getByEstado(@RequestParam Estado estado)
    {
        return ResponseEntity.ok(reparacionesService.getByEstado(estado));
    }

    //api/reparaciones/por-vehiculo-coste?vehiculoId=1&coste=100

    @GetMapping("/por-vehiculo-coste")
    public ResponseEntity<?> getByVehiculoIdAndCosteMayor(@RequestParam Long vehiculoId, @RequestParam double coste)
    {
        return ResponseEntity.ok(reparacionesService.getByVehiculoIdAndCoste(vehiculoId,coste));
    }

    ///api/reparaciones/entre-fechas?inicio=2026-01-01&fin=2026-12-31

    //Reparaciones entre dos fechas

    @GetMapping("/entre-fechas")
    public ResponseEntity<?> getBetweenFechas(@RequestParam LocalDate inicio, @RequestParam LocalDate fin)
    {
        return ResponseEntity.ok(reparacionesService.getBetweenFechas(inicio, fin));
    }

    //Obtener reparaciones finalizadas de vehículos cuyo cliente sea de una ciudad concreta.
    //GET /api/reparaciones/finalizadas-por-ciudad?ciudad=Teruel

    @GetMapping("/finalizadas-por-ciudad")
    public ResponseEntity<?> getByClienteCiudad(@RequestParam String ciudad)
    {
        return ResponseEntity.ok(reparacionesService.getByClienteCiudadAndFinalizada(ciudad));
    }

    //GET /api/reparaciones/por-marca-coste?marca=BMW&coste=200

    //Reparaciones de marca concreta coste superior a tantoordenadas por fecha descendente

    @GetMapping("/por-marca-coste")
    public ResponseEntity<?> getByMarcaCoste(@RequestParam String marca, @RequestParam double coste)
    {
        return ResponseEntity.ok(reparacionesService.getByMarcaYCosteMayor(marca,coste));
    }

    //Mostrar solo la informacion que nos piden en el dto:

    @GetMapping
    public ResponseEntity<?> getAllReparaciones()
    {
        return ResponseEntity.ok(reparacionesService.getAll());
    }
}
