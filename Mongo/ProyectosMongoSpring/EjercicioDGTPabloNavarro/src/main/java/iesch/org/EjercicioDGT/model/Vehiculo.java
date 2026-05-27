package iesch.org.EjercicioDGT.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "vehiculos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vehiculo {

    @Id
    private String id; // String

    private String matricula;
    private String bastidor;

    private String marca;
    private String modelo;
    private String color;

    private String tipoVehiculo;

    private int anioFabricacion;

    private Instant fechaPrimeraMatriculacion;

    private CaracteristicasTecnicas caracteristicasTecnicas;
    private Titular titular;
    private DomicilioFiscal domicilioFiscal;
    private SituacionAdministrativa situacionAdministrativa;
    private ITV itv;

    private List<Multa> multas = new ArrayList<>();
    private Impuestos impuestos;

    private List<HistorialTitular> historialTitulares = new ArrayList<>();

    private Instant fechaCreacion;
    private Instant fechaActualizacion;

    public Vehiculo(String matricula, String bastidor, String marca, String modelo, String color, String tipoVehiculo, int anioFabricacion, Instant fechaPrimeraMatriculacion, CaracteristicasTecnicas caracteristicasTecnicas, Titular titular, DomicilioFiscal domicilioFiscal, SituacionAdministrativa situacionAdministrativa, ITV itv, List<Multa> multas, Impuestos impuestos, List<HistorialTitular> historialTitulares, Instant fechaCreacion, Instant fechaActualizacion) {
        this.matricula = matricula;
        this.bastidor = bastidor;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipoVehiculo = tipoVehiculo;
        this.anioFabricacion = anioFabricacion;
        this.fechaPrimeraMatriculacion = fechaPrimeraMatriculacion;
        this.caracteristicasTecnicas = caracteristicasTecnicas;
        this.titular = titular;
        this.domicilioFiscal = domicilioFiscal;
        this.situacionAdministrativa = situacionAdministrativa;
        this.itv = itv;
        this.multas = multas;
        this.impuestos = impuestos;
        this.historialTitulares = historialTitulares;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public Instant getFechaPrimeraMatriculacion() {
        return fechaPrimeraMatriculacion;
    }

    public void setFechaPrimeraMatriculacion(Instant fechaPrimeraMatriculacion) {
        this.fechaPrimeraMatriculacion = fechaPrimeraMatriculacion;
    }

    public CaracteristicasTecnicas getCaracteristicasTecnicas() {
        return caracteristicasTecnicas;
    }

    public void setCaracteristicasTecnicas(CaracteristicasTecnicas caracteristicasTecnicas) {
        this.caracteristicasTecnicas = caracteristicasTecnicas;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public DomicilioFiscal getDomicilioFiscal() {
        return domicilioFiscal;
    }

    public void setDomicilioFiscal(DomicilioFiscal domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }

    public SituacionAdministrativa getSituacionAdministrativa() {
        return situacionAdministrativa;
    }

    public void setSituacionAdministrativa(SituacionAdministrativa situacionAdministrativa) {
        this.situacionAdministrativa = situacionAdministrativa;
    }

    public ITV getItv() {
        return itv;
    }

    public void setItv(ITV itv) {
        this.itv = itv;
    }

    public List<Multa> getMultas() {
        return multas;
    }

    public void setMultas(List<Multa> multas) {
        this.multas = multas;
    }

    public Impuestos getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Impuestos impuestos) {
        this.impuestos = impuestos;
    }

    public List<HistorialTitular> getHistorialTitulares() {
        return historialTitulares;
    }

    public void setHistorialTitulares(List<HistorialTitular> historialTitulares) {
        this.historialTitulares = historialTitulares;
    }

    public Instant getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Instant getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Instant fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}

