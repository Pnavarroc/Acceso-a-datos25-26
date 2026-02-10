package org.iesch.ad.DocumentosReferenciados.Repository;

import org.iesch.ad.DocumentosReferenciados.model.AutoresRef;
import org.jspecify.annotations.Nullable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoresRefRepository extends MongoRepository<AutoresRef,String> {

    //=============CONSULTAS================

    //Buscar por nombre de autor ingnorando mayus y minus
    List<AutoresRef> findByNombreContainingIgnoreCase(String nombreAutor);

    //Buscar por nacionalidad ignorando mayus minus
    List<AutoresRef> findByNacionalidadContainingIgnoreCase(String nacionalidad);

    //Buscar por varias nacionalidades
    List<AutoresRef> findByNacionalidadIn(List<String> paises);
}
