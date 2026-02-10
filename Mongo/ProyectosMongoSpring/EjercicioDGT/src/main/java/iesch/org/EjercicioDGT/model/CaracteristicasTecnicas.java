package iesch.org.EjercicioDGT.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CaracteristicasTecnicas {

    private int cilindrada;
    private int potencia;

    private String numeroBastidores;
    private String combustible;

    private String emisiones;
    private int plazas;
    private int pesoMaximo;
    private String tipoMotor;
}