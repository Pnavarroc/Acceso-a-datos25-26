package EjerciciosGPT;

import java.util.ArrayList;
import java.util.List;

//4. Números al cuadrado
//
//Crea una lista con los números del 1 al 5.
//Usa forEach con una lambda para imprimir cada número junto a su cuadrado.
//Ejemplo de salida:
public class Ejercicio4 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        lista.forEach(numero-> System.out.println(numero+" Elevado a dos es:"+numero*numero));

    }
}
