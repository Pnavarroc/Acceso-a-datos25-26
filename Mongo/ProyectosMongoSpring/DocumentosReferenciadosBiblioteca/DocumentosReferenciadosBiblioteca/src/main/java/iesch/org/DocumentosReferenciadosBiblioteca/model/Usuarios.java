package iesch.org.DocumentosReferenciadosBiblioteca.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "usuarios")
public class Usuarios {

    @Id
    private Long id;

    private String nombre;
    private String email;
    private String fecha_registro;
    private String tipo;

    public Usuarios(String nombre, String email, String fecha_registro, String tipo) {
        this.nombre = nombre;
        this.email = email;
        this.fecha_registro = fecha_registro;
        this.tipo = tipo;
    }


}
