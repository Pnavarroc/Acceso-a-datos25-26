package EjerciciosGPT;

import java.util.ArrayList;
import java.util.List;

/*1. Lista de números pares

Crea una lista de enteros del 1 al 10.
Usa removeIf para dejar solo los números pares.
📌 Pista: n -> n % 2 != 0 elimina los impares.*/
public class Ejercicio1 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));

        lista.removeIf(numero->numero%2!=0);
        System.out.println(lista);

    }
}
