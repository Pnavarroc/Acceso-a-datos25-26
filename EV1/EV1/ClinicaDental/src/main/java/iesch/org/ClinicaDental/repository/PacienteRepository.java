package iesch.org.ClinicaDental.repository;

import iesch.org.ClinicaDental.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long>
{
    //Buscar pacientes por ciudad
    public List<Paciente> findByCiudad(String ciudad);

}
