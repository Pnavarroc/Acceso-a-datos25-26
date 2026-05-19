package org.example.ejerciciosNivelMediologicaT1.streamObjetosProd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ordenar
{

    /**
     * por stock descendente
     * si tienen el mismo stock, por nombre ascendente
     */


    public static void main(String[] args)
    {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Mesa","Casa", 50.0, 2 ));
        productos.add(new Producto("Silla","Casa", 24.0, 8 ));
        productos.add(new Producto("Balon","Deportes", 12.0, 23 ));
        productos.add(new Producto("Movil","Electronica", 250.0, 55 ));
        productos.add(new Producto("Monitor","Electronica", 150.0, 10 ));

        List<Producto> result = new ArrayList<>();

        result = productos.stream()
                .sorted(
                        Comparator.comparingInt(Producto::getStock).
                                reversed().
                                thenComparing(Producto::getNombre)).
                toList();

        result.forEach((Producto prod)->{
            System.out.println(prod.toString());
        });

        //Lista de productos nombre de categoria y nº de veces que sale categoria en un map.

        Map<String, Long> result2 = productos.stream()
                .collect(
                        Collectors.groupingBy(Producto::getCategoria, Collectors.counting()));

        System.out.println(result2);

    }
}
