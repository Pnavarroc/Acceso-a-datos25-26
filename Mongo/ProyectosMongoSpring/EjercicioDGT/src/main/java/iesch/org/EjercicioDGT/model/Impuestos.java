package iesch.org.EjercicioDGT.model;

import lombok.*;

import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Impuestos {

    private boolean itmvPagado;

    private Instant fechaUltimoPagoITMV;

    private double importeITMV;
    private int anioITMV;
}
