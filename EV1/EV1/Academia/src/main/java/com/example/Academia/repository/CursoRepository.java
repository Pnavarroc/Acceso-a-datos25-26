package com.example.Academia.repository;

import com.example.Academia.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long>
{
    List<Curso> findByCategoria(String categoria);

    List<Curso> findByPrecioLessThanEqual(Double precio);

}
