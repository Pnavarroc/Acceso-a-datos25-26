package EjerciciosInterfacesTrabajarStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/*6) Aplicar una operación a cada elemento de una lista: Crea una lista de números
enteros. Utiliza un “Consumer” para aplicar una operación a cada número en la
lista (por ejemplo, multiplicar cada número por 2).*/
public class Ejercicio6 {
    public static void main(String[] args) {
        List<Integer> lista= new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
        Consumer<Integer> porDos = numero-> System.out.println(numero*2);
        lista.forEach(porDos);

    }
}
