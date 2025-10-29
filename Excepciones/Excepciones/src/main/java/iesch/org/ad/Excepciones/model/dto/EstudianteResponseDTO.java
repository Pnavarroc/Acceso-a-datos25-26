package iesch.org.ad.Excepciones.model.dto;

import iesch.org.ad.Excepciones.model.Estudiante;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteResponseDTO {
    private Long id;
    private String nombre;
    private String apellidos;

    public EstudianteResponseDTO(Estudiante estudiante){
        this.id = estudiante.getId();
        this.nombre = estudiante.getNombre();
        this.apellidos = estudiante.getApellidos();
    }
}
