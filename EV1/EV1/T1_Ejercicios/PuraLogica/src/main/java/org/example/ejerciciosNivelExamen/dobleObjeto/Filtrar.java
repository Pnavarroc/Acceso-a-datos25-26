package org.example.ejerciciosNivelExamen.dobleObjeto;

import java.util.*;
import java.util.stream.Collectors;

public class Filtrar
{
    public static void main(String[] args)
    {
        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona(
                "Pablo",
                "111A",
                Arrays.asList(
                        new Coche("BMW", "Rojo", "AAA111"),
                        new Coche("Audi", "Negro", "BBB222")
                )
        ));

        personas.add(new Persona(
                "Ana",
                "222B",
                Arrays.asList(
                        new Coche("Opel", "Blanco", "CCC333"),
                        new Coche("Seat", "Rojo", "DDD444")
                )
        ));

        personas.add(new Persona(
                "Luis",
                "333C",
                Arrays.asList(
                        new Coche("Ford", "Azul", "EEE555")
                )
        ));

        personas.add(new Persona(
                "Marta",
                "444D",
                Arrays.asList(
                        new Coche("Opel", "Rojo", "FFF666"),
                        new Coche("BMW", "Blanco", "GGG777"),
                        new Coche("Seat", "Negro", "HHH888")
                )
        ));

        // Personas con coche rojo.
        System.out.println("Personas con coche rojo");

        List<Persona> personasConCocheRojo = personas
                .stream()
                .filter(p-> p.getCoches().stream().anyMatch(c-> c.getColor().equals("Rojo"))).toList();

        personasConCocheRojo.forEach(p->{
            System.out.println(p.toString());
        });


        System.out.println("Mostrar personas que tengan algún Opel.");

        List<Persona> personasConOpel =
                personas.stream()
                        .filter(p-> p.getCoches()
                                .stream()
                                .anyMatch(c-> c.getMarca().equals("Opel"))).toList();

        personasConOpel.forEach(p->{
            System.out.println(p.toString());
        });

        System.out.println("persona con mas coches");

        Optional<Persona> personaConMasCoches =
                personas.stream()
                        .max(Comparator.comparingInt(p-> p.getCoches().size()));

        personaConMasCoches.ifPresent(System.out::println);

        System.out.println("Mostrar TODAS las matrículas sin repetir.");

        List<String> matriculasSinRepetir = personas
                .stream()
                .flatMap(p-> p.getCoches().stream().map(c-> c.getMatricula()).distinct()).toList();

        for(String matricula: matriculasSinRepetir)
        {
            System.out.println(matricula);
        }

        System.out.println("Mostrar cuántos coches hay de cada color.");

        Map<String, Long> colorNumero = personas
                .stream()
                .flatMap(p-> p.getCoches().stream())
                .collect(Collectors.groupingBy(Coche::getColor, Collectors.counting()));

        System.out.println(colorNumero);

        System.out.println("Solo lista de marcas de coches y ordenadas alfabeticamente sin repetir");

        List<String> marcas = personas
                .stream()
                .flatMap(p-> p.getCoches().stream())
                .map(Coche::getMarca)
                .sorted().toList();

        System.out.println(marcas);
    }
}
