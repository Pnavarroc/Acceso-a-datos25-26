package EjerciciosBasicosGPT;

import java.util.Comparator;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
        /*EJERCICIO 1 — Filtrar y transformar (muy típico)

Dada una lista de números:

👉 Obtén una lista con los números pares multiplicados por 10, ordenados de mayor a menor.
Salida esperada:
[200, 100, 20]*/
        List<Integer> nums = List.of(3,10,5,20,7,2);


        List<Integer> resultado =  nums.stream().filter(n->n%2==0).map(n->n*10).sorted(Comparator.reverseOrder()).toList();

        System.out.println(resultado);
    }
}
