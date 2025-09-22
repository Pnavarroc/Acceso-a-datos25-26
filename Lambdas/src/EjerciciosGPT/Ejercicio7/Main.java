package EjerciciosGPT.Ejercicio7;

import java.util.List;

//7. Mini-calculadora (otra versión)
//
//Reutiliza tu interfaz Calculator.
//Crea un array/lista de operaciones (suma, resta, multiplicación, división) y recórrela con un forEach, probando cada una con dos números.
public class Main {
    public static void main(String[] args) {
        Calculadora sum= (a,b)->a+b;
        Calculadora rest= (a,b)->a-b;
        Calculadora multi= (a,b)->a*b;
        Calculadora div= (a,b)->{
         if (b==0){
             System.out.println("No se puede dividir entre 0");
             return 0;
         }return a/b;
        };
        List<Calculadora> operaciones = List.of(sum,rest,multi,div);

        int a=10,b=5;

        operaciones.forEach(operacion-> System.out.println("Resultado: "+operacion.calcular(a,b)));

    }
}
