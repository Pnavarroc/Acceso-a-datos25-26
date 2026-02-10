package iesch.org.DocumentosReferenciadosBiblioteca.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "libros")
public class Libros {

    @Id
    private Long id;
    private String titulo;

    @DocumentReference

    private Autores autor_id;

    private String genero;

    @Field("año_publicacion")
    private Integer anioPublicacion;
    private Integer paginas;
    @DocumentReference
    private Editoriales editorial_id;

    public Libros(String titulo, Autores autor_id, String genero, Integer anioPublicacion, Integer paginas, Editoriales editorial_id) {
        this.titulo = titulo;
        this.autor_id = autor_id;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.paginas = paginas;
        this.editorial_id = editorial_id;
    }
}

