package iesch.org.CrudBasico.controler;

import iesch.org.CrudBasico.model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaControler {

    @GetMapping
    public List<Persona> getPersonas(){
        return List.of(
                new Persona(1, "Pablo", 20),
                new Persona(2, "Marta", 20),
                new Persona(3, "Luis", 20)
        );
    }
}
