package iesch.org.EjercicioDGT.model;

import lombok.*;

import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SituacionAdministrativa {

    // ACTIVO, BAJA_TEMPORAL, BAJA_DEFINITIVA, PRECINTADO, ROBADO
    private String estado;

    private Instant fechaEstado;

    // Baja definitiva
    private String motivoBaja;

    // Baja temporal
    private Instant fechaBajaTemporal;
    private Instant fechaFinBajaTemporal;

    private boolean precintado;

    private Instant fechaPrecinto;
    private String motivoPrecinto;
}
