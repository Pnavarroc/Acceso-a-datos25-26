package com.example.Academia.repository;

import com.example.Academia.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>
{
    List<Alumno> findByCiudad(String ciudad);

    List<Alumno> findByEdadGreaterThan(Integer edad);

}
