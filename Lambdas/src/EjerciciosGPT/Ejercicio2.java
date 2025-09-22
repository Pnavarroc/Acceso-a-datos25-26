package EjerciciosGPT;

import java.util.ArrayList;
import java.util.List;

/*2. Lista de nombres largos

Crea una lista de nombres.
Usa removeIf para eliminar todos los nombres con menos de 5 letras.
Al final deben quedar solo los largos.*/
public class Ejercicio2 {
    public static void main(String[] args) {
        List<String> listaCompra = new ArrayList<>(List.of("Pechuga", "Pollo","Ganso","Lechuga","Tomate","Arbol","Huevos","Salchichas","Arandanos"));

        listaCompra.removeIf(palabra->palabra.length()<5);
        System.out.println(listaCompra);


    }
}
