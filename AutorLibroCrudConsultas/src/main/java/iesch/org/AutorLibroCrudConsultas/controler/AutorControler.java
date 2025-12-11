package iesch.org.AutorLibroCrudConsultas.controler;

import iesch.org.AutorLibroCrudConsultas.model.Autor;
import iesch.org.AutorLibroCrudConsultas.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorControler {

    @Autowired
    AutorService autorService;



    @GetMapping
    public ResponseEntity<?> mostrarAutores(){
        List<Autor> autors = autorService.mostrarAutores();

        if (autors.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(autors);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarAutor(@RequestBody Autor autor){
        Autor autorGuardado = autorService.guardarAutor(autor);

        if (autorGuardado==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(autorGuardado);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarAutoresPorId(@PathVariable Long id){
        Autor autor = autorService.mostrarAutorPorId(id);

        if (autor==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(autor);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAutor(@PathVariable Long id, @RequestBody Autor nuevo){
        Autor autorExistente = autorService.mostrarAutorPorId(id);

        if (autorExistente==null){
            return ResponseEntity.notFound().build();
        }else{
            autorExistente.setNombre(nuevo.getNombre());
            autorExistente.setPais(nuevo.getPais());
            return ResponseEntity.ok(autorExistente);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarAutor(@PathVariable Long id){
        Autor autorBorrar = autorService.borrarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
