package iesch.org.concesionario.service;

import iesch.org.concesionario.models.Revision;
import iesch.org.concesionario.repositorys.RevisionRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevisionesService
{
    @Autowired
    private RevisionRepository revisionRepository;


    public @Nullable Object getAll()
    {
        return revisionRepository.findAll();
    }

    public @Nullable Object getById(Long id)
    {
        return revisionRepository.findById(id).orElseThrow(()->new RuntimeException("Este id no existe"));
    }

    public @Nullable Object createOne(Revision revision)
    {
        return revisionRepository.save(revision);
    }

    public @Nullable Object updateOne(Long id, Revision revision)
    {
        Revision nuevoRevision = revisionRepository.findById(id).orElseThrow(()->new RuntimeException("El id insertado no existe"));

        revision.setId(id);
        return revisionRepository.save(revision);
    }

    public Revision deleteOne(Long id)
    {
        Revision revisionExistente = revisionRepository.findById(id).orElseThrow(()-> new RuntimeException("Este id no existe"));

        revisionRepository.deleteById(id);
        return revisionExistente;
    }
}
