package iesch.org.concesionario.repositorys;

import iesch.org.concesionario.models.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche,Long>
{

}
