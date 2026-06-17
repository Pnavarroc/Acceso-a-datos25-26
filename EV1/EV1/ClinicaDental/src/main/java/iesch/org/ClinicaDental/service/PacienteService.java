package iesch.org.ClinicaDental.service;

import iesch.org.ClinicaDental.exceptions.PacienteNotFoundException;
import iesch.org.ClinicaDental.model.Paciente;
import iesch.org.ClinicaDental.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService
{
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> getAll()
    {
        return pacienteRepository.findAll();
    }


    public  Paciente getById(Long id)
    {
        return pacienteRepository.findById(id).orElseThrow(()->new PacienteNotFoundException("Paciente con id " + id + " no encontrado"));
    }

    public Paciente createOne(Paciente paciente)
    {
        return pacienteRepository.save(paciente);
    }

    public Paciente updateOne(Long id, Paciente paciente)
    {
        Paciente pacienteExistente = pacienteRepository.findById(id).orElseThrow(()-> new RuntimeException("No existe este id"));

        paciente.setId(id);
        return pacienteRepository.save(paciente);
    }

    public void deleteOne(Long id)
    {
        Paciente pacienteExistente = pacienteRepository.findById(id).orElseThrow(()-> new RuntimeException("No existe este id"));

        pacienteRepository.deleteById(id);
    }
}
