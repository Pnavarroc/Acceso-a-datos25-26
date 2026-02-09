package iesch.org.DocumentosReferenciadosBiblioteca.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "autores")
public class Autores {

    @Id
    private Long id;
    private String nombre;
    private String nacionalidad;
    private String fecha_nacimiento;

    private List<String> premios;

    public Autores(String nombre, String nacionalidad, String fecha_nacimiento, List<String> premios) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.premios = premios;
    }
}
