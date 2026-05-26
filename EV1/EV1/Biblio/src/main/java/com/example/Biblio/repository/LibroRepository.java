package com.example.Biblio.repository;

import com.example.Biblio.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>
{

    /*Buscar libros por género.
Buscar libros por autor.
Buscar libros con más de X páginas.
Buscar libros con precio menor o igual a X
 private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private Integer paginas;
    private Double precio;
*/

    public List<Libro> findByGenero(String genero);

    public List<Libro> findByAutor(String nombreAutor);

    public List<Libro> findByPaginasGreaterThan(Integer paginas);

    public List<Libro> findByPrecioGreaterThanEqual(Double precio);


}
