package com.example.Biblio.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prestamo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prestamo_id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Boolean devuelto;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;

    public Prestamo() {
    }

    public Prestamo(Long id, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Boolean devuelto, Socio socio, Libro libro) {
        this.prestamo_id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = devuelto;
        this.socio = socio;
        this.libro = libro;
    }

    public Long getPrestamo_id() {
        return prestamo_id;
    }

    public void setPrestamo_id(Long prestamo_id) {
        this.prestamo_id = prestamo_id;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
