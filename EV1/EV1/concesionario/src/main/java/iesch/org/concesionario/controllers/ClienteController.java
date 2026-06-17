package iesch.org.concesionario.controllers;

import iesch.org.concesionario.models.Cliente;
import iesch.org.concesionario.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController
{

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<?> getAllClients()
    {
        return ResponseEntity.ok(clienteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(clienteService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> createOne(@RequestBody Cliente cliente)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.createOne(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOne(@PathVariable Long id, @RequestBody Cliente cliente)
    {
        return ResponseEntity.status(203).body(clienteService.updateOne(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id)
    {
        clienteService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }
}