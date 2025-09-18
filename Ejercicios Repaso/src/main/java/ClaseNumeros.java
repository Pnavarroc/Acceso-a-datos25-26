import java.util.Arrays;
import java.util.List;

public class ClaseNumeros {
    public static void main(String[] args) {
        List<Integer> numeros= Arrays.asList(1,2,3,4,5,6,7,8,9,10);


        //List<Integer> pares = numeros.stream().filter(numero ->numero%2==0).toList();Esto es lo mismo que abajo, para sacar pares .
        List<Integer> pares = numeros.stream().filter(numero ->numero%2==0)
                .map(n->n*n).toList();//El tolist es necesario para meter los datos a una lista. En esta saca los pares y ademas los hace al cuadrado
        /*
        *for (Integer num : numeros){
            if (num%2==0){
                pares.add(num);
            }
        } */


        pares.forEach(System.out::println);//Esto es lo de abajo
        /*
        *for (Integer num: pares){
            System.out.println(num);
        } */

    }
}
