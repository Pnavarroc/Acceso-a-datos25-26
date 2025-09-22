package EjerciciosGPT;

import java.util.ArrayList;
import java.util.List;

/*3. Transformar a mayúsculas

Crea una lista de palabras (["java", "lambda", "stream"]).
Usa forEach con una lambda para imprimirlas en mayúsculas.
📌 Pista: s -> System.out.println(s.toUpperCase())*/
public class Ejercicio3 {
    public static void main(String[] args) {

        List<String> listaCompra = new ArrayList<>(List.of("Pechuga", "Pollo","Ganso","Lechuga","Tomate","Arbol","Huevos","Salchichas","Arandanos"));
        listaCompra.forEach(palabra-> System.out.println(palabra.toUpperCase()));
        System.out.println("------------------------------------");
        System.out.println(listaCompra);
    }
}
