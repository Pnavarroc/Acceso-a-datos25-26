package EjerciciosInterfacesTrabajarStreams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*2) Imprimir todos los elementos de una lista: Crea una lista de cadenas. Utiliza un “Consumer”
 para imprimir cada cadena en la lista.*/
public class Ejercicio2 {
    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("Pollo","Frito","Lechuga","Tomate","Teclado","Raton");

        Consumer<String> imprimir = palabra-> System.out.println(palabra);

        palabras.forEach(imprimir);

    }
}
