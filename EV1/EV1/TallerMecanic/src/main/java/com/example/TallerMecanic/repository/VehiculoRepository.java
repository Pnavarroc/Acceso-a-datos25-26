package com.example.TallerMecanic.repository;

import com.example.TallerMecanic.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>
{

    List<Vehiculo> findByClienteId(Long id);

    List<Vehiculo> findByClienteCiudad(String ciudad);

    List<Vehiculo> findByMarca(String marca);

    List<Vehiculo> findByAnioGreaterThan(int anio);
}
