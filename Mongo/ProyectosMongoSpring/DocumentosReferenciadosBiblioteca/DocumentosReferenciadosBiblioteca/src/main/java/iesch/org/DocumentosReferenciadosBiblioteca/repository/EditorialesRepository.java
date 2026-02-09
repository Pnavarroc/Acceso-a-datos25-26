package iesch.org.DocumentosReferenciadosBiblioteca.repository;

import iesch.org.DocumentosReferenciadosBiblioteca.model.Editoriales;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialesRepository extends MongoRepository<Editoriales,Long> {
}
