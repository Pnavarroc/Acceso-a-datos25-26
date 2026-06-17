package org.example.ejDia2.biblioteca;

public class Libro
{
    private String titulo;
    private String genero;
    private int paginas;
    private double precio;

    public Libro() {
    }

    public Libro(double precio, int paginas, String genero, String titulo) {
        this.precio = precio;
        this.paginas = paginas;
        this.genero = genero;
        this.titulo = titulo;
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

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", paginas=" + paginas +
                ", precio=" + precio +
                '}';
    }
}
