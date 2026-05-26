package com.example.Biblio.repository;

import com.example.Biblio.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long>
{
/*Buscar socios por ciudad.
Buscar socios mayores de una edad.
Buscar socios cuyo nombre contenga un texto.*/
    /* private Long id;
    private String nombre;
    private String email;
    private String ciudad;
    private Integer edad;
*/

    public List<Socio> findByCiudad(String ciudad);

    public List<Socio> findByEdadGreaterThan(Integer mayoriaEdad);

    public List<Socio> findByNombreContaining(String texto);
}
