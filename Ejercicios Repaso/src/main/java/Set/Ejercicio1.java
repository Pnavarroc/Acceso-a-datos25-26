package Set;

/*Ej1. Crear un Set de Strings y añadir elementos a él. Luego, imprimir todos los
elementos del Set. ¿Qué observas acerca del orden de los elementos?*/

import java.util.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        Set<String> diasSemana = new HashSet<>(List.of("Lunes", "Martes", "Miercoles","Jueves","Viernes"));

        diasSemana.add("Sabado");
        diasSemana.add("Domingo");

        System.out.println(diasSemana);

        //El HashSet No te deja tener duplicados , Si queremos tenerlos ordenados tenemos que usar otro tipo de Set

        Set<String> diasSemana2 = new LinkedHashSet<>(List.of("Lunes", "Martes", "Miercoles","Jueves","Viernes"));

        diasSemana2.add("Sabado");
        diasSemana2.add("Domingo");

        System.out.println("______________________________________________________________");
        System.out.println(diasSemana2);

        //El LinkedHashSet los ordena por orden de inserción, Y luego tenemos el TreeSet Puede ser orden alfabetico númerico o el que definamos en un comparator

        Set<String> diasSemana3 = new TreeSet<>(List.of("Lunes", "Martes", "Miercoles","Jueves","Viernes"));

        diasSemana3.add("Sabado");
        diasSemana3.add("Domingo");
        System.out.println("______________________________________________________________");

        System.out.println(diasSemana3);

    }
}
