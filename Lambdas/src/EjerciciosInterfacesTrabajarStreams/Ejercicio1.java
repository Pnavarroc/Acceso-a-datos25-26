package EjerciciosInterfacesTrabajarStreams;

/*
*1) Filtrar números impares: Crea una lista de números enteros. Utiliza un “Predicate”
para filtrar la lista y eliminar todos los números impares. */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ejercicio1 {
    public static void main(String[] args) {
        List<Integer> lista= new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
        Predicate<Integer> esPar = num->num%2!=0;

        lista.removeIf(esPar);
        System.out.println(lista);


        /*Esta es la forma con Streams
        * List<Integer> listaPares =lista.stream().filter(numero->numero%2==0 ).toList();
        System.out.println(listaPares);
        *
        * */

    }
}
