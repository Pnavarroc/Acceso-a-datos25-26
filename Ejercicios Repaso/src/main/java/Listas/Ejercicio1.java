package Listas;

import java.util.ArrayList;
import java.util.List;

//Ej1. Crear una lista de Strings y añadir elementos a ella. Luego, imprimir todos
//los elementos de la lista usando un bucle for-each.
public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<String> diasSemana = new ArrayList<>(List.of("Lunes", "Martes", "Miercoles","Jueves","Viernes"));

        for (String dia : diasSemana){
            System.out.println(dia);
        }
    }
}
