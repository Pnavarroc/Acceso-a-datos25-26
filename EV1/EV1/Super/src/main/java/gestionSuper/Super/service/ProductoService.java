package gestionSuper.Super.service;

import gestionSuper.Super.models.Producto;
import gestionSuper.Super.repository.ProductoRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService
{
    @Autowired
    private ProductoRepository productoRepository;


    public @Nullable Object getAll()
    {
        return productoRepository.findAll();
    }

    public @Nullable Object getById(Long id)
    {
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new RuntimeException("El id insertado no existe"));
        return producto;
    }
}
