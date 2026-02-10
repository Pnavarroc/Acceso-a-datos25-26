package iesch.org.EjercicioDGT.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DomicilioFiscal {

    private String calle;
    private String numero;
    private String piso;
    private String puerta;
    private String codigoPostal;
    private String localidad;
    private String provincia;
}
