package org.example.Bloque1Hora;

import java.util.Scanner;

public class Ejercicio1 {
    //🧠 BLOQUE A — Lógica básica bien hecha (calentamiento)
    //Objetivo: pensar condiciones y recorrer datos sin liarla.
    //1️⃣ Número equilibrado
    //Un número es equilibrado si la suma de sus dígitos pares es igual a la suma de los impares.
    //Ejemplo:
    //n = 1234 → pares = 2+4=6 | impares = 1+3=4 ❌
    //n = 121 → pares=2 | impares=1+1=2 ✅
    //📌 Pistas:
    //while + % 10
    //cuidado con negativos
    public static void main(String[] args) {
        Integer numero =1234;

        int sumaPares =0;
        int sumaImpares=0;

        while (numero>0){
            int digito = numero%10;
            System.out.println(digito);

            if (digito % 2 == 0) {
                sumaPares += digito;
            } else {
                sumaImpares += digito;
            }
            numero/=10;

        }

    }
}
