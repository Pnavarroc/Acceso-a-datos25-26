package EjerciciosGPT;

import java.util.ArrayList;
import java.util.List;

/*1. Filtrar mayores de edad

Crea una clase Persona con atributos nombre y edad.
En main:

Crea una lista con varias personas.

Usa un Predicate<Persona> con removeIf para eliminar los menores de 18 años.

Muestra la lista de mayores de edad.*/
public class Ejercicio8 {
    public static void main(String[] args) {
        Persona persona1= new Persona("Pablo",20);
        Persona persona2= new Persona("Manuel",25);
        Persona persona3= new Persona("Saul",40);
        Persona persona4= new Persona("Jorge",10);

        List<Persona> personas = new ArrayList<>(List.of(persona1,persona2,persona3,persona4));

        personas.removeIf(persona -> persona.getEdad()<18);
        System.out.println(personas);

    }
}

class Persona{
    private String nombre;
    private int edad;

    public Persona() {
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }
}
