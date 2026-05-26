package com.example.Academia.controller;

import com.example.Academia.model.Matricula;
import com.example.Academia.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController
{
    @Autowired
    private MatriculaService matriculaService;

    //Get all matriculas:

    @GetMapping
    public ResponseEntity<?> getAllMatriculas()
    {
        return ResponseEntity.ok((matriculaService.getAllMatriculas()));
    }

    @GetMapping("/alumno/{idAlumno}")
    public ResponseEntity<?> getMatriculasByAlumnoId(@PathVariable Long idAlumno)
    {
        return ResponseEntity.ok(matriculaService.getMatriculasByAlumno(idAlumno));
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<?> getMatriculasByCursoCategoria(@PathVariable String categoria)
    {
        return ResponseEntity.ok(matriculaService.getMatriculasByCategoriaCurso(categoria));
    }


    @PostMapping("/alumno/{idAlumno}/curso/{idCurso}")
    public ResponseEntity<?> createMatricula(@PathVariable Long idAlumno,
                                             @PathVariable Long idCurso,
                                             @RequestBody Matricula matricula)
    {
        return ResponseEntity.ok(matriculaService.crearMatricula(idAlumno,idCurso,matricula));
    }



}
