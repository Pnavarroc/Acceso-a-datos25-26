package org.example.ejDia2.concesionario;

public class Revision {

    private String codigo;
    private boolean cambioAceite;
    private boolean cambioFiltro;
    private double coste;

    public Revision() {
    }

    public Revision(String codigo, boolean cambioAceite, boolean cambioFiltro, double coste) {
        this.codigo = codigo;
        this.cambioAceite = cambioAceite;
        this.cambioFiltro = cambioFiltro;
        this.coste = coste;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isCambioAceite() {
        return cambioAceite;
    }

    public void setCambioAceite(boolean cambioAceite) {
        this.cambioAceite = cambioAceite;
    }

    public boolean isCambioFiltro() {
        return cambioFiltro;
    }

    public void setCambioFiltro(boolean cambioFiltro) {
        this.cambioFiltro = cambioFiltro;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    @Override
    public String toString() {
        return "Revision{" +
                "codigo='" + codigo + '\'' +
                ", cambioAceite=" + cambioAceite +
                ", cambioFiltro=" + cambioFiltro +
                ", coste=" + coste +
                '}';
    }
}