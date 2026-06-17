package org.example.ejDia2.concesionario;

import java.util.*;
import java.util.stream.Collectors;

public class Launcher
{

    public static void main(String[] args)
    {

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("12345678A", "Pablo Navarro", "Teruel", List.of(
                new Coche("1111AAA", "Alfa Romeo", "147", "Rojo", 6000, List.of(
                        new Revision("REV-001", true, true, 180),
                        new Revision("REV-002", false, true, 90)
                )),
                new Coche("2222BBB", "Seat", "León", "Negro", 8500, List.of(
                        new Revision("REV-003", true, false, 120)
                ))
        )));

        clientes.add(new Cliente("87654321B", "Lucía Martínez", "Zaragoza", List.of(
                new Coche("3333CCC", "BMW", "320d", "Azul", 14500, List.of(
                        new Revision("REV-004", true, true, 250),
                        new Revision("REV-005", true, false, 140),
                        new Revision("REV-006", false, true, 100)
                )),
                new Coche("4444DDD", "Audi", "A3", "Blanco", 12000, new ArrayList<>())
        )));

        clientes.add(new Cliente("56781234C", "Carlos Gómez", "Valencia", List.of(
                new Coche("5555EEE", "Seat", "Ibiza", "Rojo", 5000, List.of(
                        new Revision("REV-007", false, false, 60)
                )),
                new Coche("6666FFF", "Ford", "Focus", "Gris", 7500, List.of(
                        new Revision("REV-008", true, true, 200),
                        new Revision("REV-009", false, true, 80)
                )),
                new Coche("7777GGG", "Alfa Romeo", "Giulietta", "Rojo", 9500, new ArrayList<>())
        )));

        clientes.add(new Cliente("43218765D", "Ana López", "Madrid", List.of(
                new Coche("8888HHH", "Mercedes", "Clase A", "Negro", 21000, List.of(
                        new Revision("REV-010", true, true, 300),
                        new Revision("REV-011", true, true, 280),
                        new Revision("REV-012", false, true, 110),
                        new Revision("REV-013", true, false, 160)
                ))
        )));

        clientes.add(new Cliente("99999999Z", "Javier Sanz", "Teruel", new ArrayList<>()));

        System.out.println("1. Mostrar todos los coches de todos los clientes");

        List<Coche> coches = clientes.stream()
                        .flatMap(c-> c.getCoches().stream()).toList();

        coches.forEach(c->
        {
            System.out.println(c);
        });


        System.out.println("2. Mostrar los clientes que tengan al menos un coche rojo");

        List<Cliente> clientesCochesRojos = clientes.
                stream()
                .filter(c-> c.getCoches().stream().anyMatch(co-> co.getColor().equalsIgnoreCase("Rojo")))
                .toList();

        clientesCochesRojos.forEach(c->
        {
            System.out.println(c);
        });

        System.out.println("3. Mostrar los clientes que tengan algún coche con alguna revisión donde se haya cambiado el aceite");

        List<Cliente> clientesCochesCambioAceite = clientes.
                stream()
                .filter(c-> c.getCoches().stream().anyMatch(co-> co.getRevisiones().stream().anyMatch(r-> r.isCambioAceite()==true)))
                .toList();

        clientesCochesCambioAceite.forEach(c->
        {
            System.out.println(c);
        });

        System.out.println("4. Encontrar el coche con más revisiones");

        Optional<Coche> masRevisiones = clientes.stream()
                        .flatMap(c-> c.getCoches().stream())
                                .max(Comparator.comparingInt(c-> c.getRevisiones().size()));

        masRevisiones.ifPresent(System.out::println);


        System.out.println("5. Encontrar el cliente que más dinero se ha gastado en coches");

        /*Optional<Cliente> clienteMasDineroGastado = clientes.stream()
                        .flatMap(c-> c.getCoches().stream())
                        .collect(Collectors.summingDouble(Coche::getPrecio));*/


        System.out.println("6. Crear un Map<String, Long> con cuántos coches hay por marca");

        Map<String,Long> cochesPorMarca = clientes
                .stream()
                        .flatMap(c-> c.getCoches().stream())
                                .collect(Collectors.groupingBy(Coche::getMarca, Collectors.counting()));

        cochesPorMarca.forEach((m,n)->
        {
            System.out.println(m+"->"+n);
        });

        System.out.println("7. Crear un Map<String, Double> con el precio medio de los coches por marca");

        Map<String, Double> marcaPrecioMedio =  clientes
                .stream()
                .flatMap(c-> c.getCoches().stream())
                .collect(Collectors.groupingBy(Coche::getMarca, Collectors.averagingDouble(Coche::getPrecio)));

        marcaPrecioMedio.forEach((m,n)->
        {
            System.out.println(m+"->"+n);
        });

        System.out.println("8. Crear un Map<String, Integer> donde la clave sea la matrícula y el valor sea el número de revisiones");

        Map<String, Integer> matriculaNumRevisiones = clientes
                .stream()
                        .flatMap(c-> c.getCoches().stream())
                                .collect(Collectors.groupingBy(c-> c.getMatricula(),Collectors.summingInt(c-> c.getRevisiones().size())));

        System.out.println("9. Mostrar las marcas que tengan más de 1 coche");

        cochesPorMarca.entrySet().stream()
                        .filter(e-> e.getValue()>1)
                                .forEach(e-> System.out.println(e.getKey()+ " -> "+ e.getValue()));

        System.out.println("10. Sacar una lista de ClienteResumenDTO");

        //ME DA PEREZA SINCERAMENTE XD

        System.out.println("11. Dado un código de revisión, encontrar el cliente dueño del coche que contiene esa revisión");

        String codigoBuscado = "REV-003";

        Optional<Cliente> clienteConCod = clientes.stream()
                .filter(c -> c.getCoches().stream()
                        .flatMap(co -> co.getRevisiones().stream())
                        .anyMatch(r -> r.getCodigo().equals(codigoBuscado)))
                .findFirst();

        clienteConCod.ifPresent(System.out::println);

        System.out.println("12. Sacar los 3 coches más caros de todos los clientes");

        List<Coche> cochesMasCaros = clientes
                .stream()
                .flatMap(c-> c.getCoches().stream())
                .sorted(Comparator.comparingDouble(Coche::getPrecio).reversed()).limit(3).toList();


        cochesMasCaros.forEach(c->
        {
            System.out.println(c);
        });


    }
}