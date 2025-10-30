package iesch.org.ad.Excepciones.service;

import iesch.org.ad.Excepciones.exception.DatosInvalidosException;
import iesch.org.ad.Excepciones.exception.EstudianteNoEncontradoException;
import iesch.org.ad.Excepciones.exception.EmailDuplicadoException;
import iesch.org.ad.Excepciones.model.Estudiante;
import iesch.org.ad.Excepciones.model.dto.EstudianteRequestDTO;
import iesch.org.ad.Excepciones.model.dto.EstudianteResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class EstudianteService {

    @Autowired
    Map<Long, Estudiante> estudiantes;

    public List<EstudianteResponseDTO> obtenerTodos() {

        List<Estudiante> listaEstudiantes = new ArrayList<>(estudiantes.values());

        List<EstudianteResponseDTO> estudianteResponseDTOS =
                listaEstudiantes.stream().map(EstudianteResponseDTO::new).toList();

        return estudianteResponseDTOS;

    }

    public EstudianteResponseDTO obtenerPorId(Long id) {

        Estudiante estudiante = estudiantes.get(id);
        if (estudiante!=null){
            return new EstudianteResponseDTO(estudiante);

        }else {
            throw new EstudianteNoEncontradoException(id);
        }
    }


    public EstudianteResponseDTO crear(@Valid EstudianteRequestDTO estudianteRequestDTO) {

        //Validamos que no exista en BBDD(en este caso un MAP<>) el email

        boolean emailExiste = estudiantes.values().stream()
                .anyMatch(e-> e.getEmail().equalsIgnoreCase(estudianteRequestDTO.getEmail()));

        if (emailExiste){
            throw new EmailDuplicadoException(estudianteRequestDTO.getEmail());
        }
        //Crear el usuario en mi mapa

        Long maxKey = estudiantes.keySet().stream().max(Long::compareTo).orElse(1L);
        Estudiante estudiante = new Estudiante(maxKey+1,estudianteRequestDTO.getNombre(),
                estudianteRequestDTO.getApellidos(),estudianteRequestDTO.getEmail(),estudianteRequestDTO.getEdad()
                ,estudianteRequestDTO.getCiclo());

        estudiantes.put(estudiante.getId(),estudiante);
        return new EstudianteResponseDTO(estudiante);


    }

    public EstudianteResponseDTO actualizar(Long id, @Valid EstudianteRequestDTO estudianteRequestDTO) {
        Estudiante estudiante = estudiantes.get(id);

        boolean emailExiste = estudiantes.values().stream()
                .anyMatch(e-> e.getEmail().equalsIgnoreCase(estudianteRequestDTO.getEmail()));

        if (emailExiste){
            throw new EmailDuplicadoException(estudianteRequestDTO.getEmail());
        }

        estudiante.setNombre(estudianteRequestDTO.getNombre());
        estudiante.setApellidos(estudianteRequestDTO.getApellidos());
        estudiante.setEmail(estudianteRequestDTO.getEmail());
        estudiante.setEdad(estudianteRequestDTO.getEdad());
        estudiante.setCiclo(estudianteRequestDTO.getCiclo());

        return new EstudianteResponseDTO(estudiante);
    }

    public void eliminar(Long id) {
        Estudiante estudiante = estudiantes.get(id);

        if (estudiante!=null){
            throw new EstudianteNoEncontradoException(id);
        }
        estudiantes.remove(id);
    }

    public List<EstudianteResponseDTO> obtenerPorCiclo(String ciclo) {
        //Validamos q el ciclo sea valido

        if (!ciclo.matches("(?i)DAM|DAW|ASIR|SMR")){
            throw new DatosInvalidosException("Ciclo no valido");
        }

        List<EstudianteResponseDTO> resultado = estudiantes.values().stream()
                .filter(e->e.getCiclo().equalsIgnoreCase(ciclo))
                .map(EstudianteResponseDTO::new).toList();

        if (resultado.isEmpty()){
            throw new EstudianteNoEncontradoException("No existen estudiantes del ciclo " +ciclo);
        }
        return resultado;

    }
}
