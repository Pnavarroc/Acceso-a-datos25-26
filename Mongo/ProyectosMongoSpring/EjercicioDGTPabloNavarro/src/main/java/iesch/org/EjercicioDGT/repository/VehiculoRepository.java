package iesch.org.EjercicioDGT.repository;

import iesch.org.EjercicioDGT.model.Vehiculo;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VehiculoRepository extends MongoRepository<Vehiculo, String>
{

    public Optional<Vehiculo> findByMatricula(String matricula);

    public List<Vehiculo> findByTitular_Dni(String dni);

    List<Vehiculo> findBySituacionAdministrativa_Estado(String estado);

    List<Vehiculo> findByMarcaAndModelo(String marca, String modelo);

    List<Vehiculo> findByItv_EnVigorFalse();

    //List<Vehiculo> findByImpuestos_ItmvPagadoTrueAndMultasEmpty();

    @Aggregation(pipeline = {
            "{ $match: { " +
                    "'impuestos.itmvPagado': true, " +
                    "'multas': { $size: 0 } " +
                    "} }"
    })
    List<Vehiculo> findVehiculosConItmvPagadoYSinMultasPendientes();


    @Aggregation(pipeline = {
            """
                {
                    $match:
                    {
                        'multas.estado': 'PENDIENTE_PAGO'
                    }
                }
            """
    })
    List<Vehiculo> findVehiculosConMultasPendientes();



}
