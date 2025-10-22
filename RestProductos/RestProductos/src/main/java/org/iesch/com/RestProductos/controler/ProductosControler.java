package org.iesch.com.RestProductos.controler;

import org.iesch.com.RestProductos.modelo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
public class ProductosControler {
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
    @GetMapping("/producto")
    public 
}
