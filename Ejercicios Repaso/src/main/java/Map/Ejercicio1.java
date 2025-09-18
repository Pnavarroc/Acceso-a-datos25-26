package Map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Ej1. Crear un Map que asocie nombres de países con sus capitales. Luego,
imprimir todos los pares de clave-valor del Map.*/
public class Ejercicio1 {
    public static void main(String[] args) {
        Map<String,String> paises = new HashMap<>();
        paises.put("España","Madrid");
        paises.put("Portugal","Lisboa");
        paises.put("Francia","Paris");
        paises.put("Italia","Roma");

        for (Map.Entry<String,String> pais: paises.entrySet()){
            System.out.println(pais.getKey()+ " Su capital es: "+ pais.getValue());
        }
    }
}
