package org.iesch.ad.demoFechas.Repositorio;

import org.iesch.ad.demoFechas.modelo.Evento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoFechasRepositorio extends MongoRepository<Evento, String> {
}
