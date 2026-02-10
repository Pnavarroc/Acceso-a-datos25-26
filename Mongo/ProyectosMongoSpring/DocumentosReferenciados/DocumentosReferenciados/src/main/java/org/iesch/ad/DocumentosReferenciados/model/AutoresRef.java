package org.iesch.ad.DocumentosReferenciados.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "autores")
public class AutoresRef {
    @Id
    private String id;

    private String nombre;
    private String nacionalidad;

    public AutoresRef(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
}
