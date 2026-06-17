package org.example.ejDia2.biblioteca;

import java.util.*;
import java.util.stream.Collectors;

public class Launcher
{
    public static void main(String[] args)
    {

        List<Autor> autores = new ArrayList<>();

        autores.add(new Autor("Carlos Ruiz Zafón", "España", List.of(
                new Libro(12.99, 576, "Novela", "La sombra del viento"),
                new Libro(14.50, 667, "Novela", "El juego del ángel")
        )));

        autores.add(new Autor("George Orwell", "Reino Unido", List.of(
                new Libro(9.99, 328, "Distopía", "1984"),
                new Libro(7.50, 144, "Sátira", "Rebelión en la granja")
        )));

        autores.add(new Autor("J. K. Rowling", "Reino Unido", List.of(
                new Libro(10.99, 300, "Fantasía", "Harry Potter 1"),
                new Libro(11.99, 350, "Fantasía", "Harry Potter 2")
        )));

        System.out.println("MOSTRAR TODOS LOS LIBROS DE TODOS LOS AUTORES");

        List<Libro> libros = autores
                .stream()
                .flatMap(a-> a.getLibros().stream())
                .toList();

        libros.forEach(l->
        {
            System.out.println(l);
        });

        System.out.println("2. Sacar una lista con todos los títulos de libros de género Fantasía");

        List<String> titulosLibrosFantasia = autores.stream()
                .flatMap(a-> a.getLibros().stream().
                        filter(l-> l.getGenero().equalsIgnoreCase("Fantasía"))
                        .map(Libro::getTitulo)
                ).toList();

        System.out.println(titulosLibrosFantasia);

        System.out.println("Contar libros por género");
        Map<String, Long> librosPorGeneroCounter = autores.stream()
                .flatMap(a-> a.getLibros().stream())
                .collect(Collectors.groupingBy(Libro::getGenero, Collectors.counting()));

        librosPorGeneroCounter.forEach((gen,cont)->{
            System.out.println(gen+"->"+cont);
        });

        System.out.println("LIBRO MAS CARO DE TODOS");

        Optional<Libro> masCaro = autores
                .stream()
                .flatMap(a-> a.getLibros().stream())
                .max(Comparator.comparingDouble(Libro::getPrecio));

        masCaro.ifPresent(System.out::println);

        System.out.println("AUTOR CON MAS LIBROS");

        Optional<Autor> autorMasLibros = autores
                .stream()
                .max(Comparator.comparingInt(a-> a.getLibros().size()));

        autorMasLibros.ifPresent(System.out::println);


        System.out.println("AGRUPAR AUTORES POR NACIONALIDAD");

        Map<String, List<Autor>> autoresPorNacionalidad = autores.stream()
                .collect(Collectors.groupingBy(Autor::getNacionalidad));

        autoresPorNacionalidad.forEach((nacionalidad,autors)->
        {
            System.out.println(nacionalidad+"->"+autors);
        });

        System.out.println("PRECIO TOTAL DE TODOS LOS LIBROS");

        Double precioTotal = libros.stream()
                .mapToDouble(Libro::getPrecio)
                .sum();
        System.out.println(precioTotal);

        System.out.println("GÉNEROS CON MÁS DE 1 LIBRO");

        librosPorGeneroCounter.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
