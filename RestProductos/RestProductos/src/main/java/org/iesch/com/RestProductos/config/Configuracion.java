package org.iesch.com.RestProductos.config;

import org.iesch.com.RestProductos.modelo.Product;
import org.iesch.com.RestProductos.modelo.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class Configuracion {
    @Bean
    public Map<Long,Product> inicializa(){
        Map<Long,Product> productos = new HashMap();
        productos.put(1L,Product.builder().id(1).nombre("Fairy").price(5.25).descripcion("Limpia con una gota 100 platos").category("Limpieza").stock(12).build());
        productos.put(2L,Product.builder().id(2).nombre("Calgonit").price(15.25).descripcion("Lavavajillas").category("Limpieza").stock(24).build());
        productos.put(3L,Product.builder().id(3).nombre("Pan").price(1).descripcion("Pal bocata").category("Alimentación").stock(50).build());
        productos.put(4L,Product.builder().id(4).nombre("Champu").price(4.80).descripcion("Limpia con una gota todo tu cuerpo").category("Aseo personal").stock(23).build());
        productos.put(5L,Product.builder().id(5).nombre("Yogurt").price(2.10).descripcion("Yogurt con pepitas de chocolate").category("Alimentación").stock(40).build());

        return productos;
    }


    @Bean
    public Map<Long, Usuario> initUsuarios(){
        Map<Long,Usuario> usuarios = new HashMap();
        usuarios.put(1L, Usuario.builder().nombre("Pablo").apellidos("Navarro").direccion("Mi casa").password("Yoquemese12#").build());

        return usuarios;
    }

}
