package org.iesch.ad.demoValid.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 3, max = 25, message = "El nombre debe tener entre 3 y 25 caracteres")
    private String nombre;
    @NotBlank(message = "El email no puede estar vacio")
    private String email;

}
