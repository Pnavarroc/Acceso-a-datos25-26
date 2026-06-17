package org.example.streamsAlumnos;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Launcher
{
    public static void main(String[] args) {
        List<Alumno> alumnos = List.of(
                new Alumno("Pablo", "DAM", 7.5),
                new Alumno("Lucia", "DAM", 4.2),
                new Alumno("Mario", "DAW", 8.1),
                new Alumno("Sara", "DAM", 9.0),
                new Alumno("Hugo", "ASIR", 5.5),
                new Alumno("Nerea", "DAW", 3.8),
                new Alumno("Ivan", "ASIR", 6.7),
                new Alumno("Claudia", "DAM", 2.9)
        );

        System.out.println("LISTA CON ALUMNOS APROBADOS");

        List<Alumno> alumnosAprobados = alumnos.stream()
                .filter(a -> a.getNota() >= 5.0).toList();

        alumnosAprobados.forEach(a ->
        {
            System.out.println(a);
        });

        System.out.println("NOMBRES DE LOS ALUMNOS SUSPENSOS");

        List<String> alumnosSuspensos = alumnos.stream()
                .filter(a -> a.getNota() < 5)
                .map(a -> a.getNombre()).toList();

        alumnosSuspensos.forEach(a ->
        {
            System.out.println(a);
        });

        System.out.println("ALUMNO CON LA NOTA MAS ALTA");

        Optional<Alumno> notaMasAlta = alumnos.stream()
                .max(Comparator.comparingDouble(Alumno::getNota));

        notaMasAlta.ifPresent(System.out::println);

        System.out.println("NOTA MEDIA");

        Double media = alumnos.stream()
                .collect(Collectors.averagingDouble(Alumno::getNota));

        System.out.println(media);

        System.out.println("ALUMNOS POR CURSO");

        Map<String, List<Alumno>> alumnosPorCurso =
                alumnos.stream()
                        .collect(Collectors.groupingBy(Alumno::getCurso));

        alumnosPorCurso.forEach((curso, alum) ->
        {
            System.out.println(curso + "->" + alum);
        });

        System.out.println("CONTAR ALUMNOS POR CURSO");

        Map<String, Long> alumnosContadorCurso = alumnos
                .stream()
                .collect(Collectors.groupingBy(Alumno::getCurso, Collectors.counting()));

        alumnosContadorCurso.forEach((curso, num) ->
        {
            System.out.println(curso + "->" + num);
        });


        System.out.println("//CREAR FICHERO LLAMADO ALUMNOS.TXT");
        File fichero = new File("src/main/resources/Alumnos.txt");
        guardarAlumnos(fichero, alumnos);

        List<Alumno> alumnosFichero =  crearListaAlumnosDeFichero(fichero);

        System.out.println("Alumnos del fichero");
        alumnosFichero.forEach(a->
        {
            System.out.println(a);
        });

        System.out.println("CREAR FICHERO LLAMADO APROBADOS.TXT Y METER AHI LOS APROBADOS EN EL MISMO FORMATO NOMBRE;CURSO;NOTA");

        crearAprobados(alumnosFichero);

    }

    private static void crearAprobados(List<Alumno> alumnosFichero)
    {
        File file = new File("src/main/resources/AlumnosAprobados.txt");

        //Una vez tenemos el fichero insertamos los alumnos aprobados

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
        {
            List<Alumno> aprobados = alumnosFichero.stream().filter(a-> a.getNota()>=5).toList();

            for (Alumno al: aprobados)
            {
                bw.write(al.getNombre()+";"+al.getCurso()+";"+al.getNota());
                bw.newLine();
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static List<Alumno> crearListaAlumnosDeFichero(File fichero)
    {
        List<Alumno> alumnosFichero = new ArrayList<>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fichero));

            String line ;
            while ((line=br.readLine())!=null)
            {
                String[] partes = line.split(";");
                alumnosFichero.add(new Alumno(partes[0],partes[1], Double.parseDouble(partes[2])));
            }
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return alumnosFichero;
    }

    private static void guardarAlumnos (File fichero, List<Alumno> alumnos)
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fichero)))
        {
            for (Alumno al: alumnos)
            {
                bw.write(al.getNombre()+";"+al.getCurso()+";"+al.getNota());
                bw.newLine();
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
