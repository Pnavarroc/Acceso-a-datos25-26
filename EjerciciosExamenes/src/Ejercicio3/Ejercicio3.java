package Ejercicio3;

import Ejercicio3.Modelo.Persona;

import java.util.ArrayList;
import java.util.List;

/*Ejercicio 3:
Crea una lista de objetos Persona (con atributos nombre y edad) y:
• Calcula la edad promedio de las personas.
• Encuentra la persona más joven.
• Imprime una lista con los nombres de las personas mayores de 30 años*/
public class Ejercicio3 {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Pablo",20);
        Persona persona2 = new Persona("Paul",30);
        Persona persona3 = new Persona("Paolo",45);
        Persona persona4 = new Persona("Paula",35);
        Persona persona5 = new Persona("Juan",12);

        List<Persona> personas= new ArrayList<>();
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);
        personas.add(persona5);

        System.out.println("La edad promedio de la lista es: "+edadPromedio(personas)+"\n"+" La persona mas joven es: "+ personaMasJoven(personas));

        System.out.println("Las personas mayores de 30 son: ");
        for (Persona persona :personas){
            if (persona.getEdad()>30){
                System.out.println(persona);
            }
        }


    }

    private static String personaMasJoven(List<Persona> personas) {
        Persona masJoven = personas.get(0);
        for (Persona persona: personas){
            if (persona.getEdad()<masJoven.getEdad()){
                masJoven=persona;
            }
        }
        return masJoven.getNombre()+ " Y tiene "+masJoven.getEdad()+ " años";


    }

    private static double edadPromedio(List<Persona> personasList){
        double edadMedia=0;
        for (Persona persona: personasList){
            edadMedia+=persona.getEdad();
        }
        return edadMedia/personasList.toArray().length;
    }
}
