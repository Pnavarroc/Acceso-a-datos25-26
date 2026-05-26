package com.example.Diseno.tiendaInformatica;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String nombre;
    private String direccion;
    private int numTelefono;

    @ManyToMany
    @JoinColumn(name = "producto_id")
    private List<Producto> productos;

}
