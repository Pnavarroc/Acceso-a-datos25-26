package iesch.org.EjercicioConsultasCoches.service;

import iesch.org.EjercicioConsultasCoches.model.Coche;
import iesch.org.EjercicioConsultasCoches.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheService {

    @Autowired
    private CocheRepository cocheRepository;

    // Obtener todos los coches
    public List<Coche> findAll() {
        return cocheRepository.findAll();
    }

    // Obtener coche por ID
    public Coche findById(Long id) {
        return cocheRepository.findById(id).orElse(null);
    }

    // Consulta: coches por marca
    public List<Coche> findByMarca(String marca) {
        return cocheRepository.findByMarcaIgnoreCase(marca);
    }

    // Consulta: coches más caros que X
    public List<Coche> findByPrecioMayor(double precio) {
        return cocheRepository.findByPrecioGreaterThan(precio);
    }

    // Consulta: buscar por modelo que contiene texto
    public List<Coche> findByModeloLike(String texto) {
        return cocheRepository.findByModeloContainingIgnoreCase(texto);
    }

    //consulta buscar coche por color y cliente
    public List<Coche> findByColorAndClient(String color, Long clienteId){
        return cocheRepository.findByColorIgnoreCaseAndClientId(color,clienteId);
    }

    public List<Coche> findByPrecioBwettenXAndY(double precioMinimo, double precioMaximo){
        return cocheRepository.findByPrecioBetweenOrderByPrecioDesc(precioMinimo,precioMaximo);
    }


}
