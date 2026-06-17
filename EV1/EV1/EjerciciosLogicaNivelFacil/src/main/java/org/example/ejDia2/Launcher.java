package org.example.ejDia2;

import java.util.*;
import java.util.stream.Collectors;

public class Launcher
{

    public static void main(String[] args)
    {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Leche", 1.20, "Lácteos", 20));
        productos.add(new Producto(2, "Queso", 3.50, "Lácteos", 5));
        productos.add(new Producto(3, "Pan", 0.90, "Panadería", 30));
        productos.add(new Producto(4, "Jamón", 6.80, "Charcutería", 8));
        productos.add(new Producto(5, "Coca Cola", 1.70, "Bebidas", 0));
        productos.add(new Producto(6, "Agua", 0.60, "Bebidas", 50));
        productos.add(new Producto(7, "Chocolate", 2.40, "Dulces", 12));
        productos.add(new Producto(8, "Café", 4.20, "Bebidas", 7));

        System.out.println("PRODUCTOS CON STOCK 0");

        List<Producto> productosNoStock = productos.stream()
                .filter(p-> p.getStock()==0 ).toList();

        productosNoStock.forEach(p->
        {
            System.out.println(p);
        });

        System.out.println("NOMBRES DE PRODUCTOS CATEGORIA BEBIDAS");

        List<String> nombresBebidas = productos.stream()
                .filter(p-> p.getCategoria().equalsIgnoreCase("Bebidas"))
                .map(Producto::getNombre).toList();

        System.out.println(nombresBebidas);

        System.out.println("PRODUCTO MAS CARO");

        Optional<Producto> masCaro = productos.stream()
                .max(Comparator.comparingDouble(Producto::getPrecio));

        masCaro.ifPresent(System.out::println);

        System.out.println("PRECIO MEDIO DE LOS PRODUCTOS");

        Double precioMedio = productos.stream()
                .collect(Collectors.averagingDouble(Producto::getPrecio));

        System.out.println(precioMedio);

        System.out.println("AGRUPAR LOS PRODUCTOS POR CATEGORIA");

        Map<String,Long> agrupadosPorCategoria = productos
                .stream()
                .collect(Collectors.groupingBy(Producto::getCategoria,Collectors.counting()));

        agrupadosPorCategoria.forEach((cat,num)->
        {
            System.out.println(cat+"->"+num);
        });

    }

}
