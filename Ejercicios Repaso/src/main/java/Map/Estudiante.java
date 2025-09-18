package Map;
/*Ej3. Dada una lista de estudiantes (donde cada estudiante es un objeto con
propiedades como nombre, edad, grado, etc.), escribir una función que devuelva
un Map donde las claves son los nombres de los estudiantes y los valores son los
objetos de los estudiantes.*/
public class Estudiante {
    private String nombre;
    private int edad;
    private String grado;

    public Estudiante() {
    }

    public Estudiante(String nombre, int edad, String grado) {
        this.nombre = nombre;
        this.edad = edad;
        this.grado = grado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", grado='" + grado + '\'' +
                '}';
    }
}
