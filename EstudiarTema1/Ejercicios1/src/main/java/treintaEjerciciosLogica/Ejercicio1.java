package treintaEjerciciosLogica;

import treintaEjerciciosLogica.model.Persona;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio1 {

    public static void main(String[] args) {
        /*. Filtra los números pares de una lista.
List<Integer> nums = List.of(3,10,5,20,7,2);
2. Convierte todos los números de la lista a su cuadrado.
3. Dada una lista de strings, conviértelas a mayúsculas.
4. Cuenta cuántos elementos tienen más de 3 letras.
List<String> palabras = List.of("sol","casa","perro","uva");

5. Obtén una lista con los números mayores que 10.
6. Ordena una lista de enteros de menor a mayor usando stream.
7. Ordena una lista de strings por orden alfabético.
8. Dada una lista de enteros, quédate solo con los impares y ordénalos.
9. Cuenta cuántas veces aparece un número concreto en una lista.
10. Multiplica todos los números por 2 y ordénalos al revés.*/

        //1 Solo sacar de esta lista los pares.
        System.out.println("======SACAR PARES DE UNA LISTA =========");
        List<Integer> nums = List.of(3,10,5,20,7,2);
        System.out.println("Lista original: "+nums);
        List<Integer> pares = nums.stream().filter(n->n%2==0).toList();
        System.out.println("Solo los pares");
        System.out.println(pares);

        //2. Convierte todos los números de la lista a su cuadrado.

        List<Integer> cuadrados = nums.stream().map(n-> (int) Math.pow(n,2)).toList();
        System.out.println("Sus cuadrados: "+cuadrados);



        //3. Dada una lista de strings, conviértelas a mayúsculas.
        System.out.println("======SACAR LAS CADENAS DE LA LISTA EN MAYUSCULAS =========");
        List<String> palabras = List.of("Hola", "Adios","PEpe", "FeernadDo", "Auxilio", "Me","Desmayo");
        System.out.println("Lista original: "+palabras);
        List<String> mayus = palabras.stream().map(p->p.toUpperCase()).toList();
        System.out.println("La lista en mayusculas: "+mayus);

        //4. Cuenta cuántos elementos tienen más de 3 letras.
        System.out.println("======SACAR LAS CADENAS MAYORES DE 3 LETRAS =========");
        List<String> palabras2 = List.of("sol","casa","perro","uva");
        System.out.println("Lista original: "+palabras2);
        List<String> mayoresDe3 = palabras2.stream().filter(p->p.length()>3).toList();
        System.out.println("Las que tienen mas de 3:"+mayoresDe3);

        //5. Obtén una lista con los números mayores que 10.
            System.out.println("======SACAR LOS NUMEROS MAYORES DE 10 =========");
        List<Integer> nums2 = List.of(33,104,5,20,7,222);
        System.out.println("lista original: "+nums2);
        List<Integer> mayoresDe10 = nums2.stream().filter(n->n>10).toList();
        System.out.println("Las que tienen mas de 10:"+mayoresDe10);

        //6. Ordena una lista de enteros de menor a mayor usando stream.
        System.out.println("======ORDENAR LISTA DE MENOR A MAYOR =========");
        System.out.println("lista original: "+nums2);
        List<Integer> listaOrdenadaMenorAMayor = nums2.stream().sorted().toList();
        System.out.println("Lista ordenada: "+listaOrdenadaMenorAMayor);

        //7. Ordena una lista de strings por orden alfabético.
        System.out.println("======ORDENAR LISTA EN ORDEN ALFABETICO =========");
        System.out.println("Lista original: "+palabras);
        List<String> ordenAlfabetico = palabras.stream().sorted().toList();
        System.out.println("Lista ordenada: "+ordenAlfabetico);

        //8. Dada una lista de enteros, quédate solo con los impares y ordénalos.
        System.out.println("======SACAR SOLO IMPARES Y ORDENADOS =========");
        List<Integer> nums3 = List.of(3,10,5,20,7,2,23,34,56,678,23,3,5,6,78,8,435,845,456,23,45456,46);
        System.out.println("Lista original: "+nums3);
        List<Integer> ordenacionImpares = nums3.stream().filter(n->n%2!=0).sorted().toList();
        System.out.println("Lista con impares y ordenada: "+ordenacionImpares);

        //9. Cuenta cuántas veces aparece un número concreto en una lista.
        System.out.println("Contar cuantas veces aparece el numero 23 en la lista");
        Long contar23 = nums3.stream().filter(n->n.equals(23)).count();
        System.out.println("El numero 23 aparece: "+contar23);

        System.out.println("===========10. Multiplica todos los números por 2 y ordénalos al revés.=======================");
        List<Integer> por10Inversos = nums3.stream().map(n->n*10).sorted(Comparator.reverseOrder()).toList();
        System.out.println("La lista modificada es: "+por10Inversos);

        /*11. Suma todos los números con reduce.
12. Obtén el número mayor con stream + max.
13. Obtén el menor con stream + min.
14. Convierte una lista en una frase separada por comas.
15. Ordena una lista de Persona por edad.
16. Ordena la misma lista por nombre.
17. Filtra las personas mayores de 18.
18. Persona más joven con min.
19. Devuelve la primera palabra que empiece por “A”.
20. Crea un Predicate que indique si una palabra tiene más de 5 letras y aplícalo.*/

        //11. Suma todos los números con reduce.
        System.out.println("========11. Suma todos los números con reduce.========");

        int sumartodo = nums3.stream().reduce(0,(x,y)->x+y);
        System.out.println(sumartodo);

        System.out.println("El numero mayor de la lista");

        Optional<Integer> mayor = nums3.stream().max(Comparator.naturalOrder());
        System.out.println(mayor);

        //13. Obtén el menor con stream + min.
        System.out.println("El menor de la lista");
        Optional<Integer> menor = nums3.stream().min(Comparator.naturalOrder());
        System.out.println(menor);

        //14. Convierte una lista en una frase separada por comas.
        System.out.println("Convertir una lista en una frase");
        List<String> palabras4 = List.of("Hola", "Adios","PEpe", "FeernadDo", "Auxilio", "Me","Desmayo");
        System.out.println("Lista inicial: "+palabras4);
        String frase = palabras4.stream().collect(Collectors.joining(", "));
        System.out.println(frase);

        System.out.println("15. Ordena una lista de Persona por edad.");

        List<Persona> personas = List.of(
                new Persona("Pablo",20,"Teruel"),
                new Persona("Raul",35,"Cádiz"),
                new Persona("Ivan",44,"Segorbe"),
                new Persona("Mario",18,"Teruel"),
                new Persona("María",21,"Teruel"),
                new Persona("Julia",18,"Teruel")
        );
        System.out.println(personas);

        List<Persona> personasPorEdad = personas.stream().sorted(Comparator.comparingInt(Persona::getEdad)).toList();
        System.out.println(personasPorEdad);

        System.out.println("16. Ordena la misma lista por nombre.");

        personasPorEdad = personasPorEdad.stream().sorted(Comparator.comparing(Persona::getNombre)).toList();
        System.out.println(personasPorEdad);

        System.out.println("17. Filtra las personas mayores de 18.");
        personasPorEdad = personasPorEdad.stream().filter(p->p.getEdad()>18).toList();
        System.out.println(personasPorEdad);

        System.out.println("La persona mas joven");
        Optional<Persona> persona = personas.stream().min(Comparator.comparingInt(Persona::getEdad));
        System.out.println(persona);

        System.out.println("19. Devuelve la primera palabra que empiece por “A”.");
        Optional<String> palabra = palabras4.stream().filter(p->p.startsWith("A")||p.startsWith("a")).
                findFirst();
        System.out.println(palabra);
        System.out.println("20. Crea un Predicate que indique si una palabra tiene más de 5 letras y aplícalo.*/");

        palabras4.stream().map(p->{
            if (p.length()>5){
                return p+" Tiene mas de 5 letras";
            }else return p;
        }).forEach(System.out::println);

        /*🔥 NIVEL 3 — AVANZADO (ejercicios 21–30)
Objetivo: groupingBy, partitioningBy, flatMap, collectors, reduce complejo, pipelines largos, genéricos.
21. Agrupa una lista de palabras por su primera letra.
Entrada:
List<String> palabras = List.of("casa","carro","sol","silla","perro");
Salida esperada (aprox):
c → [casa, carro]
s → [sol, silla]
p → [perro]
22. Agrupa personas por edad (map de edad → lista de personas).
23. Particiona una lista de números en pares e impares usando partitioningBy.
24. Convierte una lista de oraciones en una lista de palabras usando flatMap.
Entrada:
List<String> frases = List.of("hola mundo", "adios mundo");
Salida:
["hola","mundo","adios","mundo"]
25. Obtén el promedio de una lista de números usando averagingDouble.
26. Realiza una búsqueda case-insensitive de palabras que contengan la letra “a”, elimínalas repetidas y ordénalas.
27. Usa reducing() para obtener el producto de todos los números de una lista.
Ejemplo: [2,3,4] → 24.
28. Dada una lista de Persona, obtén un Map<String,Integer> donde la clave sea el nombre y el valor la edad.
29. Dada una lista de listas de números, aplánala en una sola lista ordenada.
Entrada:
List<List<Integer>> listas = List.of(
    List.of(3,1,2),
    List.of(10,5),
    List.of(8)
);
Salida:
[1,2,3,5,8,10]
30. EJERCICIO EXPERTO — Pipeline completo
Dada esta lista de Persona:
List<Persona> personas = List.of(
    new Persona("Ana", 30),
    new Persona("Luis", 20),
    new Persona("Marta", 25),
    new Persona("Juan", 20),
    new Persona("Ana", 18)
);
👉 haz lo siguiente en UNA sola cadena stream:
Quédate solo con personas mayores de 20
Ordénalas por edad descendente
Quédate solo con sus nombres
Elimina duplicados
Devuelve la lista final
Salida esperada:
[Ana, Marta]*/

        //21. Agrupa una lista de palabras por su primera letra.
        //Entrada:
        //List<String> palabras = List.of("casa","carro","sol","silla","perro");
        //Salida esperada (aprox):
        //c → [casa, carro]
        //s → [sol, silla]
        //p → [perro]

        System.out.println("21. Agrupa una lista de palabras por su primera letra.");

        List<String> palabras5 = List.of("casa","carro","sol","silla","perro");

        Map<Character,List<String>> resultado = palabras5.stream().collect(Collectors.groupingBy(p->p.charAt(0)));
        System.out.println(resultado);

        System.out.println("22. Agrupa personas por edad (map de edad → lista de personas).");

        Map<Integer,List<Persona>> personasMap = personas.stream().collect(Collectors.groupingBy(p->p.getEdad()));

        System.out.println(personasMap);

        System.out.println("23. Particiona una lista de números en pares e impares usando partitioningBy.");
        List<Integer> numeros = List.of(3, 10, 5, 20, 7, 2);

        Map<Boolean,List<Integer>> numerosMap = numeros.stream().collect(Collectors.partitioningBy(p->p%2==0));
        System.out.println(numerosMap);

        System.out.println("24. Convierte una lista de oraciones en una lista de palabras usando flatMap.");
        List<String> frases = List.of("hola mundo", "adios mundo");

        List<String> listaFrases =frases.stream().flatMap(f->Arrays.stream(f.split(" "))).toList();
        System.out.println(listaFrases);


        System.out.println("25. Obtén el promedio de una lista de números usando averagingDouble.");

        double media = numeros.stream().collect(Collectors.averagingDouble(x->x));
        System.out.println(media);

        System.out.println("26. Realiza una búsqueda case-insensitive de palabras que contengan la letra “a”, elimínalas repetidas y ordénalas.");
        List<String> palabras6 = List.of("Casa", "carro", "sol", "silla", "perro", "casa");

        List<String> result = palabras6.stream().map(p->p.toLowerCase()).
                filter(p->p.contains("a")).distinct().sorted().toList();

        System.out.println(result);

        System.out.println("27. Usa reducing() para obtener el producto de todos los números de una lista.\n" +
                "Ejemplo: [2,3,4] → 24.");

        List<Integer> ns = List.of(2,3,4);


        double res = ns.stream().reduce(1,(x,y)->x*y);
        System.out.println(res);

        System.out.println("28. Dada una lista de Persona, obtén un Map<String, Integer> donde la clave sea el nombre y el valor la edad.");

        List<Persona> personas2 = List.of(
                new Persona("Pablo", 20,""),
                new Persona("Raul", 35,""),
                new Persona("Ivan", 44,""),
                new Persona("Mario", 18,"")
        );

        Map<String,Integer> personasMap2= personas2.stream().collect(Collectors.toMap(
                p->p.getNombre(),
                p->p.getEdad()
                ));

        System.out.println(personasMap2);

        System.out.println("Dada una lista de listas de números, aplánala en una sola lista ordenada.");
        /*29. Dada una lista de listas de números, aplánala en una sola lista ordenada.
            Entrada:
            List<List<Integer>> listas = List.of(
                List.of(3,1,2),
                List.of(10,5),
                List.of(8)
            );
            Salida:
            [1,2,3,5,8,10]*/
        List<List<Integer>> listas = List.of(
                List.of(3,1,2),
                List.of(10,5),
                List.of(8)
        );

        List<Integer> lista = listas.stream().flatMap(l->l.stream()).sorted().toList();

        System.out.println(lista);

        System.out.println("30. EJERCICIO EXPERTO — Pipeline completo");

        List<Persona> personas5 = List.of(
                new Persona("Ana", 30,"Teruel"),
                new Persona("Luis", 20,"Teruel"),
                new Persona("Marta", 25,"Teruel"),
                new Persona("Juan", 20,"Teruel"),
                new Persona("Ana", 18,"Teruel")
        );

        //Quédate solo con personas mayores de 20
        //Ordénalas por edad descendente
        //Quédate solo con sus nombres
        //Elimina duplicados
        //Devuelve la lista final
        List<String> personasResultado= personas5.stream().
                filter(p->p.getEdad()>20).
                sorted(Comparator.comparingInt(Persona::getEdad))
                .map(p->p.getNombre())
                .distinct()
                .toList();

        System.out.println(personasResultado);



    }
}
