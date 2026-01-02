package org.example.Bloque1Hora;

public class Ejercicio3 {
    public static void main(String[] args) {

        System.out.println(esCasiPalindromo("abca"));     // true
        System.out.println(esCasiPalindromo("racecar"));  // false
        System.out.println(esCasiPalindromo("abc"));      // false
        System.out.println(esCasiPalindromo("deeee"));    // true


    }

    static boolean esPalindromo(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static boolean esCasiPalindromo(String palabra){
        int i =0;
        int j = palabra.length()-1; // Esto me da la longitud de la palabra

        while (i<j){
            if (palabra.charAt(i)==palabra.charAt(j)){ // Si empezando por el principio y por el final es siempre igual entonces tenemos un palindromo

                j--;
                i++;
            }else {
                return esPalindromo(palabra,i+1,j) || esPalindromo(palabra,i,j-1);
            }
        }
        return false;
    }
}


//🔁 BLOQUE B — Arrays / Strings con mala leche
//
//Objetivo: detectar patrones, no solo recorrer.
//3️⃣ Palabra “casi” palíndroma
//Una palabra es casi palíndroma si quitando una letra puede ser palíndroma.
//"abca" → quitando 'b' → "aca" ✅
//"racecar" → ya es palíndroma ❌
//📌 Pistas:
//Dos punteros
//Permitir un solo fallo
//
//4️⃣ Subarray con suma máxima
//
//Dado un array de enteros (positivos y negativos):
//
//int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//
//
//Resultado:
//
//6 → subarray [4, -1, 2, 1]
//
//
//📌 Esto es clave para entrevistas
//
//Algoritmo de Kadane
//
//O versión lógica propia (pero eficiente)
//
//⚙️ BLOQUE C — Nivel DAM2 serio
//
//Objetivo: pensar como programador, no como alumno.
//
//5️⃣ Contar caracteres más repetidos
//
//Dada una frase:
//
//"programar en java"
//
//
//Resultado:
//
//a → 4
//
//
//📌 Condiciones:
//
//Ignorar espacios
//
//Mayúsculas y minúsculas cuentan igual
//
//Usa Map<Character, Integer>
//
//6️⃣ Validar secuencia de paréntesis
//
//Entrada:
//
//"(()())" → true
//"(())(" → false
//"(()(()))" → true
//
//
//📌 Pistas:
//
//Contador
//
//Nunca puede ser negativo
//
//Al final debe ser 0
//
//🧠 BONUS (solo si vas sobrado)
//
//Implementa cualquiera con Streams en lugar de bucles.
//
//📌 Mi consejo directo
//
//No intentes hacerlos todos perfectos.
//👉 Me interesa más cómo piensas que cuántos terminas.
//
//Si quieres:
//
//me pasas uno que te haya costado
//
//o me dices en cuál te has atascado
//y lo desmenuzamos como si fuera de examen.
//
//Vamos. Aprovecha esa hora 🔥