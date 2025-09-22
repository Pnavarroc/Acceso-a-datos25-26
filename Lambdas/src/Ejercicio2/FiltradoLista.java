package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class FiltradoLista {
    public static void main(String[] args) {
        List<String> listaCompra = new ArrayList<>(List.of("Pechuga", "Pollo","Ganso","Lechuga","Tomate","Arbol","Huevos","Salchichas","Arandanos"));

        listaCompra.removeIf(nombre->!nombre.startsWith("A"));
        System.out.println("Nombres que solo empiezan por A: "+ listaCompra);
    }
}
