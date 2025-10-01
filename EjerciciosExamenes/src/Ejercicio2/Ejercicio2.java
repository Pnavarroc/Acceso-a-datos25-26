package Ejercicio2;


import java.io.*;

/*
* Buscar y reemplazar texto en un archivo:
Objetivo: Crear una herramienta que busque una cadena de texto específica en un archivo y la
reemplace por otra.
Consideraciones:
Utilizar java.io.BufferedReader y java.io.BufferedWriter para leer y escribir líneas de texto.
Implementar un algoritmo de búsqueda y reemplazo eficiente.
Crear un nuevo archivo con los cambios para preservar el original.*/
public class Ejercicio2 {
    public static void main(String[] args) {
        String ruta = "Ejercicio2.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta));
             BufferedWriter bw = new BufferedWriter(new FileWriter("Ejercicio2Cambios.txt"))){
            String linea;
            while ((linea= br.readLine())!=null){

                linea=linea.replace("Python","cambio");

                bw.write(linea);
                bw.newLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
