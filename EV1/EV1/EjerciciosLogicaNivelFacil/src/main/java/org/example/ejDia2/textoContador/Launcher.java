package org.example.ejDia2.textoContador;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Launcher
{
    public static void main(String[] args)
    {
        String texto = "java es divertido java es potente spring usa java pero primero hay que dominar java y streams";

        System.out.println("PRIMERO SEPARAR EL TEXTO POR ESPACIOS");
        List<String> palabras = List.of(texto.split(" "));

        System.out.println(palabras);

        System.out.println("CONTAR CUANTAS VECES APARECE CADA PALABRA");

        Map<String,Long> palabrasPorNum = palabras.stream()
                .collect(Collectors.groupingBy(String::toString,Collectors.counting()));

        palabrasPorNum.forEach((palabra,num)->
        {
            System.out.println(palabra+"->"+num);
        });

        System.out.println("Mostrar palabras que aparecen mas de una vez");



    }
}
