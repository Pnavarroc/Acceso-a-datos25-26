package org.example;

public class Libro
{

    private String titulo;
    private String genero;
    private Integer paginas;
    private Double precio;
    private Autor autor;

    public Libro() {
    }

    public Libro(String titulo, String genero, Integer paginas, Double precio, Autor autor) {
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.precio = precio;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", paginas=" + paginas +
                ", precio=" + precio +
                ", autor=" + autor +
                '}';
    }
}
