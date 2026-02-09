package iesch.org.DocumentosReferenciadosBiblioteca.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "editoriales")
public class Editoriales {

    @Id
    private Long id;
    private String nombre;

    private String pais;

    private Integer fundacion;

    public Editoriales(String nombre, String pais, Integer fundacion) {
        this.nombre = nombre;
        this.pais = pais;
        this.fundacion = fundacion;
    }
}
