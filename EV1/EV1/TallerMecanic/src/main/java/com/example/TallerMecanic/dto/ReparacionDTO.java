package com.example.TallerMecanic.dto;

import java.time.LocalDate;

public class ReparacionDTO
{
    private Long id;
    private LocalDate fecha;
    private double coste;
    private String matricula;
    private String clienteNombre;

    public ReparacionDTO() {
    }

    public ReparacionDTO(Long id, LocalDate fecha,double coste, String matricula, String clienteNombre) {
        this.id = id;
        this.fecha = fecha;
        this.coste=coste;
        this.matricula = matricula;
        this.clienteNombre = clienteNombre;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    @Override
    public String toString() {
        return "ReparacionDTO{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", matricula='" + matricula + '\'' +
                ", clienteNombre='" + clienteNombre + '\'' +
                '}';
    }
}
