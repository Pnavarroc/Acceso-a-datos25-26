package iesch.org.AutorLibroCrudConsultas.service;

import iesch.org.AutorLibroCrudConsultas.model.Autor;
import iesch.org.AutorLibroCrudConsultas.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    public List<Autor> mostrarAutores(){
        return autorRepository.findAll();
        //List<Autor> autores = autorRepository.findAll();
        /*if (autores.isEmpty()){
            return null;
        }else {
            return autores;
        }*/
    }

    public Autor mostrarAutorPorId(Long id){
        //Optional<Autor> autor = autorRepository.findById(id);
        return autorRepository.findById(id).orElse(null);
        /*if (autor.isEmpty()){
            return null;
        }else {
            return autor.orElse(null);
        }*/
    }

    public Autor guardarAutor(Autor autor){
        return autorRepository.save(autor);
    }

    public Autor borrarPorId(Long id){
        /*Autor autor = autorRepository.getReferenceById(id);
        autorRepository.deleteById(autor.getId());
        return autor;*/
        autorRepository.deleteById(id);
        return null;
    }


}
