package com.example.demoJPACoches.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String matricula;
    private float cilindrada;
    private int potencia;
    private String color;

    @ManyToOne
    Persona persona;

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", cilindrada=" + cilindrada +
                ", potencia=" + potencia +
                ", color='" + color + '\'' +
                ", persona=" + persona.getId() +
                ", persona=" + persona.getNombre()+
                '}';
    }
}
