package org.iesch.ad.primerSpring.controller;

import org.iesch.ad.primerSpring.service.Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MiPrimerController {

    //Le ponemos una ruta a
    @GetMapping("/saludo")
    public String saludo(){
        return "Hola mundo!";
    }




    @GetMapping("/saluda/{nombre}")
    public Map<String,String> saludarA(@PathVariable String nombre){
        Utils utils= new Utils();
        String nombreMayus= utils.transformarAMayus(nombre);
        Map<String,String> mapa = Map.of("Saludo",""+nombreMayus);
        return mapa;
    }
}
