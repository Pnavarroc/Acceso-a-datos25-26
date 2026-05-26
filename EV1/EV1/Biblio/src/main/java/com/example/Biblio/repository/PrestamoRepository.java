package com.example.Biblio.repository;

import com.example.Biblio.model.Libro;
import com.example.Biblio.model.Prestamo;
import com.example.Biblio.model.Socio;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long>
{
/*Buscar préstamos de un socio por id.
Buscar préstamos de un libro por id.
Buscar préstamos no devueltos.
Buscar préstamos devueltos.
Buscar préstamos por género del libro.
Buscar préstamos por ciudad del socio.*/
    /*private Long prestamo_id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Boolean devuelto;
    @JoinColumn(name = "socio_id")
    private Socio socio;
    @JoinColumn(name = "libro_id")
    private Libro libro;*/

    public List<Prestamo> findBySocioId(Long id);

    public List<Prestamo> findByLibroId(Long id);

    public List<Prestamo> findByDevueltoFalse();

    public List<Prestamo> findByDevueltoTrue();

    public List<Prestamo> findByLibroGenero(String genero);

    public List<Prestamo> findBySocioCiudad(String ciudad);

}
