package com.example.Diseno.modelEnvios;

import jakarta.persistence.*;

@Entity
public class Paquete
{
    @Id
    @GeneratedValue ( strategy =  GenerationType.IDENTITY)
    private Long id;

    private String codigoPaquete;
    private String descripcion;
    private String destinatario;
    private String direccion;


    private Provincia provincia;

    @ManyToOne
    @JoinColumn(name = "camionero_id")
    private Camionero camionero;

}
