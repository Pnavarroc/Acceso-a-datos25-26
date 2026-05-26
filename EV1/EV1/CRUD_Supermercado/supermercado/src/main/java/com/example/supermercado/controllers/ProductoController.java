package com.example.supermercado.controllers;

import com.example.supermercado.model.Producto;
import com.example.supermercado.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController
{
    @Autowired
    ProductoService productoService;


    @GetMapping
    public ResponseEntity<?> getAll()
    {
        return ResponseEntity.ok(productoService.getAll());
    }

    @GetMapping("/{id}")        //path variable es /1(poner el id)
    public ResponseEntity<?> getById(/*@PathVariable*/@PathVariable Long id)
    {
        return ResponseEntity.ok(productoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Producto prod)
    {
        return ResponseEntity.ok(productoService.createProd(prod));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Producto prod)
    {
        return ResponseEntity.ok(productoService.updateProduct(id,prod));
    }

    /*
    GET     /api/productos
    GET     /api/productos/{id}
    POST    /api/productos
    PUT     /api/productos/{id}
    DELETE  /api/productos/{id}
    */

    /**
     * 1. Buscar productos por texto en el nombre
     *
     * Crear un endpoint que permita buscar productos cuyo nombre contenga un texto.
     *
     * GET /api/productos/buscar?nombre=lech
     */

    @GetMapping("/buscar/")
    public ResponseEntity<?> getProdByName(@RequestParam("nombre") String nombre)
    {
        return ResponseEntity.ok(productoService.findByName(nombre));
    }

    /**
     * 2. Buscar productos por precio mayor que una cantidad
     *
     * Crear un endpoint que devuelva todos los productos con precio mayor que el indicado.
     *
     * GET /api/productos/precio-mayor/2.50
     */
    @GetMapping("/precio-mayor/{precio}")
    public ResponseEntity<?> getByPrecioMayorA(@PathVariable Double precio)
    {
        return ResponseEntity.ok(productoService.getProdByPrice(precio));
    }
}
