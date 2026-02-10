package iesch.org.DocumentosReferenciadosBiblioteca.repository;

import iesch.org.DocumentosReferenciadosBiblioteca.model.Libros;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends MongoRepository<Libros,Long> {
}
