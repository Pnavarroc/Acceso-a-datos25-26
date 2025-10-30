package iesch.org.ad.Excepciones.model.dto;

import iesch.org.ad.Excepciones.exception.DatosInvalidosException;
import iesch.org.ad.Excepciones.exception.ErrorResponseDTO;
import iesch.org.ad.Excepciones.exception.EstudianteNoEncontradoException;
import iesch.org.ad.Excepciones.exception.EmailDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class globalExeptionHandler {
    /*
    * Maneja la excepcion cuando no se encuantra el estudiante y ademas devuelve un
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

    //Maneja la excepcion cuando hay algún email duplicado
    //Devuelve HTTP 409 CONFLICT
    @ExceptionHandler(EmailDuplicadoException.class)
    public ResponseEntity<ErrorResponseDTO> manejarEmailDuplicado(
            EmailDuplicadoException ex, WebRequest request){

        ErrorResponseDTO error = new ErrorResponseDTO(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                "Conflict",
                ex.getMessage(),
                request.getDescription(false).replace("uri:=","")
        );
        return new ResponseEntity<>(error,HttpStatus.CONFLICT);

    }
    /**
     * Maneja excepciones de datos invalidos
     * Devuelve un error 400 BAD REQUEST*/
    @ExceptionHandler(DatosInvalidosException.class)
    public ResponseEntity<ErrorResponseDTO> manejarCicloInvalido(
            DatosInvalidosException ex, WebRequest request
    ){
        ErrorResponseDTO error = new ErrorResponseDTO(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad request",
                ex.getMessage(),
                request.getDescription(false).replace("uri:=","")
        );
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> manejarValidacion(
            MethodArgumentNotValidException ex, WebRequest request
    ){
        List<String> detalles = new ArrayList<>();

        //Extraer los metodos de validacion

        for(FieldError error : ex.getBindingResult().getFieldErrors() ){
            detalles.add(error.getField() + ": "+error.getDefaultMessage());
        }

        ErrorResponseDTO error = new ErrorResponseDTO(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad request",
                ex.getMessage(),
                request.getDescription(false).replace("uri:=",""),
                detalles
        );
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }




}
