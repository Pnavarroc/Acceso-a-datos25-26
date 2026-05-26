package com.example.supermercado.service;

import com.example.supermercado.model.Categoria;
import com.example.supermercado.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService
{
    @Autowired
    private CategoriaRepository categoriaRepository;




    public Categoria getCategoriaById(Long id)
    {
        return categoriaRepository.findById(id).orElseThrow(()->new RuntimeException("Erees un payo"));
    }

}
