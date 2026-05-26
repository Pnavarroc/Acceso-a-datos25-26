package org.example;

public class Autor
{
    private String nombre;
    private String pais;
    private Integer edad;

    public Autor() {
    }

    public Autor(String nombre, String pais, Integer edad) {
        this.nombre = nombre;
        this.pais = pais;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", edad=" + edad +
                '}';
    }
}
