package iesch.org.EjercicioDGT.controller;

import iesch.org.EjercicioDGT.model.Multa;
import iesch.org.EjercicioDGT.model.Vehiculo;
import iesch.org.EjercicioDGT.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehiculos")
public class Vehiculoscontroller
{

    @Autowired
    private VehiculoService vehiculoService;


    @GetMapping
    public ResponseEntity<?> getAllVehicles()
    {
        return ResponseEntity.ok(vehiculoService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> postVehicle(@RequestBody Vehiculo vehiculo)
    {
        return ResponseEntity.ok(vehiculoService.postVehicle(vehiculo));
    }

    @PostMapping("{matricula}/multas")
    public ResponseEntity<?> postVehicle(@PathVariable String matricula, @RequestBody Multa multa)
    {
        return ResponseEntity.ok(vehiculoService.createMulta(matricula, multa));
    }

    //GET /api/vehiculos/titular/{dni}
    //BuscarVehiculos por titular.

    @GetMapping("titular/{dni}")
    public ResponseEntity<?> BuscarVehiculosByTitular(@PathVariable String dni)
    {
        return ResponseEntity.ok(vehiculoService.getVehiculosByDNI(dni));
    }

    @GetMapping("estado/{estado}")
    public ResponseEntity<?> BuscarVehiculosByEstado(@PathVariable String estado)
    {
        return ResponseEntity.ok(vehiculoService.BuscarVehiculosByEstado(estado));
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> BuscarPorMarcayModelo(@RequestParam String marca, @RequestParam String modelo)
    {
        return ResponseEntity.ok(vehiculoService.BuscarPorMarcayModelo(marca, modelo));
    }

    @GetMapping("/itv/caducada")
    public ResponseEntity<?> buscarCochesItvCaducada()
    {
        return ResponseEntity.ok(vehiculoService.buscarCochesItvCaducada());
    }
/*9. Obtener vehículos activos con ITMV pagado y sin multas pendientes
GET /api/vehiculos/transferibles*/

    @GetMapping("/transferibles")
    public ResponseEntity<?> getCochesITMVPagadoYNOMultas()
    {
        return ResponseEntity.ok(vehiculoService.getCochesITMVPagadoYNOMultas());
    }


    @GetMapping("/faltaPago")
    public ResponseEntity<?> findVehiculosConMultasPendientes()
    {
        return ResponseEntity.ok(vehiculoService.findVehiculosConMultasPendientes());
    }


    /*
5. Buscar vehículos con multas pendientes
GET /api/vehiculos/multas/pendientes

6. Obtener todas las multas de un vehículo
GET /api/vehiculos/{matricula}/multas

7. Obtener multas de un vehículo filtradas por estado
GET /api/vehiculos/{matricula}/multas?estado=PENDIENTE_PAGO

8. Verificar si un vehículo puede transferirse
GET /api/vehiculos/{matricula}/verificar-transferencia



10. Obtener estadísticas generales del sistema
GET /api/vehiculos/estadisticas
Hazlas en ese orden. Las 4, 5, 8, 9 y 10 son las más potentes para cerrar el repaso.*/
}
