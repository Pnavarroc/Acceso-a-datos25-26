package com.example.TallerMecanic.repository;

import com.example.TallerMecanic.model.Estado;
import com.example.TallerMecanic.model.Reparacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReparacionRepository extends JpaRepository<Reparacion,Long>
{

    List<Reparacion> findByVehiculoId(Long vehiculoId);

    List<Reparacion> findByEstado(Estado estado);

    List<Reparacion> findByVehiculoIdAndCosteGreaterThan(Long id, double coste);

    List<Reparacion> findByFechaBetween(LocalDate inicio, LocalDate fin);

    List<Reparacion> findByVehiculoClienteCiudad(String ciudad);

    List<Reparacion> findByVehiculoMarcaAndCosteGreaterThanOrderByFechaDesc(String marca, double coste);
}
