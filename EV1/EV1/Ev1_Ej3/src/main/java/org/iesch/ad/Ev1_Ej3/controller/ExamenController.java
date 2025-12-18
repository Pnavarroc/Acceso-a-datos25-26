package org.iesch.ad.Ev1_Ej3.controller;

import org.iesch.ad.Ev1_Ej3.service.ClienteService;
import org.iesch.ad.Ev1_Ej3.service.LibroService;
import org.iesch.ad.Ev1_Ej3.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamenController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    LibroService libroService;

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/clientes")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/api/clientesPorFecha")
    public ResponseEntity<?> clientesPorFecha(@RequestParam String fecha){
        return  ResponseEntity.ok(clienteService.clientesPorFecha(fecha));
    }

    @GetMapping("/api/librosPorEditorial")
    public ResponseEntity<?> librosPorEditorial(@RequestParam String editorial){
        return ResponseEntity.ok(libroService.librosPorEditorial(editorial));

    }

    @GetMapping("/api/pedidosConLibro")
    public ResponseEntity<?> pedidosConLibro(@RequestParam String libro){
        return ResponseEntity.ok(pedidoService.pedidosConLibro(libro));

    }


    @GetMapping("/api/clientesCompranLibroConPrecioMayor")
    public ResponseEntity<?> clientesCompranLibroConPrecioMayor(@RequestParam Double precio){
        return ResponseEntity.ok(clienteService.clientesCompranLibroConPrecioMayor(precio));
    }

    @GetMapping("/api/PedidosPorNombre")
    public ResponseEntity<?> pedidosPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(pedidoService.pedidosPorNombre(nombre));
    }

    @GetMapping("/api/LibrosPorClienteNombre")
    public ResponseEntity<?> librosPorClienteNombre(@RequestParam String nombre){
        return ResponseEntity.ok(libroService.librosPorClienteNombre(nombre));
    }



}
