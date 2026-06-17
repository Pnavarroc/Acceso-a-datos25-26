package com.example.TallerMecanic.service;

import com.example.TallerMecanic.exception.VehiculoNotFoundException;
import com.example.TallerMecanic.model.Cliente;
import com.example.TallerMecanic.model.Vehiculo;
import com.example.TallerMecanic.repository.ClienteRepository;
import com.example.TallerMecanic.repository.VehiculoRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService
{
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Vehiculo> getAll()
    {
        return vehiculoRepository.findAll();
    }

    public Vehiculo getById(Long id)
    {
        return vehiculoRepository.findById(id).orElseThrow(()->
                new VehiculoNotFoundException("El vehiculo con id "+ id+ " no existe"));
    }

    public Vehiculo createOne(Vehiculo vehiculo)
    {
        Cliente clienteExistente = clienteRepository.findById(vehiculo.getCliente().getId()).orElseThrow(()->
                new VehiculoNotFoundException("El cliente con id "+vehiculo.getCliente().getId()+ " no existe"));

        vehiculo.setCliente(clienteExistente);
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo updateOne(Long id, Vehiculo vehiculo)
    {
        Cliente clienteExistente = clienteRepository.findById(vehiculo.getCliente().getId()).orElseThrow(()->
                new VehiculoNotFoundException("El cliente con id "+vehiculo.getCliente().getId()+ " no existe"));

        Vehiculo vehiculoExistente = vehiculoRepository.findById(id).orElseThrow(()->
                new VehiculoNotFoundException("El vehiculo con id "+ id+ " no existe"));

        vehiculoExistente.setId(id);
        vehiculoExistente.setCliente(clienteExistente);
        vehiculoExistente.setMarca(vehiculo.getMarca());
        vehiculoExistente.setModelo(vehiculo.getModelo());
        vehiculoExistente.setAnio(vehiculo.getAnio());
        vehiculoExistente.setMatricula(vehiculo.getMatricula());

        return vehiculoRepository.save(vehiculoExistente);
    }

    public void deleteOne(Long id)
    {
        Vehiculo vehiculoExistente = vehiculoRepository.findById(id).orElseThrow(()->
                new VehiculoNotFoundException("El vehiculo con id "+ id+ " no existe"));

        vehiculoRepository.deleteById(id);
    }

    public List<Vehiculo> getVehiculosByClienteId(Long clienteId)
    {
        Cliente clienteExistente = clienteRepository.findById(clienteId).orElseThrow(()->
                new VehiculoNotFoundException("El cliente con id "+ clienteId+ " no existe"));

        return vehiculoRepository.findByClienteId(clienteExistente.getId());
    }

    public List<Vehiculo> getVehiculosByClienteCiudad(String ciudad)
    {
        return vehiculoRepository.findByClienteCiudad(ciudad);
    }

    public List<Vehiculo> getVehiculosByMarca(String marca)
    {
        return vehiculoRepository.findByMarca(marca);
    }

    public List<Vehiculo> getByAnioDespues(int anio)
    {
        return vehiculoRepository.findByAnioGreaterThan(anio);
    }
}
