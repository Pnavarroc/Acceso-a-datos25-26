package org.iesch.ad.Ev1_Ej3.service;

import org.iesch.ad.Ev1_Ej3.repository.CLienteRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ClienteService {

    @Autowired
    CLienteRepository cLienteRepository;

    @GetMapping
    public Object buscarTodos(){
        return cLienteRepository.findAll();
    }


    public Object clientesPorFecha(String fecha) {

        return cLienteRepository.findClientesByPedidosFecha(fecha);
    }

    public @Nullable Object clientesCompranLibroConPrecioMayor(Double precio) {

        return cLienteRepository.findClientesByPedidosByLibrosPrecioGreaterThan(precio);
    }
}
