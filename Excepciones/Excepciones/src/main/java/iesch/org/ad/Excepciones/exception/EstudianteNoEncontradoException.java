package iesch.org.ad.Excepciones.exception;

public class EstudianteNoEncontradoException extends RuntimeException {

    public EstudianteNoEncontradoException(Long id) {
        super("No se encontró el estudiante con ID: "+id);
    }
    public EstudianteNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
