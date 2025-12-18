package iesch.org.EjercicioConsultasCoches.repository;

import iesch.org.EjercicioConsultasCoches.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CLienteRepository extends JpaRepository<Cliente,Long> {
    List<Cliente> findByCochesColorIgnoreCase(String color);

    List<Cliente> findByCochesPrecioGreaterThan(double precio);

    Cliente findByCochesMatricula(String matricula);
}
