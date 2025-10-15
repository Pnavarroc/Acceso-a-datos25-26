package org.iesch.ad.primerSpring.service;

import org.springframework.stereotype.Service;

@Service
public class Utils {

    //Separamos la lógica de negocio de to do lo demas
    public String transformarAMayus(String texto){
        return texto.toUpperCase();
    }
}
