package iesch.org.ClinicaDental.repository;

import iesch.org.ClinicaDental.model.Cita;
import iesch.org.ClinicaDental.model.Estado;
import iesch.org.ClinicaDental.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita,Long>
{
    /*
    *
    * Buscar citas de un paciente
    *Buscar citas de un dentista
    * Buscar citas por estado
    * Buscar citas de un paciente con estado concreto
    * Buscar citas con precio mayor que X
    * Buscar citas entre dos fechas
    * Sacar citas mostrando solo las de una ciudad concreta del paciente
    * */

    List<Cita> findByPacienteId(Long pacienteId);
    List<Cita> findByDentistaId(Long dentistaId);

    List<Cita> findByEstado(Estado estado);

    List<Cita> findByPacienteIdAndEstado(Long pacienteId, Estado estado);

    List<Cita> findByPrecioGreaterThan(Double precio);

    List<Cita> findByFechaBetween(LocalDate f1,LocalDate f2);

    List<Cita> findByPacienteCiudad(String ciudad);

    //Obtener todas las citas de un paciente concreto que estén en estado PENDIENTE.

    //List<Cita> findByPacienteIdAndEstado(Long pacienteId, Estado estado);

    //Obtener todas las citas de un dentista concreto cuyo precio sea superior a 100€.

    List<Cita> findByDentistaIdAndPrecioGreaterThan(Long dentistaId, double precio);

    //Obtener todas las citas realizadas entre dos fechas para un paciente concreto.

    List<Cita> findByPacienteIdAndFechaBetween(Long pacienteId, LocalDate f1, LocalDate f2);

    //Obtener todas las citas de pacientes que vivan en una ciudad concreta.

    //List<Cita> findByPacienteCiudad(String ciudad);

    //Obtener todas las citas de dentistas cuya especialidad sea "Ortodoncia".
    List<Cita> findByDentistaEspecialidad(String especialidad);

    //Obtener todas las citas canceladas de un paciente concreto ordenadas por fecha descendente.

    List<Cita> findByPacienteIdAndEstadoOrderByFechaDesc(Long pacienteId, Estado estado);

    //Obtener todas las citas cuyo paciente tenga un nombre que contenga un texto determinado.

    List<Cita> findByPacienteNombreContaining(String nombre);

    //Obtener todas las citas de dentistas cuyo nombre empiece por un texto determinado.

    List<Cita> findByDentistaNombreContaining(String nombre);

    //Obtener todas las citas de pacientes de Zaragoza que además estén en estado REALIZADA.

    List<Cita> findByEstadoAndPacienteCiudad(Estado estado, String ciudad);

    //Obtener todas las citas de un dentista concreto comprendidas entre dos fechas y ordenadas por precio descendente.

    List<Cita> findByDentistaIdAndFechaBetweenOrderByPrecioDesc(Long dentistaId, LocalDate f1, LocalDate f2);


}
