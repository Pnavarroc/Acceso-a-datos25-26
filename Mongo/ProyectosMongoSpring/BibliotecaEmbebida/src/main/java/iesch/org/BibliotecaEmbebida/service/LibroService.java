package iesch.org.BibliotecaEmbebida.service;

import iesch.org.BibliotecaEmbebida.model.Libro;
import iesch.org.BibliotecaEmbebida.repository.LibroRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    LibroRepository libroRepository;


    public @Nullable List<Libro> getAll() {
        return libroRepository.findAll();
    }

    public @Nullable Libro getOne(String id) {
        if (id == null || id.isBlank()) {
            throw new RuntimeException("ID inválido");
        }
        return libroRepository.findById(id).orElse(null);
    }

    public @Nullable Libro addOne(Libro libro) {
        return libroRepository.save(libro);

    }

    public @Nullable Libro updateOne(String id, Libro libro) {
        if (id==null || id.isBlank()){
            throw new RuntimeException("ID inválido");
        }
        libro.setId(id);

        return libroRepository.save(libro);
    }

    public @Nullable Object deleteOne(String id) {
        if (id==null||id.isBlank()){
            throw new RuntimeException("Id invalido");
        }
        libroRepository.deleteById(id);
        return null;
    }

    public @Nullable Object librosPorPrecio(Double precio) {
        return libroRepository.findByPrecioGreaterThan(precio);
    }

    public @Nullable Object librosPorEntreRangoPrecio(Double precioMin, Double precioMax) {
        return libroRepository.findByPrecioBetween(precioMin,precioMax);
    }

    public @Nullable Object librosPorCategoria(String categoria) {
        return libroRepository.findByCategorias(categoria);
    }

    public @Nullable Object librosPorNombreAutor(String nombreAutor) {
        return libroRepository.findByAutoresNombre(nombreAutor);
    }

    public @Nullable Object librosPorNumPaginasYPrecio(Integer paginas, Double precio) {
        return libroRepository.findByNumeroPaginasGreaterThanAndPrecioLessThan(paginas,precio);
    }

    public @Nullable Object librosporcategoriaNegada(String categoria) {
        return libroRepository.findByCategoriasNot(categoria);
    }

    public @Nullable Object librosConmasAutores() {
        return libroRepository.masDeUnAutor();
    }

    public @Nullable Object librosPorNombreYNacionalidad(String nombre, String nacionalidad) {
        return libroRepository.findByAutoresNombreAndAutoresNacionalidad(nombre,nacionalidad);
    }
}
