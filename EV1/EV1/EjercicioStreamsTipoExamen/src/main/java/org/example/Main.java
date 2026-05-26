package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        List<Libro> libros = List.of(
                new Libro("El código limpio", "Programacion", 450, 39.99, new Autor("Robert Martin", "USA", 72)),
                new Libro("Java Básico", "Programacion", 300, 24.99, new Autor("Ana Lopez", "España", 41)),
                new Libro("Mongo para todos", "Bases de datos", 220, 19.99, new Autor("Carlos Ruiz", "España", 35)),
                new Libro("Spring Boot Pro", "Programacion", 520, 44.99, new Autor("Laura Perez", "Mexico", 38)),
                new Libro("SQL Avanzado", "Bases de datos", 390, 29.99, new Autor("Miguel Torres", "España", 50)),
                new Libro("Docker desde cero", "DevOps", 280, 21.50, new Autor("John Smith", "UK", 45)),
                new Libro("Kubernetes Fácil", "DevOps", 610, 55.00, new Autor("Emily Brown", "USA", 39))
        );

        /*Obtener todos los libros del género "Programacion".
        */

        List<Libro> librosProgramacion = libros.stream()
                .filter(l->l.getGenero().equalsIgnoreCase("Programacion")).toList();

        librosProgramacion.forEach((Libro libro)->{
            System.out.println(libro);
        });

        /*Obtener solo los títulos de libros con más de 300 páginas.
        */

        System.out.println("Libros mas de 300 pags");
        List<Libro> librosMasDe300Paginas = libros.stream()
                .filter(l->l.getPaginas()>300)
                .toList();

        librosMasDe300Paginas.forEach((Libro libro)->{
            System.out.println(libro);
        });

        /*Obtener libros ordenados por precio de menor a mayor.
       */

        System.out.println("Ordenados por precio menor a mayor");
        List<Libro> librosOrdenadosPrecio = libros.stream()
                .sorted(Comparator.comparingDouble(Libro::getPrecio))
                .toList();

        librosOrdenadosPrecio.forEach((Libro libro)->{
            System.out.println(libro);
        });

        /* Calcular el precio medio de todos los libros.
        Agrupar libros por género.
        Contar cuántos libros hay por país del autor.
        Obtener el libro más caro.
        Comprobar si hay algún libro de más de 600 páginas.
        Obtener los nombres de autores españoles sin repetir.
        Obtener la suma total de páginas de todos los libros.*/
        System.out.println("Calcular el precio medio de todos los libros.");

        OptionalDouble precioMedio = libros.stream()
                .mapToDouble(Libro::getPrecio).average();

        precioMedio.ifPresent(System.out::println);

        /* Agrupar libros por género.
        */
        System.out.println("Agrupar libros por genero");

        Map<String, Long> librosGenero = libros
                .stream()
                .collect(Collectors.groupingBy(Libro::getGenero, Collectors.counting()));

        librosGenero.forEach((genero, num)->{
            System.out.println(num+" ->"+ genero);
        });

        /*Contar cuántos libros hay por país del autor.
        */

        System.out.println("Contar cuántos libros hay por país del autor.");

        Map<String,Long> paisNumeroPorAutor = libros
                .stream()
                .collect(Collectors.groupingBy(libro -> libro.getAutor().getPais(), Collectors.counting()));

        paisNumeroPorAutor.forEach((pais, num)->{
            System.out.println(num+" ->"+ pais);
        });

        /*
        *Obtener el libro más caro.
        */

        System.out.println("Obtener el libro más caro.");

        Optional<Libro> libroMasCaro = libros
                .stream()
                .max(Comparator.comparingDouble(Libro::getPrecio));

        libroMasCaro.ifPresent(System.out::println);

        /* Comprobar si hay algún libro de más de 600 páginas.
        */

        System.out.println("Comprobar si hay algún libro de más de 600 páginas.");

        Boolean hayAlgunLibroDeMasDe600Paginas = libros
                .stream()
                .anyMatch(l-> l.getPaginas()>600);

        System.out.println(hayAlgunLibroDeMasDe600Paginas);

        /*Obtener los nombres de autores españoles sin repetir.
        */

        System.out.println("Obtener los nombres de autores españoles sin repetir.");

        List<Libro> autoresEspañolesSinRepetir = libros
                .stream()
                .sorted(Comparator.comparing(l-> l.getAutor().getNombre())).distinct().toList();

        autoresEspañolesSinRepetir.forEach((libro)->{
            System.out.println(libro.getAutor().getNombre());
        });

        /*Obtener la suma total de páginas de todos los libros.*/
        System.out.println("Obtener la suma total de páginas de todos los libros.");

        IntSummaryStatistics sumaTotalPaginas = libros
                .stream()
                .collect(Collectors.summarizingInt(Libro::getPaginas));

        System.out.println(sumaTotalPaginas);
    }
}