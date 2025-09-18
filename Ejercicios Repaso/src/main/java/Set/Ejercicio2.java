package Set;

import java.util.*;

/*Ej2. Dada una lista de números enteros, escribir una función que devuelva un
Set que contenga solo los números únicos de la lista original.*/
public class Ejercicio2 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,34,4,6,8,2,1,4,35,18,98,5,9,19,35));

        System.out.println("Lista Con repetidos: "+numeros);
        System.out.println("Lista Sin repetidos: "+noRepes(numeros));
    }

    public static Set<Integer> noRepes(List<Integer> repes){
        Set<Integer> noReps= new LinkedHashSet<>(repes);
        return noReps;
    }
}
