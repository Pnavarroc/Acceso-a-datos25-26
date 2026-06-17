package iesch.org.concesionario.models;

import jakarta.persistence.*;

@Entity
public class Revision
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private boolean cambioAceite;
    private boolean cambioFiltro;
    private double coste;

    //una revision solo pertenece a un coche.
    @ManyToOne
    @JoinColumn(name = "coche_id")
    private Coche coche_id;

    public Revision() {
    }

    public Revision(Long id, String codigo, boolean cambioAceite, boolean cambioFiltro, double coste, Coche coche_id) {
        this.id = id;
        this.codigo = codigo;
        this.cambioAceite = cambioAceite;
        this.cambioFiltro = cambioFiltro;
        this.coste = coste;
        this.coche_id = coche_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Coche getCoche_id() {
        return coche_id;
    }

    public void setCoche_id(Coche coche_id) {
        this.coche_id = coche_id;
    }

    @Override
    public String toString() {
        return "Revision{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", cambioAceite=" + cambioAceite +
                ", cambioFiltro=" + cambioFiltro +
                ", coste=" + coste +
                ", coche_id=" + coche_id +
                '}';
    }
}
