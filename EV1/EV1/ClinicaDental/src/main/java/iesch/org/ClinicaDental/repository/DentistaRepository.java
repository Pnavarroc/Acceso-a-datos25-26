package iesch.org.ClinicaDental.repository;

import iesch.org.ClinicaDental.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista,Long>
{
    //Buscar dentistas por especialidad
    List<Dentista> findByEspecialidad(String especialidad);
}
