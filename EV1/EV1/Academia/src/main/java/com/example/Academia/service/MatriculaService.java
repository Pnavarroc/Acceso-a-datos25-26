package com.example.Academia.service;

import com.example.Academia.model.Alumno;
import com.example.Academia.model.Curso;
import com.example.Academia.model.Matricula;
import com.example.Academia.model.dto.MatriculaDTO;
import com.example.Academia.repository.AlumnoRepository;
import com.example.Academia.repository.CursoRepository;
import com.example.Academia.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculaService
{
    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public List<MatriculaDTO> getAllMatriculas()
    {
        //Conseguimos todas las matriculas, pero necesitamos el dto.
        List<Matricula> matriculas = matriculaRepository.findAll();

        return getMatriculasDTO(matriculas);
    }

    public List<MatriculaDTO> getMatriculasByAlumno(Long idAlumno)
    {
        //return getMatriculasByAlumno(idAlumno);
        List<Matricula> matriculas =  matriculaRepository.findByAlumnoId(idAlumno);

        return getMatriculasDTO(matriculas);
    }

    public List<MatriculaDTO> getMatriculasAprobadas()
    {
        //MatriculasAprobadas:
        List<Matricula> matriculas =  matriculaRepository.findByNotaFinalGreaterThan(4.99);

        return getMatriculasDTO(matriculas);

    }

    public List<MatriculaDTO> getMatriculasByCategoriaCurso(String categoria)
    {
        //Matriculas por categoria
        List<Matricula> matriculas =  matriculaRepository.findByCursoCategoria(categoria);

        return getMatriculasDTO(matriculas);
    }

    public Matricula crearMatricula(Long idAlumno, Long idCurso, Matricula matricula)
    {
        Alumno alumno = alumnoRepository.findById(idAlumno)
                .orElseThrow(()->new RuntimeException("El id del alumno no existe"));

        Curso curso = cursoRepository.findById(idCurso)
                .orElseThrow(()-> new RuntimeException("El id del curso no existe"));

        matricula.setAlumno(alumno);
        matricula.setCurso(curso);
        return matriculaRepository.save(matricula);
    }

    private List<MatriculaDTO> getMatriculasDTO(List<Matricula> matriculas)
    {
        List<MatriculaDTO> matriculasDto = new ArrayList<>();
        for(Matricula matricula: matriculas)
        {
            matriculasDto.add(new MatriculaDTO(matricula.getId(), matricula.getAlumno().getNombre(),
                    matricula.getAlumno().getEmail(), matricula.getCurso().getNombre(), matricula.getCurso().getCategoria(),
                    matricula.getNotaFinal(), matricula.getFecha()));
        }

        return matriculasDto;

    }

}
