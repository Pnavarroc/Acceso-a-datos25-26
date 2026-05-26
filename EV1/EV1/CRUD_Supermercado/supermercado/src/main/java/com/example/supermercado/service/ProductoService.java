package com.example.supermercado.service;

import com.example.supermercado.model.Categoria;
import com.example.supermercado.model.Producto;
import com.example.supermercado.repository.ProductoRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService
{
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaService categoriaService;

    public List<Producto> getAll()
    {
        List<Producto> response =  productoRepository.findAll();
        return response;
    }

    public Producto getById(Long id)
    {
        Optional<Producto> response = productoRepository.findById(id);

        return response.orElseThrow(()-> new RuntimeException("Eres un payo y has metido un id que no existe"));

    }

    public Producto createProd(Producto prod)
    {
        //Conseguir categoria del prod
        Long catId = prod.getCategoria().getId();

        Categoria cat = categoriaService.getCategoriaById(catId);

        prod.setCategoria(cat);

        return productoRepository.save(prod);
    }

    public Producto updateProduct(Long id, Producto prod)
    {
        // el id pasado existe ??
        Producto prodResp = productoRepository.findById(id).orElseThrow(()->new RuntimeException("Eres un payo el id no existe"));

        //Si existe ese id modificamos el producto con ese id.

        prodResp.setNombre(prod.getNombre());
        prodResp.setPrecio(prod.getPrecio());

        if(prod.getCategoria() == null || prod.getCategoria().getId() == null)
        {
            throw new RuntimeException("Debes indicar una categoría válida");
        }

        Categoria cat = categoriaService.getCategoriaById(prod.getCategoria().getId());
        prodResp.setCategoria(cat);

        return productoRepository.save(prodResp);
    }

    public List<Producto> findByName(String nombre)
    {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Producto> getProdByPrice(Double precio)
    {
        return productoRepository.findByPrecioGreaterThan(precio);
    }
}
