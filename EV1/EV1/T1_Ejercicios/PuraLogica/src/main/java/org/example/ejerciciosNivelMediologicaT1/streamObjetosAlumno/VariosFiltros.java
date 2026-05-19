package org.example.ejerciciosNivelMediologicaT1.streamObjetosAlumno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VariosFiltros
{
    /**
     * Crea una lista de alumnos y muestra los alumnos que:
     *
     * sean mayores de edad
     * tengan nota >= 5
     * estén en un curso que contenga "Java"
     */

    public static void main(String[] args)
    {
        List<Alumno> alumnos = new ArrayList<>();

        alumnos.add(new Alumno("Pablo","DAM2",8,21));
        alumnos.add(new Alumno("Saul","ASIR",5,32));
        alumnos.add(new Alumno("Rober","SMR",3,23));
        alumnos.add(new Alumno("Rodrigo","DAM2",5,16));
        alumnos.add(new Alumno("Juanma","DAM2",2,18));
        alumnos.add(new Alumno("Ángel","DAM2",9,35));


        List<Alumno> result = alumnos.stream()
                .filter(a->a.getEdad() >= 18 && a.getNota()>= 5 && a.getCurso().equals("DAM2"))
                .toList();

        //List<String> aprobados = new ArrayList<>();
        //aprobados = getAlumnosByName(alumnos);
        //System.out.println(aprobados);

        List<String> aprobados = alumnos.stream().
                filter(a->a.getNota()>5).
                map(Alumno::getNombre).collect(Collectors.toList());


        result.forEach((alumno ->
        {
            System.out.println(alumno.toString());
        }));

        for(String a : aprobados)
        {
            System.out.println(a);
        }

    }

    private static List<String> getAlumnosByName(List<Alumno> alumnos)
    {
        List<String> alumnosName = new ArrayList<>();

        for (Alumno a: alumnos)
        {
            if(a.getNota()<5) continue;
            alumnosName.add(a.getNombre());

        }

        /*if(a.getNota()<5) return new ArrayList<>();

        alumnosName.add(a.getNombre());*/

        return alumnosName;
    }
}
