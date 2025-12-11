package iesch.org.AutorLibroCrudConsultas.controler;

import iesch.org.AutorLibroCrudConsultas.model.Autor;
import iesch.org.AutorLibroCrudConsultas.model.Libro;
import iesch.org.AutorLibroCrudConsultas.service.AutorService;
import iesch.org.AutorLibroCrudConsultas.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private AutorService autorService;

    // GET ALL
    @GetMapping
    public ResponseEntity<?> mostrarLibros() {
        List<Libro> libros = libroService.mostrarLibros();

        if (libros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(libros);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarLibroPorId(@PathVariable Long id) {
        Libro libro = libroService.mostrarLibroPorId(id);

        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libro);
    }

    // POST
    @PostMapping
    public ResponseEntity<?> crearLibro(@RequestBody Libro libro) {

        Autor autor = autorService.mostrarAutorPorId(libro.getAutor().getId());
        if (autor == null) {
            return ResponseEntity.badRequest().body("El autor no existe");
        }

        libro.setAutor(autor);

        Libro guardado = libroService.guardarLibro(libro);
        return ResponseEntity.ok(guardado);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarLibro(@PathVariable Long id, @RequestBody Libro nuevo) {

        Libro existente = libroService.mostrarLibroPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        Autor autor = autorService.mostrarAutorPorId(nuevo.getAutor().getId());
        if (autor == null) {
            return ResponseEntity.badRequest().body("El autor no existe");
        }

        existente.setTitulo(nuevo.getTitulo());
        existente.setPaginas(nuevo.getPaginas());
        existente.setAutor(autor);

        Libro actualizado = libroService.guardarLibro(existente);
        return ResponseEntity.ok(actualizado);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarLibro(@PathVariable Long id) {
        libroService.borrarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
