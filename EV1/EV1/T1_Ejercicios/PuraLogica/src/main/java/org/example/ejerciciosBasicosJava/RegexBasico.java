package org.example.ejerciciosBasicosJava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBasico
{

    /**
     * Ejercicio 8 — Regex
     *
     * Haz una regex que valide:
     *
     * 12345678A
     *
     * Reglas:
     *
     * 8 números
     * 1 letra mayúscula al final
     */

    public static void main(String[] args) {

        Pattern patron = Pattern.compile("\\d{8}[A-Z]");

        Matcher buscador = patron.matcher("12345678A");

        while (buscador.find()) {
            System.out.println("Encontrado: " + buscador.group());
        }
    }
}
