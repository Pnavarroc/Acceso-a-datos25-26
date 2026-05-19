package org.example.ejerciciosNivelMediologicaT1.streamObjetosAlumno;

public class Alumno
{
    String nombre;
    String curso;
    double nota;
    int edad;

    public Alumno() {
    }

    public Alumno(String nombre, String curso, double nota, int edad) {
        this.nombre = nombre;
        this.curso = curso;
        this.nota = nota;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", nota=" + nota +
                ", edad=" + edad +
                '}';
    }
}
