package com.example.Diseno.modelVentaCoches;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nif;
    private String nombre;
    private String direccion;
    private String ciudad;
    private int numTelefono;

    @Column(nullable = false, unique = true)
    private String codInterno;

    @OneToMany
    @JoinColumn(name = "coche_id")
    private List<Coche> coches;

}
