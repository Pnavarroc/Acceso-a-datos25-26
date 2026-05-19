package org.example.ejerciciosNivelExamen.lecturaFicheroStreams;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class LecturaFiltrado
{
    private static final String URL = "./src/main/resources/alumnos.txt";

    public static void main(String[] args)
    {
        File file = new File(URL);

        // 1. Conseguir lista de alumnos leyendo el fichero.
        List<Alumno> alumnos = getAlumnos(file);

        // 2. Mostrar alumnos aprobados.

        List<Alumno> aprobados =
                alumnos.stream()
                        .filter(a->a.getNota()>=5)
                        .toList();
        System.out.println("=======Alumnos aprobados=======");
        aprobados.forEach((Alumno a)->{
            System.out.println(a);
        });

        System.out.println("==================alumnos mayores de edad del curso DAM ===================");
        
        List<Alumno> mayoresDam = alumnos
                .stream()
                .filter(a-> a.getEdad() >= 18 && a.getCurso().equals("DAM"))
                .toList();
        
        for (Alumno a: mayoresDam)
        {
            System.out.println(a.toString());
        }

        System.out.println("=========== Nota media ========");

        Double notaMedia = alumnos
                .stream()
                .collect(Collectors.averagingDouble(Alumno::getNota));

        System.out.println(notaMedia);

        System.out.println("=======alumno con mayor nota=====");

        Optional<Alumno> mayorNota = alumnos
                .stream()
                .max(Comparator.comparingDouble(Alumno::getNota));

        System.out.println(mayorNota);

        System.out.println("=====número de alumnos por curso=====");

        Map<String, Long> alumnosPorCurso = alumnos
                .stream()
                .collect(Collectors.groupingBy(Alumno::getCurso, Collectors.counting()));

        alumnosPorCurso.forEach((curso, numero)->{
            System.out.println(curso+"->"+numero);
        });

    }

    private static List<Alumno> getAlumnos(File alumnosTxt)
    {
        List<Alumno> alumnos = new ArrayList<>();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(alumnosTxt));


            String linea ;

            while ((linea = br.readLine())!=null)
            {
                String atributos[];
                atributos = linea.split(";");
                alumnos.add(new Alumno( Integer.parseInt(atributos[0]),atributos[1], atributos[2], Double.parseDouble(atributos[3]), Integer.parseInt(atributos[4])));
            }
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        return alumnos;
    }
}
