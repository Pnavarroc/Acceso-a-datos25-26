package org.example.model;

public class Empleado {
    private Long id;
    private String nombre;
    private double salario;
    private Long id_departamento;

    public Empleado() {
    }

    public Empleado(Long id, String nombre, double salario, Long id_departamento) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.id_departamento = id_departamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Long getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Long id_departamento) {
        this.id_departamento = id_departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", id_departamento=" + id_departamento +
                '}';
    }
}
