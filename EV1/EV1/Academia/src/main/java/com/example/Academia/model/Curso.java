package com.example.Academia.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Curso
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;
    private Integer horas;
    private Double precio;

    @OneToMany
    @JoinColumn(name = "matricula_id")
    private List<Matricula> matriculas;

    public Curso() {
    }

    public Curso(Long id, String nombre, String categoria, Integer horas, Double precio, List<Matricula> matriculas) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.horas = horas;
        this.precio = precio;
        this.matriculas = matriculas;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
