package iesch.org.PrimerCrudBBDD.service;

import iesch.org.PrimerCrudBBDD.model.Persona;
import iesch.org.PrimerCrudBBDD.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    //Tenemos el get todos
    public List<Persona> findAll(){
        return personaRepository.findAll();
    }

    //Tenemos el get por id
    public Persona buscarPorId(Long id){
        return personaRepository.findById(id).orElse(null);
    }

    //Vamos con el guardar
    public Persona guardarPersona(Persona persona){
        return personaRepository.save(persona);
    }

    //Vamos con el delete
    public void borrarPersona(Long id){
        personaRepository.deleteById(id);
    }



}
