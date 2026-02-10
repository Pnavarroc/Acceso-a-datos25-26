package iesch.org.EjercicioDGT.repository;

import iesch.org.EjercicioDGT.model.Vehiculo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends MongoRepository<Vehiculo,String> {

    boolean existsByMatricula(String matricula);

    boolean existsByBastidor(String bastidor);
}
