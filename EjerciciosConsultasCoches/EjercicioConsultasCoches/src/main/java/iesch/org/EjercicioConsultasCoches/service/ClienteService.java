package iesch.org.EjercicioConsultasCoches.service;

import iesch.org.EjercicioConsultasCoches.model.Cliente;
import iesch.org.EjercicioConsultasCoches.repository.CLienteRepository;
import iesch.org.EjercicioConsultasCoches.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private CLienteRepository clienteRepository;

    @Autowired
    private CocheRepository cocheRepository;

    // Obtener todos los clientes
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    // Obtener cliente por ID
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Consulta 1: clientes que tienen coches de un color
    public List<Cliente> findClientesByColor(String color) {
        return clienteRepository.findByCochesColorIgnoreCase(color);
    }

    // Consulta 2: clientes con coches más caros que X
    public List<Cliente> findClientesByPrecioMayor(double precio) {
        return clienteRepository.findByCochesPrecioGreaterThan(precio);
    }

    // Consulta 3: cliente dueño de una matrícula
    public Cliente findByMatricula(String matricula) {
        return clienteRepository.findByCochesMatricula(matricula);
    }
}
