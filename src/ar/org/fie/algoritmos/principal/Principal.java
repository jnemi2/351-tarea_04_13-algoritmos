/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.org.fie.algoritmos.principal;

import ar.org.fie.algoritmos.components.Ejemplos;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author bauti
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        Agregar una Clase “Principal”, donde estará el método main, la asignación/entrada de datos,
        y la impresión por consola de los resultados.
        Criterio propio de cada alumno para probar y mostrar lo que se pide en forma
        prolija y ordenada (Poner numeración del ítem de ejercicio en la impresión por
        pantalla, usar comentarios de lo que esta realizando, etc.).
        */

        Ejemplos ejemplo = new Ejemplos();
        
        //1- Utilizar cada tipo de dato de JAVA (byte, long, float, etc), asignar valor e imprimirlo por consola.
        System.out.println("EJERCICIO 1\n");
        
        System.out.println("byte: el último dígito de 727 es " + ejemplo.ultimoDigito(727));
        System.out.println("float: la 3 elevado a -2 es " + (float) ejemplo.potencia(3, -2));
        System.out.println("double: la 3 elevado a -2 es " + ejemplo.potencia(3, -2));
        System.out.println("short: la suma gaussiana de 101 es " + (short) ejemplo.sumaGaussiana(101));
        System.out.println("int: la suma gaussiana de 500 es " + (int) ejemplo.sumaGaussiana(500));
        System.out.println("long: la suma gaussiana de 99999 es " + ejemplo.sumaGaussiana(99999));
        System.out.println("char y String: en 'Prueba de algoritmos' la 'e' aparece " + ejemplo.contarChar('e', "Prueba de algoritmos") + " veces");
        System.out.println("Con una probabilidad del 70% de ser verdadero, random resultó " + ejemplo.randBool((float)0.7));
        
        //2- Realizar operaciones de suma, resta, producto, división y resto entre números, y utilizar los Operadores unarios ++ -- !
        System.out.println("\n\nEJERCICIO 2\n");
        System.out.println(ejemplo.ejemploAritmetica());
        
        //3- Utilizar operadores Condicionales Relacionales Lógicos Igual a, Distinto de, Mayor o
        //   Mayor e Igual, Menor o Menor e Igual, el operador “Y”, el operador “O”, invente un
        //   ejemplo a su criterio.
        System.out.println("\n\nEJERCICIO 3\n");
        System.out.println(ejemplo.tablaVerdad());
        
        //4- Utilizar Estructura de control selectiva múltiple. Ejemplo a su criterio.
        System.out.println("\n\nEJERCICIO 4\n");
        System.out.println(ejemplo.calcularSueldo(52000, 9000));
        
        //5- Armar una función en java, que dado un numero recibido como parámetro, retorne el
        //   factorial del mismo (utilizando una estructura repetitiva). Usar esta función desde main
        //   para probarla.
        System.out.println("\n\nEJERCICIO 5\n");
        System.out.println(ejemplo.factorialRepetitivo(7));
        
        //6- Armar otra función en java, que dado un numero recibido como parámetro, retorne el
        //   factorial del mismo (utilizando recursividad). Usar esta función desde main para
        //   probarla.
        System.out.println("\n\nEjercicio 6\n");
        System.out.println(ejemplo.factorialRecursivo(7));
        
        //7- Escriba una función en java, que dados 3 parámetros, permita obtener las raíces de la
        //   ecuación de segundo grado (cuadrática) ax^2 + bx + c, y las escriba por pantalla.
        //   (numero imaginario representar con i). Usar esta función desde main para probarla
        System.out.println("\n\nEjercicio 7\n");
        System.out.println(ejemplo.raices(1,0,-1));
        System.out.println(ejemplo.raices(1,0,1));
        
        //8- Escriba una función en java, que dado un numero retorne true si es par o false si es
        //   impar (utilizar el operador resto). Usar esta función desde main para probarla.
        System.out.println("\n\nEjercicio 8\n");
        System.out.println(ejemplo.esPar(8));
        System.out.println(ejemplo.esPar(727));
        
        //9- Utilizar en un ejemplo una variable global dentro de una misma Clase, que es utilizada
        //   en distintos métodos.
        System.out.println("\n\nEjercicio 9\n");
        System.out.println(ejemplo.alcanceDeVariables(8));
        
        //10-Estructuras de datos con array estático (vector de 1 dimensión []). Armar un ejemplo de
        //   un vector de números enteros que simbolizan notas de alumnos, probar imprimiendo
        //   por consola los valores del vector, y el promedio de los números del vector.
        System.out.println("\n\nEjemplo 10\n");
        System.out.println(ejemplo.mostrarNotas());
        
        //11-Armar un ejemplo de una lista de nombres de alumnos (ArrayList), probar imprimiendo
        //   por consola los valores de la lista a través de un for, y la cantidad de alumnos.
        System.out.println("\n\nEjemplo 11\n");
        ejemplo.mostrarLista();
        
        //12-Mostrar con la lista anterior el uso de los métodos contains e indexOf. Arme ejemplos
        //   de búsqueda e imprima por consola.
        System.out.println("\n\nEjemplo 12\n");
        ejemplo.contenidoDeLista();
        
        //13-Anidamiento de estructura repetitiva, Armar un ejemplo en java, que, dada una lista de
        //   números recibida como parámetro, retorne la misma lista, pero ordenada de menor a
        //   mayor.
        System.out.println("\n\nEjemplo 13\n");
        ArrayList<Integer> lista = new ArrayList<>();
        ejemplo.cargaRandom(lista, 7);
        ejemplo.bubbleSort(lista);
        for (int i = 0; i < lista.size(); i++)
            System.out.println(lista.get(i));
        
        //14-Con el ejercicio anterior, arme otro ejemplo y compruebe si el parámetro vector es
        //   enviado como una copia o como una referencia al original. Intente modificar su
        //   contenido dentro del método y luego imprimiendo por fuera del método, para
        //   corroborar si el original cambia o no cambia. Coméntelo en el código lo entendido.
        System.out.println("\n\nEjemplo 14\n");
        lista.clear();
        ejemplo.cargaRandom(lista, 7);  /* Considerando que el objeto lista se pasa por parámetro y en ningún momento 
                                            le asigno el retorno del método cargaRandom(..), se puede decir que el
                                            pasaje es por referencia ya que al mostrar el contenido de la lista desde
                                            la applicación Principal, se observa que el objeto fue modificado.*/
        for (int i = 0; i < lista.size(); i++)
            System.out.println(lista.get(i));
        
        //15-Realizar un procedimiento que reciba como parámetro una pila con 3 elementos
        //   utilizando el objeto Stack de JAVA, dentro el procedimiento debe imprimir los valores
        //   desde el primero en ser agregado hasta el último. Es decir, la pila invertida.
        //   Si la pila tiene puesto Jorge, Carlos, José, donde jorge es la cima de la pila, al
        //   imprimirla debe imprimir José, Carlos, Jorge.
        System.out.println("\n\nEjemplo 15\n");
        Stack pila = new Stack();
        pila.push(1);
        pila.push(1.5);
        pila.push("Ultimo en apilarse");
        ejemplo.mostrarPilaInvertida(pila);
    }
    
}
