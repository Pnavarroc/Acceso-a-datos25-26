package org.example.Bloque1Hora;

import java.util.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        //2️⃣ Eliminar duplicados manteniendo orden
        //Dado un array:
        //int[] datos = {1, 2, 2, 3, 1, 4};
        //Resultado:
        //[1, 2, 3, 4]
        //📌 Condición:
        //No ordenar
        //Mantener el orden original
        //Usa ArrayList o LinkedHashSet

        int[] datos = {1, 2, 2, 3, 1, 4};

        Set<Integer> datosSinDuplicados = new LinkedHashSet<>();
        for(int n : datos){
            datosSinDuplicados.add(n);
        }

        System.out.println(datosSinDuplicados);
    }
}
