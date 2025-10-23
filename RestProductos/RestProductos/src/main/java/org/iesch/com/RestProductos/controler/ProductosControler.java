package org.iesch.com.RestProductos.controler;

import org.iesch.com.RestProductos.modelo.Product;
import org.iesch.com.RestProductos.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.Map;

@RestController
public class ProductosControler {


    private static  final Logger logger = LoggerFactory.getLogger(ProductosControler.class);



    @Autowired
    ProductoService productoService;
    @Autowired
    Map<Long,Product> productos;

    @GetMapping("/producto")
    public ResponseEntity<?> getTodos(){

        if (productos.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(productos);
        }
    }
    @GetMapping("/producto/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){

        logger.debug("Buscando el producto con id: {} ", id);

        Product product= productoService.getOne(id);


        if (product==null){
            logger.warn("Producto con id: {} no encontrado", id);
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(productos);
        }

    }

    @PostMapping("/producto")
    public ResponseEntity<?> addOne(@RequestBody Product product){
        logger.info("Creando un nuevo producto: {}", product);


        productoService.addOne(product);

        //return ResponseEntity.status(HttpStatus.CREATED).body(product);
        URI location = URI.create("/producto/" + product.getId());
        return ResponseEntity.created(location).body(product);

    }


    @PutMapping("/producto/{id}")
    public ResponseEntity<?> updateOne(@RequestBody Product product,@PathVariable Long id){

        logger.info("Modificando el producto con id: {}", id);
        logger.debug("Datos: {}",product);


        Product productoTmp = productoService.updateOne(product,id);

        if (productoTmp ==null){
            logger.warn("Producto con id: {} no encontrado", id);
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(productoTmp);
        }

    }


    @DeleteMapping("/producto/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id){

        logger.info("Eliminando producto con id: {}",id);

        Product productoTmp = productoService.deleteOne(id);

        if (productoTmp ==null){
            logger.warn("Producto con id: {} no encontrado", id);
            return ResponseEntity.notFound().build();//404
        }else {
            return ResponseEntity.noContent().build();//204
        }
    }

}
