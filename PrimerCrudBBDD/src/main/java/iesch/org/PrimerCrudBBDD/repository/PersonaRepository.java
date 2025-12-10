package iesch.org.PrimerCrudBBDD.repository;

import iesch.org.PrimerCrudBBDD.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
