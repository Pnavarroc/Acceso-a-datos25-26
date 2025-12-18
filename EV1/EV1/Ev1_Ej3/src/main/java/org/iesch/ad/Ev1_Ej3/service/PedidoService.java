package org.iesch.ad.Ev1_Ej3.service;

import org.iesch.ad.Ev1_Ej3.repository.PedidoRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public @Nullable Object pedidosConLibro(String libro) {
        return pedidoRepository.findPedidosByLibrosTitulo(libro);
    }

    public @Nullable Object pedidosPorNombre(String nombre) {

        return pedidoRepository.findPedidosByClienteNombre(nombre);
    }
}
