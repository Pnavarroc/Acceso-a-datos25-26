package iesch.org.EjercicioDGT.model;

import lombok.*;

import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ITV {

    private boolean enVigor;

    private Instant fechaUltimaInspeccion;
    private Instant fechaCaducidad;


    private String resultado;

    private String numeroInforme;

    private String eITV;

    private String estacionITV;


    public String geteITV() {
        return eITV;
    }

    public void seteITV(String eITV) {
        this.eITV = eITV;
    }

    public boolean isEnVigor() {
        return enVigor;
    }

    public void setEnVigor(boolean enVigor) {
        this.enVigor = enVigor;
    }

    public Instant getFechaUltimaInspeccion() {
        return fechaUltimaInspeccion;
    }

    public void setFechaUltimaInspeccion(Instant fechaUltimaInspeccion) {
        this.fechaUltimaInspeccion = fechaUltimaInspeccion;
    }

    public Instant getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Instant fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getNumeroInforme() {
        return numeroInforme;
    }

    public void setNumeroInforme(String numeroInforme) {
        this.numeroInforme = numeroInforme;
    }

    public String getEstacionITV() {
        return estacionITV;
    }

    public void setEstacionITV(String estacionITV) {
        this.estacionITV = estacionITV;
    }
}
