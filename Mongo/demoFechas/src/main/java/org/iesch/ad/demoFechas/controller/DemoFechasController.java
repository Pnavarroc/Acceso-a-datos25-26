package org.iesch.ad.demoFechas.controller;

import org.iesch.ad.demoFechas.Repositorio.DemoFechasRepositorio;
import org.iesch.ad.demoFechas.modelo.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoFechasController {

    @Autowired
    DemoFechasRepositorio demoFechasRepositorio;

    @PostMapping ("/evento")
    public ResponseEntity<Evento> insertarEvento(@RequestBody Evento evento) {
        Evento eventoGuardado = demoFechasRepositorio.save(evento);
        return ResponseEntity.ok(eventoGuardado);

    }

    @GetMapping("/eventos")
    public ResponseEntity<List<Evento>> obtenerEventos() {
        List<Evento> eventos = demoFechasRepositorio.findAll();
        return ResponseEntity.ok(eventos);
    }
}
