package org.example.ejerciciosBasicosJava.ejercicioComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Principal
{

    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona("Pablo", 20));
        personas.add(new Persona("Arturo", 56));
        personas.add(new Persona("Saul", 65));
        personas.add(new Persona("Paul", 12));
        personas.add(new Persona("Migue", 48));
        personas.add(new Persona("Adrián", 25));
        personas.add(new Persona("Ignacio", 32));

        List<Persona> personasResult = personas.stream().
                sorted(Comparator.comparingInt(Persona::getEdad)).toList();


        personasResult.forEach((Persona p )->{
            System.out.println(p.getName()+" "+p.getEdad());
        });

    }
}

/**
 * ordénalas por edad ascendente usando Comparator
 */
