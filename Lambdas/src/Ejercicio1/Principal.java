package Ejercicio1;
/*Ejercicios:
1. Calculadora con funciones lambda: Crea una interfaz funcional “Calculator” con un
método “calculate()”. Este método debe tomar dos números enteros y devolver un
número entero. Luego, en tu método “main()”, crea varias instancias de “Calculator”
utilizando funciones lambda para implementar operaciones como suma, resta,
multiplicación y división. Finalmente, prueba tus calculadoras con algunos números.*/
public class Principal {
    public static void main(String[] args) {
        Calculator suma=(a,b)->a + b;
        Calculator resta=(a,b)->a - b;
        Calculator multiplicacion=(a,b)->a * b;
        Calculator division=(a,b)->{
            if (b==0){
                System.out.println("No se puede dividir por 0");
            return 0;}
            return a/b;
        };

        System.out.println("La suma de 12 + 4 es: "+suma.calculate(12,4));
        System.out.println("La resta de 12 - 4 es: "+resta.calculate(12,4));
        System.out.println("La multiplicación de 12 * 4 es: "+multiplicacion.calculate(12,4));
        System.out.println("La division de 12 / 4 es: "+division.calculate(12,4));

    }
}
