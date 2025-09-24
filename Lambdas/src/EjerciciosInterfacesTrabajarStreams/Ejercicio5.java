package EjerciciosInterfacesTrabajarStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
* 5) Filtrar nombres que comienzan con una letra específica: Crea una lista de nombres.
*  Utiliza un “Predicate” para filtrar la lista y mantener solo los nombres que comienzan
* con una letra específica (por ejemplo, "A").*/
public class Ejercicio5 {
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>(Arrays.asList("Pollo","Frito","Lechuga","Tomate","Teclado","Raton"));
        Predicate<String> empiezaCon= palabra-> palabra.startsWith("T");

        List<String> filtrados = palabras.stream().filter(empiezaCon).toList();

        System.out.println(filtrados);

    }
}
