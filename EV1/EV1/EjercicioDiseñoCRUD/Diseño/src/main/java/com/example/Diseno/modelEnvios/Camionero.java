package com.example.Diseno.modelEnvios;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Camionero
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dni;
    private String nombre;
    private String direccion;
    private Double salario;

    //TODO
    private Provincia provincia;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Paquete> paquete;

    //TODO
    @ManyToMany
    @JoinColumn(name = "id")
    private List<Camion> camion;




}
