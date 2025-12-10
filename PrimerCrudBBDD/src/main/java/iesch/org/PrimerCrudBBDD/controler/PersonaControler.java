package iesch.org.PrimerCrudBBDD.controler;

import iesch.org.PrimerCrudBBDD.model.Persona;
import iesch.org.PrimerCrudBBDD.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaControler {

    @Autowired
    PersonaService personaService;

    @GetMapping
    public List<Persona> getAll(){
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public Persona getById(@PathVariable Long id) {
        return personaService.buscarPorId(id);
    }

    @PostMapping
    public Persona create(@RequestBody Persona p) {
        return personaService.guardarPersona(p);
    }

    @PutMapping("/{id}")
    public Persona update(@PathVariable Long id, @RequestBody Persona nueva) {
        Persona existente =personaService.buscarPorId(id);
        if (existente != null) {
            existente.setNombre(nueva.getNombre());
            existente.setEdad(nueva.getEdad());
            return personaService.guardarPersona(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
       personaService.borrarPersona(id);
    }
}
