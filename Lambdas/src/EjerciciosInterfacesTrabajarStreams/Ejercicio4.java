package EjerciciosInterfacesTrabajarStreams;

import java.util.Random;
import java.util.function.Supplier;

/*4) Generar una secuencia de números aleatorios: Utiliza un “Supplier”
para generar e imprimir una secuencia de diez números aleatorios.*/
public class Ejercicio4 {
    public static void main(String[] args) {
        Supplier<Integer> aleatorios = ()->new Random().nextInt(10);

        for (int i = 0; i <10 ; i++) {
            System.out.println(aleatorios.get());
        }
    }
}
