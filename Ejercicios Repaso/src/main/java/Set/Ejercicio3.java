package Set;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

//Ej3. Dada una lista de Strings, escribir una función que devuelva un Set que
//contenga solo los Strings únicos de la lista original.
public class Ejercicio3 {
    public static void main(String[] args) {
        ArrayList<String> diasSemana = new ArrayList<>(List.of("Lunes", "Martes", "Miercoles","Jueves","Viernes","Martes", "Miercoles","Jueves","Viernes", "Sabado","Domingo"));

        System.out.println("Dias repetidos: "+diasSemana);
        System.out.println("Dias sin repetidos: "+noReps(diasSemana));
    }
    public static Set<String> noReps(List<String> dias){
        Set<String> unicos= new LinkedHashSet<>(dias);
        return unicos;
    }
}
