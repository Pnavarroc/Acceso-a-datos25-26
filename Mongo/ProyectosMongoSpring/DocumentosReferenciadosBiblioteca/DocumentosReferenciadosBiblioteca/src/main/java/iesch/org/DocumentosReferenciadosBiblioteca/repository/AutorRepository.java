package iesch.org.DocumentosReferenciadosBiblioteca.repository;

import iesch.org.DocumentosReferenciadosBiblioteca.model.Autores;
import iesch.org.DocumentosReferenciadosBiblioteca.model.Libros;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends MongoRepository<Autores,Long> {



}
