package iesch.org.concesionario.repositorys;

import iesch.org.concesionario.models.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisionRepository extends JpaRepository<Revision,Long>
{

}
