package org.iesch.com.RestProductos.modelo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Usuario {
    long id;
    String nombre;
    String apellidos;
    String direccion;
    String password;
}
