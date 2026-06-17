package iesch.org.concesionario.service;

import iesch.org.concesionario.models.Cliente;
import iesch.org.concesionario.repositorys.ClienteRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll()
    {
        return clienteRepository.findAll();
    }

    public Cliente getById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Este id no existe"));
    }

    public Cliente createOne(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateOne(Long id, Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El id insertado no existe"));

        clienteExistente.setNif(cliente.getNif());
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setCiudad(cliente.getCiudad());
        clienteExistente.setTelefono(cliente.getTelefono());

        return clienteRepository.save(clienteExistente);
    }

    public void deleteOne(Long id) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Este id no existe"));

        clienteRepository.delete(clienteExistente);
    }
}