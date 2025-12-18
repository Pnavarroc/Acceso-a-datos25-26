import modelo.Empleado;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        List<Empleado> employees = Arrays.asList(
                new Empleado("Alice", new ArrayList<>(Arrays.asList("Project1", "Project2")), new ArrayList<>(Arrays.asList("Java", "Spring")), 35, 60000),
                new Empleado("Bob", new ArrayList<>(Arrays.asList("Project3")), new ArrayList<>(Arrays.asList("JavaScript", "React")), 28, 45000),
                new Empleado("Charlie", new ArrayList<>(Arrays.asList("Project1", "Project4")), new ArrayList<>(Arrays.asList("Java", "Angular")), 40, 70000),
                new Empleado("David", new ArrayList<>(Arrays.asList("Project2", "Project3", "Project5")), new ArrayList<>(Arrays.asList("Python", "Django")), 32, 80000),
                new Empleado("Eve", new ArrayList<>(Arrays.asList("Project5")), new ArrayList<>(Arrays.asList("Java", "Spring", "Hibernate")), 25, 50000),
                new Empleado("Frank", new ArrayList<>(Arrays.asList("Project1", "Project3")), new ArrayList<>(Arrays.asList("Java", "Spring")), 35, 90000),
                new Empleado("Grace", new ArrayList<>(Arrays.asList("Project2", "Project4")), new ArrayList<>(Arrays.asList("Java", "Spring")), 35, 80000),
                new Empleado("Heidi", new ArrayList<>(Arrays.asList("Project1", "Project3")), new ArrayList<>(Arrays.asList("Java", "Spring")), 35, 38000)
        );


        //1 - Muestra los empleados mayores de 30 años que tengan un salario superior a 50.000.
        List<Empleado> empleadosFiltrados = employees.stream().
                filter(e->e.getEdad()>30 && e.getSalario()>50000).toList();

        System.out.println("1"+ "-".repeat(50));
        System.out.println(empleadosFiltrados);


        //2 - Muestra los empleados agrupados a los empleados según el número de proyectos en los que participan.
        System.out.println("2"+ "-".repeat(50));
        Map<Integer,List<Empleado>> empleadosAgrupadosPorNProyecto = employees.stream().collect(Collectors.groupingBy(
                e->e.getProyectos().size()));
        System.out.println(empleadosAgrupadosPorNProyecto);

        //3 - Indica el número de empleados que poseen cada habilidad.
        System.out.println("3"+ "-".repeat(50));

        Map<String, Long> contadorHabilidades = employees.stream().
            flatMap(e-> e.getHabilidades().stream()).collect(Collectors.groupingBy(
                    skill-> skill, Collectors.counting()));

        System.out.println(contadorHabilidades);

        //4 - Ordenar a los empleados por su salario en orden descendente.
        System.out.println("4"+ "-".repeat(50));

        List<Empleado> empleadosOrdenados = employees.stream().sorted(Comparator.comparingDouble(Empleado::getSalario)).toList().reversed();

        System.out.println(empleadosOrdenados);



        //5 - Encuentra al empleado con el salario más alto.
        System.out.println("5"+ "-".repeat(50));

        Empleado empleadoMayorSueldo = employees.stream().max(Comparator.comparingDouble(Empleado::getSalario)).orElse(null);

        System.out.println(empleadoMayorSueldo);


        //6 - Encuentra al empleado con el salario más bajo que tenga más de 30 años.
        System.out.println("6"+ "-".repeat(50));

        Empleado empleadoMenorSueldo = employees.stream().filter(e->e.getEdad()>30).min(Comparator.comparingDouble(Empleado::getSalario)).orElse(null);

        System.out.println(empleadoMenorSueldo);
        //7 - Encuentra al empleado con el salario más alto que tenga menos de 30 años y que participe en más de un proyecto.
        System.out.println("7"+ "-".repeat(50));

        Empleado empleadoMenos30YMasDeUnProyectoYMayorSueldo = employees.stream().
                filter(e->e.getEdad()<30 && e.getProyectos().size()>1)
                .max(Comparator.comparingDouble(Empleado::getSalario)).orElse(null);

        System.out.println(empleadoMenos30YMasDeUnProyectoYMayorSueldo);


    }

}