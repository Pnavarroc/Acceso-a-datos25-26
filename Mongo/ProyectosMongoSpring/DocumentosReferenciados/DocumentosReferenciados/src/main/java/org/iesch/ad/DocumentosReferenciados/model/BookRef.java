package org.iesch.ad.DocumentosReferenciados.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "libros_ref")
public class BookRef {

    @Id
    private String id;

    private String titulo;
    private Integer anioPublicacion;
    private Double precio;
    private Integer numeroPaginas;
    private String editorial;

    @DBRef
    private List<AutoresRef> autores;

    private List<String> categorias;


    public BookRef(String titulo, Integer anioPublicacion, Double precio, Integer numeroPaginas, String editorial, List<AutoresRef> autores, List<String> categorias) {
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.precio = precio;
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
        this.autores = autores;
        this.categorias = categorias;
    }
}
