package org.iesch.ad.EjemploJson.controler;

import org.iesch.ad.EjemploJson.model.Numero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculadora {
    @GetMapping("/suma")
    public String suma (@RequestBody Numero numero){

        return "El resultado de la suma es: "+numero.getOperando1()+numero.getOperando2();

    }
    @GetMapping("/resta")

    public String resta (@RequestBody Numero numero){

        return "El resultado de la resta es: "+ (numero.getOperando1()-numero.getOperando2());

    }
    @GetMapping("/multiplicacion")

    public String multiplicacion (@RequestBody Numero numero){

        return "El resultado de la multiplicacion es: "+ (numero.getOperando1()*numero.getOperando2());

    }
    @GetMapping("/division")

    public String division (@RequestBody Numero numero){

        return "El resultado de la division es: "+ (numero.getOperando1()/numero.getOperando2());

    }
}
