package org.iesch.ad.primerSpring.controller;

import org.iesch.ad.primerSpring.model.Producto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")

@RestController
public class ProductosControler {

    @Value("${nombre}")
    private String nombre;


    @PostMapping("/producto")
    public void recibeProducto(@RequestBody Producto producto){
        System.out.println(producto);
    }



    @GetMapping("producto")
    public Producto dameProducto(){

        return new Producto(12,"Choped",2.34F);
    }
}
