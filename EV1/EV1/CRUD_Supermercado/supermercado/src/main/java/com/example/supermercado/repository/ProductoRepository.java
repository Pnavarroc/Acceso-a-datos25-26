package com.example.supermercado.repository;

import com.example.supermercado.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>
{
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    List<Producto> findByPrecioGreaterThan(Double precio);
}
