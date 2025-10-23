package org.iesch.com.RestProductos.service;

import org.iesch.com.RestProductos.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Map;

public class UsuarioService {

    @Autowired
    Map<Long,Usuario> usuarios;

    public Usuario addUser(Usuario usuario) {
        Long maxKey = Collections.max(usuarios.keySet());
        usuario.setId(maxKey+1);
        usuarios.put(maxKey+1,usuario);
        return usuario;
    }
}
