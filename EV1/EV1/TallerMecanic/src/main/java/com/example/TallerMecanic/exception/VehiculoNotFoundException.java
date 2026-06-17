package com.example.TallerMecanic.exception;

public class VehiculoNotFoundException extends RuntimeException
{
    public VehiculoNotFoundException(String mensaje)
    {
        super(mensaje);
    }
}
