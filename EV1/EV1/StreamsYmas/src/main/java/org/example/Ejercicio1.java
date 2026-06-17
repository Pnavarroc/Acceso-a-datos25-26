package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Ejercicio1
{

    public static void main(String[] args)
    {
        List<Alumno> alumnos = List.of(
                new Alumno("Pablo", "DAM", 7.5),
                new Alumno("Lucia", "DAM", 4.2),
                new Alumno("Mario", "DAW", 8.1),
                new Alumno("Sara", "DAM", 9.0),
                new Alumno("Hugo", "ASIR", 5.5)
        );

        System.out.println("Lista de los alumnos aprobados sacar solo nombres");

        List<String> aprobados = alumnos.stream().filter(a-> a.getNota()>=5 && a.getCurso().equalsIgnoreCase("DAM"))
                .map(Alumno::getNombre).toList();

        aprobados.forEach(a->
        {
            System.out.println(a);
        });

        System.out.println("Contar alumnos aprobados");

        Long aprobadosNum = alumnos.stream().filter(a-> a.getNota()>=5).count();

        System.out.println(aprobadosNum);

        System.out.println("Obtener alumno con mayor nota");

        Optional<Alumno> mayorNota = alumnos.stream()
                .max(Comparator.comparingDouble(Alumno::getNota));

        mayorNota.ifPresent(System.out::println);

        System.out.println("Nota media de los alumnos");

        Double notaMedia = alumnos.stream()
                .collect(Collectors.averagingDouble(Alumno::getNota));

        System.out.println(notaMedia);

        System.out.println("Agrupar alumnos por curso");

        Map<String, List<Alumno>> alumnosPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

        alumnosPorCurso.forEach((c,a)->
        {
            System.out.println(c+"="+a);
        });

        System.out.println("Obtener cuantos alumnos hay por curso");

        Map<String, Long> alumnosPorCursoNum = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso, Collectors.counting()));

        alumnosPorCursoNum.forEach((c,a)->
        {
            System.out.println(c+"="+a);
        });

        System.out.println("Obtener la nota media de cada curso");

        Map<String, Double> mediaNotasPorCurso= alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso, Collectors.averagingDouble(Alumno::getNota)));

        mediaNotasPorCurso.forEach((c,a)->
        {
            System.out.println(c+"="+a);
        });

        System.out.println("Nombre y nota");

        Map<String, Double> nombreNota = alumnos.stream()
                .collect(Collectors.toMap(Alumno::getNombre,Alumno::getNota));

        nombreNota.forEach((nombre,nota)->
        {
            System.out.println(nombre+"="+nota);
        });


        String texto =
                "java spring java mysql java mongodb spring";

        System.out.println("Contar el numero de apariciones de cada letra del texto");

        String[] arrayTexto = texto.split(" ");

        Map<String, Long> palabraNumVeces = Arrays.stream(arrayTexto).collect(Collectors.groupingBy(String::valueOf,Collectors.counting()));

        System.out.println(palabraNumVeces);
    }
}
