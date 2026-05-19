package org.example.ejerciciosBasicosJava;

import com.sun.source.doctree.EscapeTree;

import java.util.Arrays;
import java.util.List;

public class FunctionRecibirNumDevolverCuadrado

{
    public static void main(String[] args)
    {
        List<Integer> numeros = Arrays.asList(1,2,3,4);


        List<Integer> numerosResult = numeros.stream().map(n-> cuadrado(n)).toList();

        System.out.println(numerosResult);



    }

    private static Integer cuadrado(Integer number)
    {
        //return number*number;
        return (int) Math.pow(number,2);
    }
}
