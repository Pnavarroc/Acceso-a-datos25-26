package iesch.org.EjercicioDGT.service;

import iesch.org.EjercicioDGT.model.Multa;
import iesch.org.EjercicioDGT.model.Vehiculo;
import iesch.org.EjercicioDGT.repository.VehiculoRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class VehiculoService
{
    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> getAll() {

        return vehiculoRepository.findAll();
    }

    public Vehiculo postVehicle(Vehiculo vehiculo)
    {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        String matricula = vehiculo.getMatricula();
        String bastidor = vehiculo.getBastidor();
        int anioFabricacion = vehiculo.getAnioFabricacion();
        int anioActual = LocalDate.now().getYear();
        int aniosDiferencia = anioActual-anioFabricacion;
        String campoeItv = vehiculo.getItv().geteITV();
        boolean estaEnVigorITV = vehiculo.getItv().isEnVigor();

        //Lo primero de todo la matricula no debe existir.
        boolean matriculaExists = vehiculos.stream()
                .anyMatch(v-> v.getMatricula().equals(matricula));

        if (matriculaExists) throw new RuntimeException("La matricula insertada ya existe: "+matricula);


        //Bastidor
        if(bastidor == null || bastidor.isEmpty()) throw new RuntimeException("El bastidor es obligatorio");

        boolean bastidorExists = vehiculos.stream()
                .anyMatch(v-> v.getBastidor().equals(bastidor));

        if(bastidorExists) throw new RuntimeException("El bastidor insertado ya existe: "+bastidor);

        // Si el vehiculo es menor de 4 años debe de comenzar por e- el campo de la ITV
        if(aniosDiferencia<4 && !campoeItv.startsWith("e-"))
            throw new RuntimeException("Su itv no tiene tarjeta electronica:"+campoeItv);

        if(aniosDiferencia>4 && !estaEnVigorITV)
            throw new RuntimeException("La itv no la tiene en vigor");

        //DNI titular debe ser válido

        //FechaFabricacion no puede ser futura:
        if (anioActual<anioFabricacion) throw new RuntimeException("Es imposible que se fabricase en el futuro");

        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo createMulta(String matricula, Multa multa)
    {
        //Primero que el vehiculo exista osea que la matricula exista

        Vehiculo vehiculo1 =vehiculoRepository.findByMatricula(matricula).orElseThrow(()->new RuntimeException("La matricula no existe"));

        Double importe = multa.getImporte();

        if (importe<=0) throw new RuntimeException("El importe debe ser mayor a 0");

        Integer puntos = multa.getPuntos();

        if (puntos<0 || puntos>5) throw new RuntimeException("Los puntos deben estar entre 0 y 5");

        multa.setEstado("PENDIENTE_PAGO");

        Random random = new Random(1000);
        Long idMulta = random.nextLong();
        multa.setId(String.valueOf(idMulta));

        vehiculo1.getMultas().add(multa);
        return vehiculoRepository.save(vehiculo1);
    }

    public List<Vehiculo> getVehiculosByDNI(String dni)
    {
        return vehiculoRepository.findByTitular_Dni(dni);
    }

    public List<Vehiculo> BuscarVehiculosByEstado(String estado)
    {
        return vehiculoRepository.findBySituacionAdministrativa_Estado(estado);
    }

    public List<Vehiculo> BuscarPorMarcayModelo(String marca, String modelo)
    {
        return vehiculoRepository.findByMarcaAndModelo(marca, modelo);
    }

    public List<Vehiculo> buscarCochesItvCaducada()
    {
        return vehiculoRepository.findByItv_EnVigorFalse();
    }

    public List<Vehiculo> getCochesITMVPagadoYNOMultas()
    {
        return vehiculoRepository.findVehiculosConItmvPagadoYSinMultasPendientes();
    }


    public List<Vehiculo> findVehiculosConMultasPendientes()
    {
        return vehiculoRepository.findVehiculosConMultasPendientes();
    }
}
