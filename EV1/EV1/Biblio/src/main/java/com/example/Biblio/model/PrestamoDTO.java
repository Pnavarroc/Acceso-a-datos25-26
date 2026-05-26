package com.example.Biblio.model;

import java.time.LocalDate;

public class PrestamoDTO
{
    Long idPrestamo;
    String nombreSocio;
    String emailSocio;
    String ciudadSocio;
    String tituloLibro;
    String autorLibro;
    String generoLibro;
    LocalDate fechaPrestamo;
    LocalDate fechaDevolucion;
    Boolean devuelto;

    public PrestamoDTO() {
    }

    public PrestamoDTO(Long idPrestamo, String nombreSocio, String emailSocio, String ciudadSocio, String tituloLibro, String autorLibro, String generoLibro, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Boolean devuelto) {
        this.idPrestamo = idPrestamo;
        this.nombreSocio = nombreSocio;
        this.emailSocio = emailSocio;
        this.ciudadSocio = ciudadSocio;
        this.tituloLibro = tituloLibro;
        this.autorLibro = autorLibro;
        this.generoLibro = generoLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = devuelto;
    }

    public Long getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Long idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public String getEmailSocio() {
        return emailSocio;
    }

    public void setEmailSocio(String emailSocio) {
        this.emailSocio = emailSocio;
    }

    public String getCiudadSocio() {
        return ciudadSocio;
    }

    public void setCiudadSocio(String ciudadSocio) {
        this.ciudadSocio = ciudadSocio;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public String getGeneroLibro() {
        return generoLibro;
    }

    public void setGeneroLibro(String generoLibro) {
        this.generoLibro = generoLibro;
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
}
