package org.example.ejerciciosNivelExamen.lecturaFicheroStreams;

public class Alumno {

    private int id;
    private String nombre;
    private String curso;
    private double nota;
    private int edad;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String curso, double nota, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.nota = nota;
        this.edad = edad;
    }

    public int getId() {
        return id;
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

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", nota=" + nota +
                ", edad=" + edad +
                '}';
    }
}