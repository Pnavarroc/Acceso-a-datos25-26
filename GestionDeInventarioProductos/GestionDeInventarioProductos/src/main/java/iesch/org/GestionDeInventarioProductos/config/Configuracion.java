package iesch.org.GestionDeInventarioProductos.config;

import iesch.org.GestionDeInventarioProductos.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Configuration
public class Configuracion {

    @Bean
    public Map<Long,Product> inicializa(){
        Map<Long,Product> productos = new HashMap();
        productos.put(1L,Product.builder().id(1).name("Fairy").price(5.25).description("Limpia con una gota 100 platos").category("Limpieza").stock(12).build());
        productos.put(2L,Product.builder().id(2).name("Calgonit").price(15.25).description("Lavavajillas").category("Limpieza").stock(24).build());
        productos.put(3L,Product.builder().id(3).name("Pan").price(1).description("Pal bocata").category("Alimentación").stock(50).build());
        productos.put(4L,Product.builder().id(4).name("Champu").price(4.80).description("Limpia con una gota todo tu cuerpo").category("Aseo personal").stock(23).build());
        productos.put(5L,Product.builder().id(5).name("Yogurt").price(2.10).description("Yogurt con pepitas de chocolate").category("Alimentación").stock(40).build());

        return productos;
    }



}
