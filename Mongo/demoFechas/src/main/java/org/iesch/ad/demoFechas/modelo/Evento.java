package org.iesch.ad.demoFechas.modelo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Document
@Data
public class Evento {

    @Id
    private String id;
    private String nombre;
    private LocalDate fecha;
    private LocalTime  hora;
    private LocalDateTime fechaHora;

    /**
     * Ejemplo de JSON para insertar un evento:
     *
     * Formato detallado:
     *      * fecha (LocalDate): "YYYY-MM-DD"
     *      * hora (LocalTime): "HH:mm:ss" o "HH:mm:ss.SSS"
     *      * fechaHora (LocalDateTime): "YYYY-MM-DDTHH:mm:ss" o "YYYY-MM-DDTHH:mm:ss.SSS"
     *
     * {
     *   "nombre": "Reunión de equipo",
     *   "fecha": "2024-01-15",
     *   "hora": "14:30:00",
     *   "fechaHora": "2024-01-15T14:30:00"
     * }
     *
     * Ejemplo de JSON con milisegundos:
     *
     * {
     * "nombre": "Conferencia Spring Boot",
     * "fecha": "2024-03-20",
     * "hora": "09:15:30.500",
     * "fechaHora": "2024-03-20T09:15:30.500"
     * }
     *
     *
     *
     *
     */



}
