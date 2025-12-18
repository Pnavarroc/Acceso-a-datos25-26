package iesch.org.AutorLibroCrudConsultas.repository;

import iesch.org.AutorLibroCrudConsultas.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LibroRepository extends JpaRepository<Libro,Long> {

    List<Libro> findByTituloContaining(String texto);

    List<Libro> findByPaginasGreaterThan(int paginas);

    List<Libro> findByAutorId(Long id);

    List<Libro> findByAutorNombre(String nombre);

    List<Libro> findByAutorNombreContaining(String nombre);

}
