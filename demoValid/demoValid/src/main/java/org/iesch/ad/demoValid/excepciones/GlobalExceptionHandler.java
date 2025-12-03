package org.iesch.ad.demoValid.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> manejarDatosErroneos(MethodArgumentNotValidException ex ){
        String mensaje = "Error de validación "+ ex.getBindingResult().getFieldError().getDefaultMessage();

        //return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                mensaje);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);

    }

    /*@ExceptionHandler(MiExcepcion.class)
    public ResponseEntity<ErrorResponseDTO> tratandoMiError(MiExcepcion miExcepcion){


        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }*/
}
