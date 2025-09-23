package EjerciciosGPT;

import java.util.ArrayList;
import java.util.List;

//3. Contar vocales en cada palabra
//
//Dada una lista de palabras (["coche","avion","barco","tren"]):
//
//Usa forEach con una lambda para imprimir cada palabra junto con el número de vocales que contiene.
//📌 Ejemplo de salida:
public class Ejercicio10 {
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>(List.of("coche","avion","barco","tren"));

        palabras.forEach(palabra->{
            int contador= (int) palabra.chars().filter(c->"aeiouAEIOU".indexOf(c)!=-1).count();
            System.out.println(palabra+" -> "+ contador);
        });

    }
}
