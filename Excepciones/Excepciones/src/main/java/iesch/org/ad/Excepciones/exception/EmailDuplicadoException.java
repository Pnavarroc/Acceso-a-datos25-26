package iesch.org.ad.Excepciones.exception;

public class EmailDuplicadoException extends RuntimeException {
    public EmailDuplicadoException(String email) {
        super("El email "+email+" ya esta en uso");
    }
}
