package org.example.ejerciciosNivelExamen.streams;

import java.util.*;
import java.util.stream.Collectors;

public class Ejercicio1PurosStreams
{

    public static void main(String[] args)
    {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Monitor", "Informatica", 240.0, 12));
        productos.add(new Producto("Teclado", "Informatica", 45.0, 30));
        productos.add(new Producto("Raton", "Informatica", 15.0, 8));
        productos.add(new Producto("Silla", "Casa", 18.0, 20));
        productos.add(new Producto("Mesa", "Casa", 80.0, 5));
        productos.add(new Producto("Lampara", "Casa", 25.0, 14));
        productos.add(new Producto("Balon", "Deportes", 12.0, 40));
        productos.add(new Producto("Raqueta", "Deportes", 60.0, 7));
        productos.add(new Producto("Botella", "Deportes", 10.0, 50));

        //Mostrar todos los productos.
        System.out.println("=================================MOSTRAR TODOS LOS PRODUCTOS===================================");
        productos.forEach((Producto p )->{
            System.out.println(p.toString());
        });

        //Obtener una lista solo con los nombres.
        System.out.println("=================================lista solo con los nombres===================================");
        List<String> nombres = productos.
                stream().map(Producto::getNombre).toList();

        nombres.forEach((String p )->
        {
            System.out.println(p);
        });

        //Mostrar productos con stock menor de 10.
        System.out.println("=================================stock menor de 10.===================================");

        List<Producto> stockMenos10 = productos.stream().
                filter(p->p.getStock()<10).
                toList();

        stockMenos10.forEach((Producto p)->{
            System.out.println(p.toString());
        });
        //Mostrar productos con stock menor de 10 ordenados por stock ascendente.
        System.out.println("=================================stock menor de 10 ordenados por stock ascendente.===================================");

        List<Producto> stockMenos10Ordenado = productos.stream().
                filter(p->p.getStock()<10)
                .sorted(Comparator.comparingInt(Producto::getStock))
                .toList();

        stockMenos10Ordenado.forEach((Producto p)->{
            System.out.println(p.toString());
        });

        //Mostrar productos con stock mayor de 10 ordenados por stock descendente y nombre ascendente.

        System.out.println("=================================stock menor de 10 ordenados por stock descendente y nombre ascendente.===================================");

        List<Producto> stockMenos10OrdenadoDescYNombreAsc = productos.stream().
                filter(p->p.getStock()<10)
                .sorted(Comparator.comparingInt(Producto::getStock).reversed().thenComparing(Producto::getNombre))
                .toList();

        stockMenos10OrdenadoDescYNombreAsc.forEach((Producto p)->
        {
            System.out.println(p.toString());
        });
        //Obtener número de productos por categoría.

        System.out.println("=========================número de productos por categoría===================================");


        Map<String, Long> prodsNumeroCat = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.counting()));

        prodsNumeroCat.forEach((nombre,numero)->{
            System.out.println(nombre+ "->"+numero);
        });
        //Obtener el producto más caro.
        System.out.println("=========================Producto más caro===================================");

        List<Producto> prodMasCaro = productos.stream()
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed()).limit(1).toList();

        System.out.println(prodMasCaro);


        //Calcular el precio medio.
        System.out.println("=========================precio medio.===================================");

        Double precioMedio = productos
                .stream()
                .collect(Collectors.averagingDouble(Producto::getPrecio));

        System.out.println(precioMedio);

        //Obtener productos cuyo precio esté entre 10 y 20.
        System.out.println("=========================productos cuyo precio esté entre 10 y 20..===================================");

        List<Producto> entre10Y20 = productos
                .stream()
                .filter(p-> p.getPrecio() >= 10 && p.getPrecio()<= 20)
                .toList();

        for (Producto pr: entre10Y20)
        {
            System.out.println(pr);
        }
        //Crear una nueva lista con productos de "Informatica" ordenados por precio descendente.
        System.out.println("=========================lista con productos de \"Informatica\" ordenados por precio descendente.===================================");
        List<Producto> informaticaOrdenadosDesc = productos
                .stream()
                .filter(p-> p.getCategoria().equals("Informatica"))
                .sorted(Comparator.comparingDouble(Producto::getPrecio))
                .toList();

        for (Producto pr: informaticaOrdenadosDesc)
        {
            System.out.println(pr);
        }

    }
}
