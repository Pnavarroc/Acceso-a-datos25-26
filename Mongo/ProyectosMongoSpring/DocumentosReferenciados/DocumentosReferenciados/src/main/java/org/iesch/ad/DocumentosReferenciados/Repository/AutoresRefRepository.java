package org.iesch.ad.DocumentosReferenciados.Repository;

import org.iesch.ad.DocumentosReferenciados.model.AutoresRef;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoresRefRepository extends MongoRepository<AutoresRef,String> {
}
