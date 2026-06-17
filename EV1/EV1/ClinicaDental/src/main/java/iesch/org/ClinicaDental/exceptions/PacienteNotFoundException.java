package iesch.org.ClinicaDental.exceptions;

public class PacienteNotFoundException extends RuntimeException
{
    public PacienteNotFoundException(String mensaje)
    {
        super(mensaje);
    }
}
