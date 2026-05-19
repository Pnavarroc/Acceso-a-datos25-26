package org.example.ejerciciosBasicosJava;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy
{
    public static void main(String[] args) {

        List<String> palabras = Arrays.asList(
                "hola",
                "adios",
                "hola",
                "java",
                "java",
                "java"
        );

        Map<String, Long> palabrasResult = palabras.stream()
                .collect(Collectors.groupingBy((String palabra)-> palabra,
                Collectors.counting()));

        palabrasResult.forEach((palabra, number)->{
            System.out.println(palabra+"--"+number);
        });
    }
}


/**
 *
 */