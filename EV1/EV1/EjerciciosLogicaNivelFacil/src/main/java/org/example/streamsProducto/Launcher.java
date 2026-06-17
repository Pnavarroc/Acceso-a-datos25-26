package org.example.streamsProducto;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Launcher
{
    public static void main(String[] args)
    {
        List<Producto> productos = List.of(
                new Producto("Pan", "Alimentacion", 1.20, 50),
                new Producto("Leche", "Alimentacion", 0.95, 30),
                new Producto("Teclado", "Informatica", 25.99, 10),
                new Producto("Raton", "Informatica", 12.50, 0),
                new Producto("Monitor", "Informatica", 149.99, 5),
                new Producto("Mesa", "Hogar", 89.99, 2),
                new Producto("Silla", "Hogar", 45.50, 8),
                new Producto("Agua", "Alimentacion", 0.60, 100)
        );

        System.out.println("Productos mas caros de 20€");

        List<Producto> caros = productos
                .stream()
                .filter(p-> p.getPrecio()>20.0)
                .toList();

        caros.forEach(p->{
            System.out.println(p);
        });

        System.out.println("Obtener solo los nombres del producto");

        List<String> productosNombres = productos.stream()
                .map(p->p.getNombre()).toList();

        productosNombres.forEach(n->{
            System.out.println(n);
        });

        System.out.println("Productos sin stock");

        List<Producto> productosNoStock =
                productos.stream()
                        .filter(p->p.getStock() == 0).toList();

        productosNoStock.forEach(p->{
            System.out.println(p);
        });

        System.out.println("Contar productos de informatica");

        Long numProductos = productos.stream()
                .filter(p->p.getCategoria().equalsIgnoreCase("Informatica"))
                .count();

        System.out.println(numProductos);

        System.out.println("Sumar stock total de los productos");

        Integer totalStockProductos = productos.stream().mapToInt(Producto::getStock).sum();
        System.out.println(totalStockProductos);

        /*int counter = 0;
        for(Producto p : productos)
        {
            counter += p.getStock();
        }

        System.out.println("El total de productos en stock es: "+counter);*/


        File fichero = new File("src/main/resources/productos.txt");

// EJERCICIO 6 - Escribir productos en fichero
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {

            for (Producto prod : productos) {
                bw.write(prod.getNombre() + ";" +
                        prod.getCategoria() + ";" +
                        prod.getPrecio() + ";" +
                        prod.getStock());
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


// EJERCICIO 7 - Leer y mostrar todas las líneas
        System.out.println("Leer todos los productos del fichero:");

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


// EJERCICIO 8 - Leer solo productos de Informatica
        System.out.println("Productos de Informatica desde fichero:");

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");

                String categoria = partes[1];

                if (categoria.equalsIgnoreCase("Informatica")) {
                    System.out.println(linea);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }




        //Ejercicio 9
        System.out.println("===================NIVEL 2==================");
        System.out.println("===================Ejercicio 9==================");
        System.out.println("===================STOCK>5 && PRECIO < 50==================");

        List<Producto> productosMenor50AndStockMayor5 = productos.stream()
                .filter(p-> p.getStock()>5 && p.getPrecio()<50).toList();

        productosMenor50AndStockMayor5.forEach(p->
        {
            System.out.println(p);
        });

        System.out.println("PRODUCTOS EN MAYUS SOLO NOMBRES");

        List<String> prodNombresMayus = productos
                .stream()
                .map(p-> p.getNombre().toUpperCase()).toList();
        System.out.println(prodNombresMayus);

        System.out.println("Producto mas caro");

        Optional<Producto> prodMasCaro = productos.stream()
                .max(Comparator.comparing(Producto::getPrecio));

        prodMasCaro.ifPresent(System.out::println);

        System.out.println("PRECIO MEDIO");

        double precioMedio = productos.stream()
                .collect(Collectors.averagingDouble(Producto::getPrecio));

        System.out.println(precioMedio);

        System.out.println("Ejercicio 13 — Agrupar por categoría");

        Map<String,List<Producto>> productosAgrupadosPorCategoría = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria));

        productosAgrupadosPorCategoría.forEach((cat,prods)->{
            System.out.println(cat+" ->"+prods);
        });

        System.out.println("Ejercicio 14 — Contar productos por categoría");

        Map<String,Long> prodsNumCat = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria,Collectors.counting()));

        prodsNumCat.forEach((cat,num)->
        {
            System.out.println(cat+" -> "+num);
        });


        System.out.println("Ficheros nivel 2\n" +
                "Ejercicio 15 — Leer productos del fichero y guardarlos en lista");


        List<Producto> productosFichero = new ArrayList<Producto>();

        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fichero));

            String line;
            while ((line = bufferedReader.readLine())!=null)
            {
                String[] partes = line.split(";");
                productosFichero.add(new Producto(partes[0], partes[1], Double.parseDouble(partes[2]), Integer.parseInt(partes[3])));
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

        System.out.println("Ejercicio 16 — Filtrar desde fichero con Streams\n" +
                "\n" +
                "Después de leer el fichero y tener productosFichero," +
                " muestra solo los productos de \"Alimentacion\" con stock mayor que 40.");

        List<Producto> productosFiltradosFichero = productosFichero.stream()
                .filter(p-> p.getCategoria().equalsIgnoreCase("alimentacion") && p.getStock()>40)
                .toList();

        productosFiltradosFichero.forEach(p->{
            System.out.println(p);
        });

        System.out.println("Ejercicio 17 — Crear fichero de productos caros\n" +
                "\n" +
                "Lee productos.txt, convierte a lista de productos y crea un nuevo fichero:");

        List<Producto> productosMascarosQue20 = productosFichero.stream()
                .filter(p-> p.getPrecio()>20.0)
                .toList();



        try(BufferedWriter bwriter = new BufferedWriter(new FileWriter(new File("src/main/resources/productos_caros.txt"))))
        {
            for(Producto prod: productosMascarosQue20)
            {
                bwriter.write(prod.getCategoria()+";"+prod.getNombre()+";"+prod.getPrecio()+";"+prod.getStock());
                bwriter.newLine();
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }

}
