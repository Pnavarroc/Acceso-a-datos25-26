package iesch.org.EjercicioDGT.model;

import lombok.*;

import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HistorialTitular {

    private String dni;
    private String nombre;
    private String apellidos;

    private Instant fechaInicio;
    private Instant fechaFin;

    private String motivoTransferencia;
}

