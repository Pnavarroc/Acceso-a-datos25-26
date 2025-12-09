package iesch.org.GestionDeInventarioProductos.controler;

import iesch.org.GestionDeInventarioProductos.model.Product;
import iesch.org.GestionDeInventarioProductos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("/producto")
public class ProductControler {

    @Autowired
    ProductoService productoService;

    @Autowired
    Map<Long,Product> productos;

    @GetMapping
    public ResponseEntity<?> getTodos(){

        if (productos.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(productos);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPorId(@PathVariable Long id){

        Product product = productoService.getPorId(id);

        if (product==null){
            return ResponseEntity.notFound().build();
        }else
            return ResponseEntity.ok(product);

    }

    @PostMapping
    public ResponseEntity<?> postProducto(@RequestBody Product product){

        productoService.postProducto(product);
        URI location = URI.create("/producto/" + product.getId());
        return ResponseEntity.created(location).body(product);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductoPorId(@RequestBody Product product , @PathVariable Long id){

        Product producTmp = productoService.updateProductoPorId(product,id);

        if (producTmp==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(producTmp);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductoPorId(@PathVariable Long id){

        Product product = productoService.deleteProductoPorId(id);

        if (product==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(product);
        }
    }
}
