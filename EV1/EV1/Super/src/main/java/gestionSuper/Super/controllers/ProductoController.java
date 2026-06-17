package gestionSuper.Super.controllers;

import gestionSuper.Super.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
public class ProductoController
{
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<?> getAllProductos()
    {
        return ResponseEntity.ok(productoService.getAll());
    }

    //Obtener producto por id
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id)
    {
        return ResponseEntity.ok(productoService.getById(id));
    }
}
