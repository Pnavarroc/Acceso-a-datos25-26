package EjerciciosBasicosGPT;

import java.util.List;
import java.util.Locale;

public class Ejercicio2 {
    public static void main(String[] args) {
        /*Dada una lista:

List<String> palabras = List.of("casa", "sol", "perro", "sol", "coche");
👉 Obtén cuántas veces aparece “sol”.*/
        List<String> palabras = List.of("casa", "sol", "perro", "sol", "coche");

        long resultado = palabras.stream().filter(p->p.equalsIgnoreCase("sol")).count();

        System.out.println(resultado);

    }
}
