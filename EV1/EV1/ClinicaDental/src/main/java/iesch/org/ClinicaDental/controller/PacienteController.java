package iesch.org.ClinicaDental.controller;

import iesch.org.ClinicaDental.model.Paciente;
import iesch.org.ClinicaDental.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController
{
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes()
    {
        return ResponseEntity.ok(pacienteService.getAll());
    }

    //GET    /api/pacientes/{id}


    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id)
    {
        return ResponseEntity.ok(pacienteService.getById(id));
    }

    //POST   /api/pacientes


    @PostMapping
    public ResponseEntity<Paciente> postPaciente(@RequestBody Paciente paciente)
    {
        return ResponseEntity.status(201).body(pacienteService.createOne(paciente));
    }

    //PUT    /api/pacientes/{id}

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente)
    {
        return ResponseEntity.ok(pacienteService.updateOne(id,paciente));
    }

    //DELETE /api/pacientes/{id}

    @DeleteMapping("/{id}")
    public ResponseEntity deletePaciente(@PathVariable Long id)
    {
        pacienteService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }
}
