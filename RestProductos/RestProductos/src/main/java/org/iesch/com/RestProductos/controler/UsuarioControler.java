package org.iesch.com.RestProductos.controler;

import org.iesch.com.RestProductos.modelo.Usuario;
import org.iesch.com.RestProductos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
public class UsuarioControler {

    @Autowired
    Map<Long,Usuario>usuarios;
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuario")
    public ResponseEntity<?> registra(@RequestBody Usuario usuario){
        Usuario usuario1 = usuarioService.addUser(usuario);
        URI location = URI.create("/usuario/"+usuario1.getId());
        return ResponseEntity.created(location).body(usuario);

    }
}
