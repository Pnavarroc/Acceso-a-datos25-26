package Listas;
/*Ej2. Dada una lista de números enteros, escribir una función que devuelva una
nueva lista que contenga solo los números pares de la lista original.*/


import java.util.ArrayList;
import java.util.List;



public class Ejercicio2 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,34,18,98,5,9,19,35));

        System.out.println(pares(numeros));

    }


    public static ArrayList<Integer> pares(ArrayList<Integer> nums){
        ArrayList<Integer> pares = new ArrayList<>();
        for (Integer numero: nums){
            if (numero%2==0){
                pares.add(numero);
            }
        }
        return pares;
    }

}
