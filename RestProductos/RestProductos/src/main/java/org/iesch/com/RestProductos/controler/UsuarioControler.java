package org.iesch.com.RestProductos.controler;

import org.iesch.com.RestProductos.modelo.UsuarioDTOPeticion;
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
    Map<Long, UsuarioDTOPeticion>usuarios;
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuario")
    public ResponseEntity<?> registra(@RequestBody UsuarioDTOPeticion usuario){
        UsuarioDTOPeticion usuario1 = usuarioService.addUser(usuario1);
        URI location = URI.create("/usuario/"+usuario1.getNombre());
        return ResponseEntity.created(location).body(usuario);

    }
}
