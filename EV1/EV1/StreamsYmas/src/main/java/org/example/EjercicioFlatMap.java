package org.example;

import java.util.Arrays;
import java.util.List;

public class EjercicioFlatMap
{
    public static void main(String[] args)
    {
        List<Autor> autores = Arrays.asList(
                new Autor("Gabriel García Márquez", Arrays.asList(
                        new Libro("Cien años de soledad"),
                        new Libro("El amor en los tiempos del cólera"),
                        new Libro("Crónica de una muerte anunciada")
                )),
                new Autor("J.K. Rowling", Arrays.asList(
                        new Libro("Harry Potter y la piedra filosofal"),
                        new Libro("Harry Potter y la cámara secreta"),
                        new Libro("Harry Potter y el prisionero de Azkaban")
                )),
                new Autor("George Orwell", Arrays.asList(
                        new Libro("1984"),
                        new Libro("Rebelión en la granja")
                )),
                new Autor("Stephen King", Arrays.asList(
                        new Libro("It"),
                        new Libro("El resplandor"),
                        new Libro("Misery")
                )),
                new Autor("Agatha Christie", Arrays.asList(
                        new Libro("Asesinato en el Orient Express"),
                        new Libro("Diez negritos")
                )),
                new Autor("J.R.R. Tolkien", Arrays.asList(
                        new Libro("El Señor de los Anillos"),
                        new Libro("El Hobbit"),
                        new Libro("El Silmarillion")
                )),
                new Autor("Isabel Allende", Arrays.asList(
                        new Libro("La casa de los espíritus"),
                        new Libro("Eva Luna")
                )),
                new Autor("Haruki Murakami", Arrays.asList(
                        new Libro("Tokyo Blues"),
                        new Libro("Kafka en la orilla"),
                        new Libro("1Q84")
                )),
                new Autor("Ernest Hemingway", Arrays.asList(
                        new Libro("El viejo y el mar"),
                        new Libro("Por quién doblan las campanas")
                )),
                new Autor("Virginia Woolf", Arrays.asList(
                        new Libro("Al faro"),
                        new Libro("La señora Dalloway")
                ))
        );

        System.out.println("Obtener una lista de todos los titulos de los libros");

        List<String> titulosLibros = autores.stream()
                .flatMap(a-> a.getLibros().stream())
                .map(l-> l.getTitulo()).toList();

        System.out.println(titulosLibros);
    }
}

class Libro {
    String titulo;

    public Libro() {
    }

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}

class Autor {
    String nombre;
    List<Libro> libros;

    public Autor() {
    }

    public Autor(String nombre, List<Libro> libros) {
        this.nombre = nombre;
        this.libros = libros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", libros=" + libros +
                '}';
    }
}
