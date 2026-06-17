package com.example.TallerMecanic.service;

import com.example.TallerMecanic.dto.ReparacionDTO;
import com.example.TallerMecanic.exception.VehiculoNotFoundException;
import com.example.TallerMecanic.model.Estado;
import com.example.TallerMecanic.model.Reparacion;
import com.example.TallerMecanic.model.Vehiculo;
import com.example.TallerMecanic.repository.ReparacionRepository;
import com.example.TallerMecanic.repository.VehiculoRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReparacionesService
{
    @Autowired
    private ReparacionRepository reparacionRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;


    public List<Reparacion> getByVehiculoId(Long vehiculoId)
    {
        Vehiculo vehiculoExistente = vehiculoRepository.findById(vehiculoId).orElseThrow(()->
                new VehiculoNotFoundException("El vehiculo con id "+vehiculoId+ " no existe"));

        return reparacionRepository.findByVehiculoId(vehiculoExistente.getId());
    }

    public List<Reparacion> getByEstado(Estado estado)
    {
        return reparacionRepository.findByEstado(estado);
    }

    public List<Reparacion> getByVehiculoIdAndCoste(Long vehiculoId, double coste)
    {
        Vehiculo vehiculoExistente = vehiculoRepository.findById(vehiculoId).orElseThrow(()->
                new VehiculoNotFoundException("El vehiculo con id "+vehiculoId+ " no existe"));

        return reparacionRepository.findByVehiculoIdAndCosteGreaterThan(vehiculoExistente.getId(),coste);
    }

    public List<Reparacion> getBetweenFechas(LocalDate inicio, LocalDate fin)
    {
        return reparacionRepository.findByFechaBetween(inicio,fin);
    }

    public List<Reparacion> getByClienteCiudadAndFinalizada(String ciudad)
    {
        return reparacionRepository.findByVehiculoClienteCiudad(ciudad);
    }

    public List<Reparacion> getByMarcaYCosteMayor(String marca, double coste)
    {
        return reparacionRepository.findByVehiculoMarcaAndCosteGreaterThanOrderByFechaDesc(marca,coste);
    }

    public List<ReparacionDTO> getAll()
    {
        List<Reparacion> reparaciones = reparacionRepository.findAll();
        List<ReparacionDTO> reparacionesResumen = new ArrayList<>();
        for (Reparacion rp : reparaciones)
        {
            reparacionesResumen.add(
                    new ReparacionDTO(
                            rp.getId(),
                            rp.getFecha(),
                            rp.getCoste(),
                            rp.getVehiculo().getMatricula(),
                            rp.getVehiculo().getCliente().getNombre()));
        }

        return reparacionesResumen;
    }
}
