package iesch.org.EjercicioDGT.model;

import lombok.*;

import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Multa {

    private String id; // ID de la multa (ej: M001)

    private String concepto;
    private double importe;
    private int puntos;

    private Instant fecha;
    private String lugarInfraccion;
    private String agente;

    // PENDIENTE_PAGO, PAGADA, etc.
    private String estado;

    private Instant fechaPago;
    private String metodoPago;
}
