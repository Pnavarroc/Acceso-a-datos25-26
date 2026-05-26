package com.example.Diseno.modelEnvios;

import jakarta.persistence.Entity;

@Entity
public class Camion
{
    private Long id;

    private String matricula;
    private String modelo;
    private String tipo;
    private String potencia;
}
