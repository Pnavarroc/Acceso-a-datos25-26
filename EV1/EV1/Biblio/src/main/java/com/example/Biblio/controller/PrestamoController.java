package com.example.Biblio.controller;

import com.example.Biblio.model.Prestamo;
import com.example.Biblio.model.PrestamoDTO;
import com.example.Biblio.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prestamos")
public class PrestamoController
{
    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public ResponseEntity<?> getAllPrestamos()
    {
        return ResponseEntity.ok(prestamoService.getAllPrestamos());
    }

    @GetMapping("/socio/{idSocio}")
    public List<PrestamoDTO> getPrestamosBySocio(@PathVariable Long idSocio)
    {
        return prestamoService.getPrestamosBySocio(idSocio);
    }

    @GetMapping("/no-devueltos")
    public ResponseEntity<List<PrestamoDTO>> getPrestamosNoDevueltos()
    {
        return ResponseEntity.ok(prestamoService.getPrestamosNoDevueltos());
    }

    @GetMapping("/devueltos")
    public ResponseEntity<List<PrestamoDTO>> getPrestamosDevueltos()
    {
        return ResponseEntity.ok(prestamoService.getPrestamosDevueltos());
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<PrestamoDTO>> getPrestamosByGeneroLibro(@PathVariable String genero)
    {
        return ResponseEntity.ok(prestamoService.getPrestamosByGeneroLibro(genero));
    }

    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<List<PrestamoDTO>> getPrestamosByCiudadSocio(@PathVariable String ciudad)
    {
        return ResponseEntity.ok(prestamoService.getPrestamosByCiudadSocio(ciudad));
    }

    @PostMapping("/socio/{idSocio}/libro/{idLibro}")
    public ResponseEntity<Prestamo> crearPrestamo(
            @PathVariable Long idSocio,
            @PathVariable Long idLibro,
            @RequestBody Prestamo prestamo)
    {
        return ResponseEntity.ok(prestamoService.crearPrestamo(idSocio, idLibro, prestamo));
    }

    @PutMapping("/{idPrestamo}/devolver")
    public ResponseEntity<?> marcarComoDevuelto(@PathVariable Long idPrestamo)
    {
        return ResponseEntity.ok(prestamoService.marcarComoDevuelto(idPrestamo));
    }
}
