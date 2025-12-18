package iesch.org.EjercicioConsultasCoches.repository;

import iesch.org.EjercicioConsultasCoches.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {


    List<Coche> findByMarcaIgnoreCase(String marca);


    List<Coche> findByPrecioGreaterThan(double precio);

    List<Coche> findByModeloContainingIgnoreCase(String texto);

    //Vamos a hacer una consulta : dame los coches de color x del cliente y.

    List<Coche> findByColorIgnoreCaseAndClientId(String color,Long clienteId);

    //“Devuelve todos los coches cuyo precio esté entre un mínimo y un máximo,
    // y ordénalos de mayor a menor precio.”
    public List<Coche> findByPrecioBetweenOrderByPrecioDesc(
            double precioMinimo, double precioMaximo);

}

