package iesch.org.ad.Excepciones.controlador;

import iesch.org.ad.Excepciones.model.Estudiante;
import iesch.org.ad.Excepciones.model.dto.EstudianteRequestDTO;
import iesch.org.ad.Excepciones.model.dto.EstudianteResponseDTO;
import iesch.org.ad.Excepciones.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteControlador {



    @Autowired
    EstudianteService estudianteService;

    @GetMapping
    public ResponseEntity<List<EstudianteResponseDTO>> obtenerTodos(){

        List<EstudianteResponseDTO> studiantes = estudianteService.obtenerTodos();

        return ResponseEntity.ok(studiantes);
    }

    /**
     * GET/api/estudiantes/{id}
     * Obtener un estudiante por id
     * Puede lanzar excepciones EstudianteNoEncontradoException
     *
     * */

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> obtenerUno(@PathVariable Long id){
        EstudianteResponseDTO estudianteResponseDTO = estudianteService.obtenerPorId(id);

        return ResponseEntity.ok(estudianteResponseDTO);
    }

    /**
     * GET/api/estudiantes/
     * Creo unj estudiante nuevo
     * Puede lanzar excepciones EmailDuplicadoException
     *
     * */
    @PostMapping
    public ResponseEntity<EstudianteResponseDTO> crearUser
            (@Valid @RequestBody EstudianteRequestDTO estudianteRequestDTO){


        EstudianteResponseDTO nuevoEstudiante = estudianteService.crear(estudianteRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstudiante);

    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> actualizar
            (@PathVariable Long id,  @Valid @RequestBody EstudianteRequestDTO estudianteRequestDTO){

        EstudianteResponseDTO estudianteActualizado = estudianteService.actualizar(id, estudianteRequestDTO);

        return ResponseEntity.ok(estudianteActualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        estudianteService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
    /***
     * GET /api/estudiantes/ciclo/{ciclo}
     *Obtener estudiantes por ciclo formativo
     * Puede lanzar excepciones  DatosInvalidosException o EstudianteNoEncontradoException
     */
    @GetMapping("/ciclo/{ciclo}")
    public ResponseEntity<List<EstudianteResponseDTO>> obtenerPorCiclo(
            @PathVariable String ciclo){

        List<EstudianteResponseDTO> listaEstudiantes = estudianteService.obtenerPorCiclo(ciclo);

        return ResponseEntity.ok(listaEstudiantes);
    }

}




















