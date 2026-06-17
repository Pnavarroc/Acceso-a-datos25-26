package iesch.org.concesionario.controllers;

import iesch.org.concesionario.models.Coche;
import iesch.org.concesionario.service.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coches")
public class CocheController
{

    @Autowired
    private CocheService cocheService;

    @GetMapping
    public ResponseEntity<?> getAllClients()
    {
        return ResponseEntity.ok(cocheService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(cocheService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<?> createOne(@RequestBody Coche coche)
    {
        return ResponseEntity.ok(cocheService.createOne(coche));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOne(@PathVariable Long id, @RequestBody Coche coche)
    {
        return ResponseEntity.ok(cocheService.updateOne(id,coche));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(cocheService.deleteOne(id));
    }
}
