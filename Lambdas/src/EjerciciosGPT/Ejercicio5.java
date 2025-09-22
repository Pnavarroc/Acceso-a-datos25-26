package EjerciciosGPT;

import java.util.ArrayList;
import java.util.List;

//5. Buscar un nombre
//
//Crea una lista de nombres (["Ana","Pedro","Luis","Andrés"]).
//Usa removeIf para eliminar todos los que no empiecen por "A".
//Debería quedar [Ana, Andrés].
public class Ejercicio5 {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>(List.of("Ana","Pedro","Luis","Andrés"));
        nombres.removeIf(nombre->!nombre.startsWith("A"));
        System.out.println(nombres);

    }
}
