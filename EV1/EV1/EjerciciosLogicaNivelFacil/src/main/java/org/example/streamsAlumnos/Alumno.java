package org.example.streamsAlumnos;

public class Alumno {
    private String nombre;
    private String curso;
    private double nota;

    public Alumno(String nombre, String curso, double nota) {
        this.nombre = nombre;
        this.curso = curso;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCurso() {
        return curso;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return nombre + " - " + curso + " - " + nota;
    }
}
