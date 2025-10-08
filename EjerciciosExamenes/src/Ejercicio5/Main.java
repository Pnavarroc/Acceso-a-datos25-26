package Ejercicio5;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/*Crea un String con un contenido bastante largo. Ahora trabaja con dicho String para obtener
por medio de stream el número de ocurrencias de cada palabra.
Consejo: Si quieres simplificarlo mira los métodos de la clase Collectors*/
public class Main {
    public static void main(String[] args) {
        String text = "este es un ejemplo de texto para contar palabras este texto puede ser todo lo largo que quieras";

        Map<String, Long> ocurrencias = Arrays.stream(text.split(" "))
                .collect(Collectors.groupingBy(palabra->palabra, Collectors.counting()));

        ocurrencias.forEach((palabra,cantidad)-> System.out.println(palabra+" "+cantidad));
    }
}
