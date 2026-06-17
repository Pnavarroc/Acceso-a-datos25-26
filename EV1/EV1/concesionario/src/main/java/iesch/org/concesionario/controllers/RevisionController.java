package iesch.org.concesionario.controllers;

import iesch.org.concesionario.models.Revision;
import iesch.org.concesionario.service.RevisionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/revisiones")
public class RevisionController
{
    @Autowired
    private RevisionesService revisionService;

    @GetMapping
    public ResponseEntity<?> getAllClients()
    {
        return ResponseEntity.ok(revisionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(revisionService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<?> createOne(@RequestBody Revision revision)
    {
        return ResponseEntity.ok(revisionService.createOne(revision));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOne(@PathVariable Long id, @RequestBody Revision revision)
    {
        return ResponseEntity.ok(revisionService.updateOne(id,revision));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(revisionService.deleteOne(id));
    }
}
