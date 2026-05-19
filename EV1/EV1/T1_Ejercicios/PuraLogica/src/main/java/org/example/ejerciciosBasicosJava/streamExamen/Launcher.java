package org.example.ejerciciosBasicosJava.streamExamen;

import java.util.ArrayList;
import java.util.List;

public class Launcher
{
    public static void main(String[] args)
    {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Toalla",22,"Playa"));
        productos.add(new Producto("Silla",48,"Informatica"));
        productos.add(new Producto("Pelota",5,"Playa"));
        productos.add(new Producto("Monitor",240,"Informatica"));
        productos.add(new Producto("Crema",18,"Playa"));
        productos.add(new Producto("Teclado",46,"Informatica"));

        /**
         * Crea varios productos y:
         *
         * muestra SOLO los productos de categoría "informatica"
         * ordenados de mayor a menor precio
         */

        List<Producto> productosResult =productos.stream().filter(p->p.getCategoria().equals("Informatica")).toList();

        productosResult.forEach((Producto p)->{
            System.out.println(p.getNombre()+"-"+p.getPrecio()+"-"+p.getCategoria());
        });



    }

}


