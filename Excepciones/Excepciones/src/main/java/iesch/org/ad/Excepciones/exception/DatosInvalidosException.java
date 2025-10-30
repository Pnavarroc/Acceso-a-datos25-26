package iesch.org.ad.Excepciones.exception;

public class DatosInvalidosException extends RuntimeException {
    public DatosInvalidosException(String cicloNoValido) {
        super("El ciclo "+cicloNoValido+" no es válido");
    }
}
