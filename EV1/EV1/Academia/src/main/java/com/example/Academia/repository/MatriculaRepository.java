package com.example.Academia.repository;

import com.example.Academia.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula,Long> {

    List<Matricula> findByAlumnoId(Long id);

    List<Matricula> findByCursoId(Long id);

    List<Matricula> findByNotaFinalGreaterThan(Double nota);

    List<Matricula> findByCursoCategoria(String categoria);
}
