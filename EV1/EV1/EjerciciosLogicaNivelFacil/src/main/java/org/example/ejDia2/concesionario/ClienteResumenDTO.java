package org.example.ejDia2.concesionario;

public class ClienteResumenDTO {

    private String nif;
    private String nombre;
    private String ciudad;
    private int totalCoches;
    private double dineroGastado;

    public ClienteResumenDTO() {
    }

    public ClienteResumenDTO(String nif, String nombre, String ciudad, int totalCoches, double dineroGastado) {
        this.nif = nif;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.totalCoches = totalCoches;
        this.dineroGastado = dineroGastado;
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

    public int getTotalCoches() {
        return totalCoches;
    }

    public void setTotalCoches(int totalCoches) {
        this.totalCoches = totalCoches;
    }

    public double getDineroGastado() {
        return dineroGastado;
    }

    public void setDineroGastado(double dineroGastado) {
        this.dineroGastado = dineroGastado;
    }

    @Override
    public String toString() {
        return "ClienteResumenDTO{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", totalCoches=" + totalCoches +
                ", dineroGastado=" + dineroGastado +
                '}';
    }
}