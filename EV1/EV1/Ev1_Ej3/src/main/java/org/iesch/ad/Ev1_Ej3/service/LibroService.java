package org.iesch.ad.Ev1_Ej3.service;

import org.iesch.ad.Ev1_Ej3.repository.LibroRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired
    LibroRepository libroRepository;

    public Object librosPorEditorial(String editorial) {
        return libroRepository.findLibrosByEditorialNombre(editorial);
    }

    public @Nullable Object librosPorClienteNombre(String nombre) {
        return libroRepository.findLibrosByPedidosByClienteNombre(nombre);
    }
}
