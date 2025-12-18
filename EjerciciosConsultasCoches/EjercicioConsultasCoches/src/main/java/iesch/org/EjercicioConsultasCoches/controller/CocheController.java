package iesch.org.EjercicioConsultasCoches.controller;

import iesch.org.EjercicioConsultasCoches.model.Coche;
import iesch.org.EjercicioConsultasCoches.service.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coches")
public class CocheController {

    @Autowired
    private CocheService cocheService;

    // GET TODOS
    @GetMapping
    public ResponseEntity<List<Coche>> getAll() {
        return ResponseEntity.ok(cocheService.findAll());
    }

    // GET POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Coche> getById(@PathVariable Long id) {
        Coche coche = cocheService.findById(id);
        if (coche == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(coche);
    }

    // CONSULTA: Coches de una marca
    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<Coche>> cochesPorMarca(@PathVariable String marca) {
        return ResponseEntity.ok(cocheService.findByMarca(marca));
    }

    // CONSULTA: Coches más caros que X
    @GetMapping("/precio-mayor/{precio}")
    public ResponseEntity<List<Coche>> cochesPorPrecioMayor(@PathVariable double precio) {
        return ResponseEntity.ok(cocheService.findByPrecioMayor(precio));
    }

    // CONSULTA: Buscar por modelo que contenga X
    @GetMapping("/modelo-like/{texto}")
    public ResponseEntity<List<Coche>> buscarPorModelo(@PathVariable String texto) {
        return ResponseEntity.ok(cocheService.findByModeloLike(texto));
    }

    //Consulta coche por color y cliente
    @GetMapping("cliente/{clienteId}/color/{color}")
    public ResponseEntity<?> cocheClienteColor(
            @PathVariable Long clienteId,
            @PathVariable String color
    ){
        List<Coche> coches = cocheService.findByColorAndClient(color,clienteId);
        if (coches.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(coches);
        }
    }

    @GetMapping("/precio/{precioMin}/{precioMax}")
    public ResponseEntity<?> cocheEntrePecio(
            @PathVariable double precioMin,
            @PathVariable double precioMax
    ){
        List<Coche> coches = cocheService.findByPrecioBwettenXAndY(precioMin,precioMax);

        if (coches.isEmpty()){
            return ResponseEntity.noContent().build();
        }else return ResponseEntity.ok(coches);

    }
}
