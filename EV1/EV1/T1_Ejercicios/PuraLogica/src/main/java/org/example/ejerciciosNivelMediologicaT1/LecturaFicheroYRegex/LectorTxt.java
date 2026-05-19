package org.example.ejerciciosNivelMediologicaT1.LecturaFicheroYRegex;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LectorTxt
{
    private static final String ubicacionFichero = "./src/main/resources/PruebasLectura.txt";
    public static void main(String[] args)
    {
        //1. Tener un objeto file del fichero.
        File fichero = new File(ubicacionFichero);

        Pattern patron = Pattern.compile("\\berror\\b");
        int counter =0;
        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(fichero));

            String linea;


            while ((linea = bf.readLine())!= null)
            {
                Matcher buscador = patron.matcher(linea);
                while (buscador.find()) counter++;

                System.out.println(linea);
            }

            System.out.println("Palabra error encontrada Nº: "+ counter+ " veces");
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        /**
         * Pattern patron = Pattern.compile("\\d{8}[A-Z]");
         *
         *         Matcher buscador = patron.matcher("12345678A");
         *
         *         while (buscador.find()) {
         *             System.out.println("Encontrado: " + buscador.group());
         *         }
         */


    }
}
