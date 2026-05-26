package com.example.Diseno.modelVentaCoches;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Coche
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private Double precio;

    @OneToMany
    @JoinColumn(name = "revision_id")
    private List<Revision> revision;

}
