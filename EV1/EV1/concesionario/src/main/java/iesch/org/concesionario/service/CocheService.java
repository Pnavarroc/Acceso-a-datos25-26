package iesch.org.concesionario.service;

import iesch.org.concesionario.models.Coche;
import iesch.org.concesionario.repositorys.CocheRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CocheService
{
    @Autowired
    private CocheRepository cocheRepository;


    public @Nullable Object getAll()
    {
        return cocheRepository.findAll();
    }

    public @Nullable Object getById(Long id)
    {
        return cocheRepository.findById(id).orElseThrow(()->new RuntimeException("Este id no existe"));
    }

    public @Nullable Object createOne(Coche coche)
    {
        return cocheRepository.save(coche);
    }

    public @Nullable Object updateOne(Long id, Coche coche)
    {
        Coche nuevoCoche = cocheRepository.findById(id).orElseThrow(()->new RuntimeException("El id insertado no existe"));

        coche.setId(id);
        return cocheRepository.save(coche);
    }

    public Coche deleteOne(Long id)
    {
        Coche cocheExistente = cocheRepository.findById(id).orElseThrow(()-> new RuntimeException("Este id no existe"));

        cocheRepository.deleteById(id);
        return cocheExistente;
    }
}
