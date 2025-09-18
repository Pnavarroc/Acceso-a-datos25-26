package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Ej2. Dada una lista de Strings, escribir una función que devuelva un Map donde
las claves son los Strings únicos de la lista y los valores son el número de veces
que cada String aparece en la lista.*/
public class Ejercicio2 {
    public static void main(String[] args) {
        ArrayList<String> diasSemana = new ArrayList<>(List.of("Lunes", "Martes", "Miercoles","Jueves","Viernes","Martes", "Miercoles","Jueves","Viernes", "Sabado","Domingo"));

        System.out.println("Lista normal: " + diasSemana);
        System.out.println("Lista con numero de veces que aparece cada una: "+diasVeces(diasSemana));

    }
    public static Map<String,Integer> diasVeces(List<String> dias){
        Map<String, Integer> contador = new HashMap<>();
        for (String dia: dias){
            if (contador.containsKey(dia)){
                contador.put(dia,contador.get(dia)+1);
            }else contador.put(dia,1);
        }
        return contador;
    }
}
