package iesch.org.DocumentosReferenciadosBiblioteca.service;

import iesch.org.DocumentosReferenciadosBiblioteca.model.Libros;
import iesch.org.DocumentosReferenciadosBiblioteca.repository.LibroRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LibrosService {

    @Autowired
    LibroRepository libroRepository;


    public List<Libros> getAll() {

        return libroRepository.findAll();
    }

    public @Nullable Libros getOne(Long id) {
        return libroRepository.findById(id).orElse(null);

    }

    public @Nullable Object updateOne(Long id, Libros libro) {

        if (!libroRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        libro.setId(id);

        return libroRepository.save(libro);
    }

    public @Nullable Object addOne(Libros libro) {

        if (libro.getId() != null && libroRepository.existsById(libro.getId())) {
            return null;
        }

        return libroRepository.save(libro);

    }

    public Libros deleteOne(Long id) {
        // 1. Buscamos el libro
        Optional<Libros> libroOpt = libroRepository.findById(id);

        // 2. Si existe, lo borramos y lo devolvemos
        if (libroOpt.isPresent()) {
            Libros libroABorrar = libroOpt.get();
            libroRepository.deleteById(id);
            return libroABorrar; // Devolvemos el objeto que acabamos de borrar
        }

        // 3. Si no existe, devolvemos null
        return null;
    }
}
