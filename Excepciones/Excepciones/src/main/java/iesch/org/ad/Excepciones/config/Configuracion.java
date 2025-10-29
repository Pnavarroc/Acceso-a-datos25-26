package iesch.org.ad.Excepciones.config;

import iesch.org.ad.Excepciones.model.Estudiante;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Configuracion {

    @Bean
    public Map<Long, Estudiante> inicializa(){
        Map<Long, Estudiante> estudiantes = new HashMap<>();
        Estudiante estudiante1 = new Estudiante(1L,"Pablo","Navarro","pnavarroc@iesch.org",20,"DAM");
        Estudiante estudiante2 = new Estudiante(2L,"Saul","Guevara","Sguevarap@iesch.org",43,"DAW");
        Estudiante estudiante3 = new Estudiante(1L,"Paula","Camacho","pcamachoc@iesch.org",30,"ASIR");

        estudiantes.put(estudiante1.getId(),estudiante1);
        estudiantes.put(estudiante2.getId(),estudiante2);
        estudiantes.put(estudiante3.getId(),estudiante3);

        return estudiantes;
    }

}
