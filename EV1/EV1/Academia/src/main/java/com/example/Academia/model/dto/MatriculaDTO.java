package com.example.Academia.model.dto;

import java.time.LocalDate;

public class MatriculaDTO
{
    private Long idMatricula;
    private String nombreAlumno;
    private String emailAlumno;
    private String nombreCurso;
    private String categoriaCurso;
    private Double notaFinal;
    private LocalDate fecha;

    public MatriculaDTO() {
    }

    public MatriculaDTO(Long idMatricula, String nombreAlumno, String emailAlumno, String nombreCurso, String categoriaCurso, Double notaFinal, LocalDate fecha) {
        this.idMatricula = idMatricula;
        this.nombreAlumno = nombreAlumno;
        this.emailAlumno = emailAlumno;
        this.nombreCurso = nombreCurso;
        this.categoriaCurso = categoriaCurso;
        this.notaFinal = notaFinal;
        this.fecha = fecha;
    }

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getEmailAlumno() {
        return emailAlumno;
    }

    public void setEmailAlumno(String emailAlumno) {
        this.emailAlumno = emailAlumno;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCategoriaCurso() {
        return categoriaCurso;
    }

    public void setCategoriaCurso(String categoriaCurso) {
        this.categoriaCurso = categoriaCurso;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
