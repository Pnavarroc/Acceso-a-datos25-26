package org.example.ejerciciosBasicosJava;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuscarDocumentosTXT
{
    private static final String rutaAbsolutaDirectorioBusqueda = "C:\\Users\\pablo\\OneDrive\\Escritorio\\PruebaBuscadorTXT";

    public static void main(String[] args)
    {
        List<File> fileList = getFiles();
        System.out.println("Ficheros que son txt");
        fileList.forEach((File file)->{
            System.out.println(file.getName()+" - ");
        });
    }

    //Método que nos va a listar los ficheros y filtrar
    private static List<File> getFiles()
    {
        File file = new File(rutaAbsolutaDirectorioBusqueda);

        if (!file.exists()) return new ArrayList<>();

        List<File> fileList = Arrays.asList(file.listFiles());

        List<File> fileTXTList = fileList.stream().filter(f->f.getName().endsWith(".txt")).toList();

        return fileTXTList;

    }

}
