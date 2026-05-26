package com.example.Diseno.modelEnvios;

import jakarta.persistence.*;

@Entity
public class Provincia
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    private String codigoProvincia;

    @OneToMany
    @JoinColumn(name = "id")
    private Paquete paquete;
}
