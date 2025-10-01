package Ejercicio4;

import Ejercicio4.Modelo.Producto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Ejercicio 4:
Lee un archivo CSV con datos de productos (nombre, precio, categoría) utiliza el contenido
leído para inicializar un arraylist:
• Calcula el producto más caro de cada categoría.
• Imprime una lista con los productos cuyo precio está entre 10 y 20 euros.*/
public class Ejercicio4 {
    public static void main(String[] args) {


        String ruta = "Ej4.csv";
        List<Producto> productos = new ArrayList<>();

        {
            try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
                String linea ;
                br.readLine(); //Saltamos la cabecera
                while ((linea=br.readLine()) != null) {
                    String[] partes = linea.split(";");
                    if (partes.length<3) continue;
                    String nombre = partes[0];
                    double precio = Double.parseDouble(partes[1].replace(",","."));
                    String categoria = partes[2];
                    productos.add(new Producto(nombre, precio, categoria));
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        for (Producto producto:productos){
            System.out.println(producto);
        }

        System.out.println("____________________________________");
        masCaroPorCategoria(productos);
        System.out.println("____________________________________");
        for (Producto producto: productos){
            if (producto.getPrecio()>=10 && producto.getPrecio()<=20){
                System.out.println(producto.getNombre()) ;
            }
        }




    }

    private static void masCaroPorCategoria(List<Producto> productos) {
        Map<String, Producto> masCaros = new HashMap<>();

        for (Producto p : productos) {
            Producto actual = masCaros.get(p.getCategoria());
            if (actual == null || p.getPrecio() > actual.getPrecio()) {
                masCaros.put(p.getCategoria(), p);
            }
        }

        System.out.println("Productos más caros por categoría:");
        for (String categoria : masCaros.keySet()) {
            Producto p = masCaros.get(categoria);
            System.out.println(categoria + " -> " + p.getNombre() + " (" + p.getPrecio() + "€)");
        }
    }

}
