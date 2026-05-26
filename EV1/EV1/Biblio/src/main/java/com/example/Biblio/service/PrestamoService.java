package com.example.Biblio.service;

import com.example.Biblio.model.Libro;
import com.example.Biblio.model.Prestamo;
import com.example.Biblio.model.PrestamoDTO;
import com.example.Biblio.model.Socio;
import com.example.Biblio.repository.LibroRepository;
import com.example.Biblio.repository.PrestamoRepository;
import com.example.Biblio.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrestamoService
{
    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private LibroRepository libroRepository;

    public List<PrestamoDTO> getAllPrestamos()
    {
        List<Prestamo> prestamos = prestamoRepository.findAll();

        return getPrestamosDTO(prestamos);
    }

    public List<PrestamoDTO> getPrestamosBySocio(Long idSocio)
    {
        List<Prestamo> prestamosPorSocio = prestamoRepository.findBySocioId(idSocio);

        return getPrestamosDTO(prestamosPorSocio);
    }


     public List<PrestamoDTO> getPrestamosNoDevueltos()
     {
         List<Prestamo> prestamosNoDevueltos = prestamoRepository.findByDevueltoFalse();

         return getPrestamosDTO(prestamosNoDevueltos);
     }


    public List<PrestamoDTO> getPrestamosDevueltos()
    {
        List<Prestamo> prestamosDevueltos = prestamoRepository.findByDevueltoTrue();

        return getPrestamosDTO(prestamosDevueltos);
    }

    public List<PrestamoDTO> getPrestamosByGeneroLibro(String genero)
    {
        List<Prestamo> prestamos = prestamoRepository.findByLibroGenero(genero);

        return getPrestamosDTO(prestamos);
    }

    public List<PrestamoDTO> getPrestamosByCiudadSocio(String ciudad)
    {
        List<Prestamo> prestamos = prestamoRepository.findBySocioCiudad(ciudad);
        return getPrestamosDTO(prestamos);
    }


    public Prestamo crearPrestamo(Long idSocio, Long idLibro, Prestamo prestamo)
    {
        Socio socio = socioRepository.findById(idSocio).orElseThrow(()-> new RuntimeException("Este id de socio no existe"));

        Libro libro = libroRepository.findById(idLibro).orElseThrow(()-> new RuntimeException("Este id de libro no existe"));

        prestamo.setSocio(socio);
        prestamo.setLibro(libro);

        return prestamoRepository.save(prestamo);

    }

    public Prestamo marcarComoDevuelto(Long idPrestamo)
    {
        Prestamo prestamo = prestamoRepository.findById(idPrestamo).orElseThrow(()-> new RuntimeException("Este id de prestamo no existe"));

        prestamo.setDevuelto(true);


        return prestamoRepository.save(prestamo);
    }


    private List<PrestamoDTO> getPrestamosDTO(List<Prestamo> prestamos)
    {
        List<PrestamoDTO> prestamosDTO = new ArrayList<>();

        for (Prestamo prestamo: prestamos)
        {
            prestamosDTO.add(new PrestamoDTO( prestamo.getPrestamo_id(),
                    prestamo.getSocio().getNombre(),
                    prestamo.getSocio().getEmail(),
                    prestamo.getSocio().getCiudad(),
                    prestamo.getLibro().getTitulo(),
                    prestamo.getLibro().getAutor(),
                    prestamo.getLibro().getGenero(),
                    prestamo.getFechaPrestamo(),
                    prestamo.getFechaDevolucion(),
                    prestamo.getDevuelto()));
        }
        return prestamosDTO;
    }
}
