package com.example.demoJPACoches.service;

import com.example.demoJPACoches.model.Coche;
import com.example.demoJPACoches.repositorio.CocheRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocheService {

    @Autowired
    CocheRepositorio cocheRepositorio;

    public Coche guardar(Coche coche) {
        return cocheRepositorio.save(coche);
    }

    public List<Coche> getAll() {
        return cocheRepositorio.findAll();
    }

    public Coche getById(Long id){
        return cocheRepositorio.findById(id).get();
    }

    public Coche updateOne(Long id, Coche coche){
        Optional<Coche> cocheEnBD = cocheRepositorio.findById(id);
        if (cocheEnBD.isEmpty())return null;
        else {
            coche.setId(id);
            return cocheRepositorio.save(coche);
        }
    }

    public Coche deleteById(Long id) {
        Coche cocheBorrado = cocheRepositorio.findById(id).get();
        cocheRepositorio.deleteById(cocheBorrado.getId());
        return cocheBorrado;
    }

    public List<Coche> getByColor(String color) {

        return cocheRepositorio.buscaPorColor(color);

    }

    public List<Coche> getByColorYmarca(String color, String marca) {
        return cocheRepositorio.findByColorAndMarca(color,marca);

    }

    public List<Coche> getByColorYmarcaYpotenciaMenor(String color, String marca, int potencia) {
        return cocheRepositorio.findByColorAndMarcaAndPotenciaLessThan(color,marca,potencia);

    }
}
