package iesch.org.ad.Excepciones.exception;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ErrorResponseDTO {

    private LocalDateTime timesTamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private List<String> detalle;//para errores de validades multiples.


    public ErrorResponseDTO(LocalDateTime timesTamp, int status, String error, String message, String path){
        this.timesTamp = timesTamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }


}
