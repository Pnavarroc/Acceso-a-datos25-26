package org.iesch.com.RestProductos.modelo;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Product {
    long id;
    String nombre;
    double price;
    String descripcion;
    String category;
    int stock;

    /*
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }*/
}
