public class Prueba {



    public static void main(String[] args) {
        Contenedor<String> stringContenedor= new Contenedor<>("Hola Mundo");
        Contenedor<Integer> integerContenedor= new Contenedor<>(10);

        imprimirContenedor(stringContenedor);
        imprimirContenedor(integerContenedor);
        imprimirNumeroDoble(integerContenedor);
        imprimirConMultiplicador(integerContenedor, 5);

    }

    private static void imprimirConMultiplicador(Contenedor<Integer> numero, int multiplicador) {
        System.out.println(numero.getObjeto().intValue() *multiplicador);
    }

    private static void imprimirNumeroDoble(Contenedor<Integer> numero) {
        System.out.println(numero.getObjeto().doubleValue() *2 );
    }

    public static void imprimirContenedor(Contenedor<?> contenedor){
        System.out.println(contenedor.getObjeto());
    }
}
class Contenedor<T>{
    private T objeto;

    public Contenedor() {
    }

    public Contenedor(T objeto) {
        this.objeto = objeto;
    }

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }
}
