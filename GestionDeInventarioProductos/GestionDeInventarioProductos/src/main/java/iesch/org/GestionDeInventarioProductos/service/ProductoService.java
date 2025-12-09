package iesch.org.GestionDeInventarioProductos.service;

import iesch.org.GestionDeInventarioProductos.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class ProductoService {

    @Autowired
    Map<Long, Product> productos;



    public Product getPorId(Long id){

        Product product = productos.get(id);

        return product;
    }

    public void postProducto(Product product){

        Long maxKey = Collections.max(productos.keySet());
        product.setId(maxKey+1);
        productos.put(maxKey+1,product);
    }

    public Product updateProductoPorId(Product product ,Long id){
        Product producTMP =productos.get(id);

        if (producTMP==null){
            return null;
        }else {
            product.setId(id);
            productos.put(id,product);
            return product;
        }
    }
    public Product deleteProductoPorId(Long id) {
        Product producTMP = productos.get(id);

        if (producTMP==null){
            return null;
        }else {
            productos.remove(id);
            return producTMP;
        }
    }

}
