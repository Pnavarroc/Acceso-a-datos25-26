package iesch.org.DocumentosReferenciadosBiblioteca.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "prestamos")
public class Prestamos {

    @Id
    private Long id;
    @DocumentReference
    private Libros libro_id;
    @DocumentReference
    private Usuarios usuario_id;
    private String fecha_prestamo;
    private String fecha_devolucion;
    private boolean devuelto;

    public Prestamos(Libros libro_id, Usuarios usuario_id, String fecha_prestamo, String fecha_devolucion, boolean devuelto) {
        this.libro_id = libro_id;
        this.usuario_id = usuario_id;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.devuelto = devuelto;
    }
}
