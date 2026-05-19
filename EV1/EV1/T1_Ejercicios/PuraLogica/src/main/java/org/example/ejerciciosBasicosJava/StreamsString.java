package org.example.ejerciciosBasicosJava;

import java.util.Arrays;
import java.util.List;

public class StreamsString
{
    public static void main(String[] args)
    {
        List<String> nombres = Arrays.asList("Ana", "Pedro", "Antonio", "Lucia", "Alberto");

        List<String> listaNombresResult = nombres.stream().filter(n->n.startsWith("A")).sorted().toList();

        listaNombresResult.forEach((String n)->{
            System.out.println(n);
        });
    }
}

/**
 * solo los nombres que empiezan por "A"
 * ordenados alfabéticamente
 */