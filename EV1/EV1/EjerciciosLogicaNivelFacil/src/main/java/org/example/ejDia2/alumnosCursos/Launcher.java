package org.example.ejDia2.alumnosCursos;
import java.awt.desktop.OpenFilesEvent;
import java.util.*;
import java.util.stream.Collectors;

public class Launcher
{
    public static void main(String[] args)
    {

        List<Alumno> listaAlumnos = new ArrayList<>();

        listaAlumnos.add(new Alumno(1, "Ana", "García López", "1º DAM", 8.5, 19));
        listaAlumnos.add(new Alumno(2, "Luis", "Martínez Gómez", "1º DAM", 6.2, 21));
        listaAlumnos.add(new Alumno(3, "María", "Rodríguez Pérez", "2º DAW", 9.1, 23));
        listaAlumnos.add(new Alumno(4, "Carlos", "Sánchez Fernández", "1º DAM", 4.7, 18));
        listaAlumnos.add(new Alumno(5, "Elena", "Ruiz Martín", "2º DAW", 7.8, 20));
        listaAlumnos.add(new Alumno(6, "Jorge", "Díaz Álvarez", "1º DAM", 5.5, 25));
        listaAlumnos.add(new Alumno(7, "Sofía", "Moreno Jiménez", "2º DAW", 8.9, 22));
        listaAlumnos.add(new Alumno(8, "Pedro", "Alonso Ruiz", "1º DAM", 3.2, 19));
        listaAlumnos.add(new Alumno(9, "Lucía", "Serrano Torres", "2º DAW", 10.0, 24));
        listaAlumnos.add(new Alumno(10, "Diego", "Ramírez Muñoz", "Administracion", 6.8, 20));

        System.out.println("ALUMNOS APROBADOS");

        List<Alumno> aprobados = listaAlumnos.stream()
                .filter(a-> a.getNota()>=5).toList();

        aprobados.forEach(a->
        {
            System.out.println(a);
        });

        System.out.println("ALUMNOS MAYORES DE EDAD Y QUE ESTEN EN UN CURSO QUE COMIENCE POR 'A'");

        List<Alumno> alumnosMayoresCursoStartsWithA = listaAlumnos
                .stream()
                .filter(a-> a.getEdad() >= 18 && a.getCurso().startsWith("A"))
                .toList();

        alumnosMayoresCursoStartsWithA.forEach(a->
        {
            System.out.println(a);
        });

        System.out.println("CONTAR ALUMNOS POR CURSO");
        Map<String,Long> alumnosPorCurso = listaAlumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso,Collectors.counting()));

        alumnosPorCurso.forEach((curso,num)->
        {
            System.out.println(curso+"->"+num);
        });

        System.out.println("Obtener el alumno con mayor nota.");

        Optional<Alumno> mayorNotaAlumno = listaAlumnos.stream().max(Comparator.comparingDouble(Alumno::getNota));

        mayorNotaAlumno.ifPresent(System.out::println);

        System.out.println("Crear una lista nueva con los alumnos que tengan nota mayor o igual a 8.");

        List<Alumno> alumnosNotasMas8 = listaAlumnos.stream().filter(a-> a.getNota()>=8.0).toList();


        alumnosNotasMas8.forEach(a->
        {
            System.out.println(a);
        });

        System.out.println("Mostrar solo nombre y nota de los alumnos ordenados de mayor a menor nota.");

        List<Alumno> alumnosOrdenados = listaAlumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed()).toList();

        alumnosOrdenados.forEach(a->
        {
            System.out.println(a.getNombre()+" "+a.getNota());
        });

    }
}
