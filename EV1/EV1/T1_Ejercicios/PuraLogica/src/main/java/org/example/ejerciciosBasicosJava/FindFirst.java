package org.example.ejerciciosBasicosJava;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirst
{
    /**
     * Ejercicio 7 — findFirst
     *
     * Con esta lista:
     *
     * List<Integer> numeros = Arrays.asList(3,5,7,8,9,10);
     * el primer número par
      */


    public static void main(String[] args)
    {
        List<Integer> numeros = Arrays.asList(3,5,7,8,9,10);

        Optional<Integer> numeroResutl = numeros.stream().filter(n-> n%2==0).findFirst();

        System.out.println(numeroResutl);
    }


}
