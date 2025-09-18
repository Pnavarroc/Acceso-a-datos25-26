package Listas;

import java.util.ArrayList;
import java.util.List;

//Dada una lista de Strings, escribir una función que devuelva la longitud del
//string más largo en la lista.
public class Ejercicio3 {
    public static void main(String[] args) {
        ArrayList<String> diasSemana = new ArrayList<>(List.of("Lunes", "Martes", "Miercoles","Jueves","Viernes"));

        System.out.println(devolverMasLargo(diasSemana));
    }

    public static int devolverMasLargo(List<String> dias){
        int masLargo =0;

        for (String dia: dias ){
            if (dia.length()>masLargo){
                masLargo=dia.length();
            }
        }
        return masLargo;

    }
}
