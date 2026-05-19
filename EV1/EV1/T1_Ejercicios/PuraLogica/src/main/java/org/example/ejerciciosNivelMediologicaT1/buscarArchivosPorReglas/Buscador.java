package org.example.ejerciciosNivelMediologicaT1.buscarArchivosPorReglas;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Dado un directorio, muestra todos los archivos que terminen en:
 * .txt
 * y cuyo nombre contenga:
 * log
 */
public class Buscador
{
    private static final String URL = "C:\\Users\\pablo\\OneDrive\\Escritorio\\Pruebas";

    public static void main(String[] args)
    {
        File carpeta = new File(URL);
        List<File> fileList = getListLogTxts(carpeta);

        fileList.forEach((File archivoValido)->{
            System.out.println(archivoValido.getName());
        });

    }

    private static List<File> getListLogTxts( File carpeta)
    {
        List<File> fileList;
        if (!carpeta.exists()) return new ArrayList<>();

        fileList = List.of(carpeta.listFiles());

        for (File file : fileList)
        {
            if (file.isDirectory())
            {
                buscarSubcarpetas(file);
            }

        }

        List<File> validFiles = fileList.stream().
                filter(f->f.getName().contains("log") && f.getName().endsWith(".txt")).toList();

        return validFiles;
    }

    private static void buscarSubcarpetas(File subcarpeta)
    {
        getListLogTxts(subcarpeta);
    }

}
