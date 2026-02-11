package iesch.org.BibliotecaEmbebida.controller;

import iesch.org.BibliotecaEmbebida.model.Libro;
import iesch.org.BibliotecaEmbebida.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    LibroService libroService;

    //CRUD

    @GetMapping
    public ResponseEntity<List<Libro>> getAll(){
        return ResponseEntity.ok(libroService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getOne(@PathVariable String id){
        return ResponseEntity.ok(libroService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<Libro> getOne(@RequestBody Libro libro){
        return ResponseEntity.ok(libroService.addOne(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateOne(@PathVariable String id,@RequestBody Libro libro){
        return ResponseEntity.ok(libroService.updateOne(id, libro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable String id){
        return ResponseEntity.ok(libroService.deleteOne(id));
    }

    /*🔹 NIVEL 1 – Derivadas básicas (calentamiento)
1️⃣ Buscar libros con precio mayor que X

👉 Método derivado

2️⃣ Buscar libros con precio entre X e Y
3️⃣ Buscar libros publicados después de un año dado
4️⃣ Buscar libros cuya editorial sea exactamente X
5️⃣ Buscar libros cuya categoría contenga "Programación"

(Ojo: array de strings)

🔹 NIVEL 2 – Embebidos y combinaciones
6️⃣ Buscar libros cuyo autor tenga nombre X

(Embebido)

7️⃣ Buscar libros cuyo autor sea de nacionalidad X
8️⃣ Buscar libros con más de 400 páginas y precio menor a 30€

(Combinación AND)

9️⃣ Buscar libros cuya editorial sea X o Y

(OR)

🔟 Buscar libros que NO pertenezcan a la categoría "Ficción"

(Negación)

🔥 NIVEL 3 – Más examen

Aquí ya vas a necesitar @Query.

11️⃣ Buscar libros que tengan más de un autor

(No es derivado directo fácil)

12️⃣ Buscar libros que tengan EXACTAMENTE 2 categorías
13️⃣ Buscar libros cuyo autor se llame "George Orwell" Y sea de nacionalidad "Reino Unido"

(Ojo con embebidos combinados)

14️⃣ Buscar libros cuyo precio sea mayor que el promedio general

(Esta es interesante. Necesita aggregate o lógica previa.)

15️⃣ Obtener solo:

título

nombre de autores

precio

(Sin devolver el resto de campos → proyección en Spring)*/
    //Consultas

    //Buscar libros con precio mayor que X
    @GetMapping("/search/precio")
    public ResponseEntity<?> librosPorPrecio(@RequestParam Double precio){
        return ResponseEntity.ok(libroService.librosPorPrecio(precio));
    }

    //2️⃣ Buscar libros con precio entre X e Y

    @GetMapping("/search/entre-precio")
    public ResponseEntity<?> librosPorEntreRangoPrecio(@RequestParam Double preciomin,@RequestParam Double preciomax){
        return ResponseEntity.ok(libroService.librosPorEntreRangoPrecio(preciomin, preciomax));
    }

    //Buscar libros cuya categoría contenga "Programación"
    @GetMapping("/search/categoria")
    public ResponseEntity<?> librosPorCategoria(@RequestParam String categoria){
        return ResponseEntity.ok(libroService.librosPorCategoria(categoria));
    }

    //Buscar libros cuyo autor tenga nombre X
    @GetMapping("/search/nombreAutor")
    public ResponseEntity<?> librosPorNombreAutor(@RequestParam String nombreAutor){
        return ResponseEntity.ok(libroService.librosPorNombreAutor(nombreAutor));
    }

    //8️⃣ Buscar libros con más de 400 páginas y precio menor a 30€
    @GetMapping("/search/paginas/precio")
    public ResponseEntity<?> librosPorNumPaginasYPrecio(@RequestParam Integer paginas,@RequestParam Double precio){
        return ResponseEntity.ok(libroService.librosPorNumPaginasYPrecio(paginas,precio));
    }

    //🔟 Buscar libros que NO pertenezcan a la categoría "Ficción"
    @GetMapping("/search/categoria-no")
    public ResponseEntity<?> librosporcategoriaNegada(@RequestParam String categoria){
        return ResponseEntity.ok(libroService.librosporcategoriaNegada(categoria));
    }
    //11️⃣ Buscar libros que tengan más de un autor

    @GetMapping("/search")
    public ResponseEntity<?> librosConMasDeUnAutor(){
        return ResponseEntity.ok(libroService.librosConmasAutores());
    }
   /*
13️⃣ Buscar libros cuyo autor se llame "George Orwell" Y sea de nacionalidad "Reino Unido"
    */
   @GetMapping("/search/nombre/nacionalidad")
   public ResponseEntity<?> librosPorNombreYNacionalidad(@RequestParam String nombre ,@RequestParam String nacionalidad){
       return ResponseEntity.ok(libroService.librosPorNombreYNacionalidad(nombre, nacionalidad));
   }
}
