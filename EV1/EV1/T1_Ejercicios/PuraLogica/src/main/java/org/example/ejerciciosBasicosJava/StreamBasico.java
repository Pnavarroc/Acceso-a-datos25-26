package org.example.ejerciciosBasicosJava;

import java.util.Arrays;
import java.util.List;

public class StreamBasico
{
    public static void main(String[] args)
    {

        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> numerosResult = numeros.stream().filter(n->n%2==0).map(n->n*2).toList();

        System.out.println(numerosResult);

    }
}


/**
 * Obtén una nueva lista con:
 *
 * solo números pares
 * multiplicados por 2
 *
 * Resultado esperado:
 *
 * [4, 8, 12, 16, 20]
 */