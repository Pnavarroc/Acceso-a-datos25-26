package org.example.ejDia2.personasCoches;
import java.util.*;
import java.util.stream.Collectors;

public class Launcher
{
    public static void main(String[] args)
    {
        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona("Carlos Gómez", "12345678A", Arrays.asList(
                new Coche("Opel", "Negro", "1111AAA"),
                new Coche("Seat", "Rojo", "2222BBB")
        )));

        personas.add(new Persona("Ana López", "87654321B", Arrays.asList(
                new Coche("BMW", "Azul", "3333CCC"),
                new Coche("Audi", "Blanco", "4444DDD"),
                new Coche("Opel", "Rojo", "5555EEE")
        )));

        personas.add(new Persona("Luis Martínez", "56781234C", Arrays.asList(
                new Coche("Ford", "Rojo", "6666FFF")
        )));

        personas.add(new Persona("María Ruiz", "43218765D", Arrays.asList(
                new Coche("Opel", "Gris", "7777GGG")
        )));

        personas.add(new Persona("Javier Sanz", "98765432E", new ArrayList<>()));

        System.out.println("PERSONAS CON COCHES ROJOS");

        List<Persona> personasConCocheRojo = personas.stream()
                .filter(p-> p.getCoches().
                        stream().
                        anyMatch(c-> c.getColor().equalsIgnoreCase("Rojo")))
                .toList();

        personasConCocheRojo.forEach(p->
        {
            System.out.println(p);
        });

        System.out.println("PERSONAS CON OPEL");

        List<Persona> personasConOpel = personas.stream()
                .filter(p-> p.getCoches().stream()
                        .anyMatch(c-> c.getMatricula().equalsIgnoreCase("Opel")))
                .toList();


        personasConOpel.forEach(p->
        {
            System.out.println(p);
        });

        System.out.println("PERSONA CON MAS COCHES");

        Optional<Persona> personasConMasCoches = personas.stream()
                .max(Comparator.comparingInt(p-> p.getCoches().size()));

        personasConMasCoches.ifPresent(System.out::println);

        System.out.println("Sacar todas las matriculas");

        List<String> matriculas = personas.stream()
                .flatMap(p -> p.getCoches().stream())
                .map(Coche::getMatricula)
                .toList();

        matriculas.forEach(System.out::println);

        /*List<String> matriculas = personas
                .stream()
                .filter(p-> !p.getCoches().isEmpty())
                .collect(Collectors.groupingBy())*/

        System.out.println("CONTAR CUANTOS COCHES HAY DE CADA MARCA");

        Map<String, Long> cochesPorMarca = personas.stream()
                .flatMap(p -> p.getCoches().stream())
                .collect(Collectors.groupingBy(Coche::getMarca, Collectors.counting()));

        cochesPorMarca.forEach((marca, cantidad) -> {
            System.out.println(marca + " -> " + cantidad);
        });


    }
}
