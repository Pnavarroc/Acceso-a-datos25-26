package EjerciciosGPT;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//2. Nombres únicos y ordenados
//
//Crea una lista con nombres (algunos repetidos).
//
//Usa un Stream con distinct() para quedarte solo con los nombres únicos.
//
//Ordénalos por orden alfabético con un Comparator.
//
//Imprime el resultado.
public class Ejercicio9 {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>(List.of("Pablo","Paul","Diego","Javier","Pablo","Saul","Jorge","Diego"));

        List<String> sinDuplicadosOrdenados= nombres.stream().distinct().sorted(Comparator.naturalOrder()).toList();
        System.out.println(sinDuplicadosOrdenados);
    }
}
