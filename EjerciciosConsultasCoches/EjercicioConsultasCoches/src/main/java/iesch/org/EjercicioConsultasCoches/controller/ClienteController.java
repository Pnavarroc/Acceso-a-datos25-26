package iesch.org.EjercicioConsultasCoches.controller;


import iesch.org.EjercicioConsultasCoches.model.Cliente;
import iesch.org.EjercicioConsultasCoches.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // GET TODOS
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    // GET POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cliente);
    }

    // CONSULTA 1: Clientes que tienen coches de un color
    @GetMapping("/color/{color}")
    public ResponseEntity<List<Cliente>> clientesPorColor(@PathVariable String color) {
        return ResponseEntity.ok(clienteService.findClientesByColor(color));
    }

    // CONSULTA 2: Clientes con coches más caros que X
    @GetMapping("/precio-mayor/{precio}")
    public ResponseEntity<List<Cliente>> clientesPorPrecioMayor(@PathVariable double precio) {
        return ResponseEntity.ok(clienteService.findClientesByPrecioMayor(precio));
    }

    // CONSULTA 3: Obtener cliente por matrícula del coche
    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<Cliente> clientePorMatricula(@PathVariable String matricula) {
        Cliente cliente = clienteService.findByMatricula(matricula);
        if (cliente == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cliente);
    }
}
