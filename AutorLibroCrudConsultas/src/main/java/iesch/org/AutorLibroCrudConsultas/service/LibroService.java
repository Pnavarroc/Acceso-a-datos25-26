package iesch.org.AutorLibroCrudConsultas.service;

import iesch.org.AutorLibroCrudConsultas.model.Autor;
import iesch.org.AutorLibroCrudConsultas.model.Libro;
import iesch.org.AutorLibroCrudConsultas.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    LibroRepository libroRepository;


    public List<Libro> mostrarLibros() {
        return libroRepository.findAll();
    }

    public Libro mostrarLibroPorId(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public void borrarPorId(Long id) {
        libroRepository.deleteById(id);
    }

}
