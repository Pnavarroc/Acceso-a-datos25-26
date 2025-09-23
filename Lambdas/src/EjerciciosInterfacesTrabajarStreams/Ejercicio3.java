package EjerciciosInterfacesTrabajarStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*3) Transformar una lista de números: Crea una lista de números enteros.
 Utiliza una “Function” para transformar cada número en la lista a su cubo.*/
public class Ejercicio3 {
    public static void main(String[] args) {
        List<Integer> lista= new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
        Function<Integer,Integer> cubo = numero-> numero*numero*numero;

        List<Integer> cubos = lista.stream().map(cubo).toList();
        System.out.println(cubos);

    }
}
