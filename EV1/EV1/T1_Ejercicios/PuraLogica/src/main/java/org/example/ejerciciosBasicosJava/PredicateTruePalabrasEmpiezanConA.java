package org.example.ejerciciosBasicosJava;

import java.util.Arrays;
import java.util.List;

public class PredicateTruePalabrasEmpiezanConA
{
    public static void main(String[] args)
    {
        //List<String> palabras = Arrays.asList("Ana", "Pedro", "Antonio");
        System.out.println("La palabra : Ana comienza por a ???"+startsWithA("Pedro"));

    }

    private static boolean startsWithA( String palabra)
    {
        palabra.toLowerCase();
        return palabra.startsWith("A");
    }
}


/**
 * Crea un Predicate<String> que devuelva true si:
 *
 *     el texto empieza por "A"
 *
 *         Pruébalo con:
 *
 *
 */