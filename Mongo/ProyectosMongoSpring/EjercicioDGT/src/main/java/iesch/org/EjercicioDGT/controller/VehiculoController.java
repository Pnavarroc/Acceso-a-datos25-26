package iesch.org.EjercicioDGT.controller;

import iesch.org.EjercicioDGT.model.Vehiculo;
import iesch.org.EjercicioDGT.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    VehiculoService vehiculoService;

    //CRUD

    //GETALL

    @GetMapping
    public ResponseEntity<List<Vehiculo>> getAll(){
        return ResponseEntity.ok(vehiculoService.getAll());
    }

    //GetOne

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getById(@PathVariable String id){
        return ResponseEntity.ok(vehiculoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Vehiculo> crearVehiculo(@RequestBody Vehiculo vehiculo) {
        return ResponseEntity.ok(vehiculoService.crearVehiculo(vehiculo));
    }
}
