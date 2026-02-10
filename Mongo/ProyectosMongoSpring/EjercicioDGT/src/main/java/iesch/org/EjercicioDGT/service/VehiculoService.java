package iesch.org.EjercicioDGT.service;

import iesch.org.EjercicioDGT.model.Vehiculo;
import iesch.org.EjercicioDGT.repository.VehiculoRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;

    public List<Vehiculo> getAll() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo getById(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id no puede estar vacío");
        }

        return vehiculoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("No existe ningún vehículo con id: " + id));
    }

    public Vehiculo crearVehiculo(Vehiculo vehiculo) {

        // Matrícula única
        if (vehiculoRepository.existsByMatricula(vehiculo.getMatricula())) {
            throw new RuntimeException("La matrícula ya existe en el sistema");
        }

        // Bastidor obligatorio y único
        if (vehiculo.getBastidor() == null || vehiculo.getBastidor().isBlank()) {
            throw new RuntimeException("El bastidor es obligatorio");
        }

        if (vehiculoRepository.existsByBastidor(vehiculo.getBastidor())) {
            throw new RuntimeException("El bastidor ya existe en el sistema");
        }

        // Fecha fabricación no futura
        int anioActual = java.time.Year.now().getValue();
        if (vehiculo.getAnioFabricacion() > anioActual) {
            throw new RuntimeException("El año de fabricación no puede ser futuro");
        }

        // DNI válido
        if (vehiculo.getTitular() == null ||
                !dniValido(vehiculo.getTitular().getDni())) {
            throw new RuntimeException("DNI del titular no válido");
        }

        // Vehículo nuevo o usado
        int antiguedad = anioActual - vehiculo.getAnioFabricacion();

        if (antiguedad < 4) {
            // Vehículo NUEVO → eITV
            if (vehiculo.getItv() == null ||
                    vehiculo.getItv().geteITV() == null ||
                    vehiculo.getItv().geteITV().isBlank()) {

                throw new RuntimeException("Vehículo nuevo debe tener eITV");
            }

            vehiculo.getItv().setNumeroInforme(
                    vehiculo.getItv().geteITV()
            );

        } else {
            // Vehículo USADO → ITV en vigor
            if (vehiculo.getItv() == null || !vehiculo.getItv().isEnVigor()) {
                throw new RuntimeException("Vehículo usado debe tener ITV en vigor");
            }

            if (vehiculo.getItv().getNumeroInforme() == null ||
                    vehiculo.getItv().getNumeroInforme().isBlank()) {

                throw new RuntimeException("Vehículo usado debe tener número de informe ITV");
            }
        }

        // Fechas del sistema
        vehiculo.setFechaCreacion(Instant.now());
        vehiculo.setFechaActualizacion(Instant.now());

        return vehiculoRepository.save(vehiculo);
    }

    // Validación DNI
    private boolean dniValido(String dni) {
        if (dni == null) return false;
        return dni.matches("^[0-9]{8}[A-Z]$");
    }
}

