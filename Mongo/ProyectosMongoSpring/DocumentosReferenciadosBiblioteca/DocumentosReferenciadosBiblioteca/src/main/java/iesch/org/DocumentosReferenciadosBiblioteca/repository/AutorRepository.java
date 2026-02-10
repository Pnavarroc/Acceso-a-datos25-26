package iesch.org.DocumentosReferenciadosBiblioteca.repository;

import iesch.org.DocumentosReferenciadosBiblioteca.model.Autores;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends MongoRepository<Autores,Long> {
}
