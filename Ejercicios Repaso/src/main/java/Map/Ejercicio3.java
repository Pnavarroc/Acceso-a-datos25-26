package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Ej3. Dada una lista de estudiantes (donde cada estudiante es un objeto con
propiedades como nombre, edad, grado, etc.), escribir una función que devuelva
un Map donde las claves son los nombres de los estudiantes y los valores son los
objetos de los estudiantes.*/
public class Ejercicio3 {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Pablo",20,"Dam2");
        Estudiante estudiante2 = new Estudiante("Saul",23,"Dam1");
        Estudiante estudiante3 = new Estudiante("Roberto",21,"Dam2");
        Estudiante estudiante4 = new Estudiante("Claudio",40,"Smr2");

        ArrayList<Estudiante> estudiantes= new ArrayList<>(List.of(estudiante1,estudiante2,estudiante3,estudiante4));

        System.out.println("La lista de estudiantes normal: "+ estudiantes);

        System.out.println("La lista de estudiantes map: "+ estudianteMap(estudiantes));


    }
    public static Map<String,Estudiante> estudianteMap(List<Estudiante> estudiantes2){
        Map<String,Estudiante> estudianteMap= new HashMap<>();

        for (Estudiante estudiante: estudiantes2){
            estudianteMap.put(estudiante.getNombre(),estudiante);
        }
        return estudianteMap;

    }
}
