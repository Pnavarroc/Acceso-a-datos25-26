package EjerciciosGPT;

import java.util.ArrayList;
import java.util.List;

//Crea una lista con palabras de distinta longitud.
//Ordena la lista usando sort y una lambda que compare por longitud de la palabra.
//📌 Pista: (s1, s2) -> s1.length() - s2.length()
public class Ejercicio6 {
    public static void main(String[] args) {
        List<String> listaCompra = new ArrayList<>(List.of("Pechuga", "Pollo","Ganso","Lechuga","Tomate","Arbol","Huevos","Salchichas","Arandanos"));

        listaCompra.sort((p1,p2)->p1.length()-p2.length());
        System.out.println(listaCompra);
    }
}
