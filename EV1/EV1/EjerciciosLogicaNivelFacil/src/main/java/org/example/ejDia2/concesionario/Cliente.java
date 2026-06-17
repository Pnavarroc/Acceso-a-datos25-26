package org.example.ejDia2.concesionario;

import java.util.List;

public class Cliente {

    private String nif;
    private String nombre;
    private String ciudad;
    private List<Coche> coches;

    public Cliente() {
    }

    public Cliente(String nif, String nombre, String ciudad, List<Coche> coches) {
        this.nif = nif;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.coches = coches;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", coches=" + coches +
                '}';
    }
}