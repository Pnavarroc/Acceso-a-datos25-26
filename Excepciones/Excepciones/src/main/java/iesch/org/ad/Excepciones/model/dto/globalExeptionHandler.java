package iesch.org.ad.Excepciones.model.dto;

import iesch.org.ad.Excepciones.exception.ErrorResponseDTO;
import iesch.org.ad.Excepciones.exception.EstudianteNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class globalExeptionHandler {
    /*
    * Maneja la excepcion cuando no se encuantra el estuciante y ademas devuelve un
    *  404 NOT FOUND*/
    @ExceptionHandler(EstudianteNoEncontradoException.class)
    public ResponseEntity<ErrorResponseDTO> manejarEstudianteNoEncontrado(
            EstudianteNoEncontradoException ex, WebRequest request
    ){
        ErrorResponseDTO error = new ErrorResponseDTO(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not found",
                ex.getMessage(),
                request.getDescription(false).replace("uri:=","")
        );
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }




}
