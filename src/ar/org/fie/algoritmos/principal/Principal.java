/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.org.fie.algoritmos.principal;

import ar.org.fie.algoritmos.components.Ejemplos;

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
        
        System.out.println(ejemplo.calcularSueldo(45000, 0.054f, 0.07f, 10000));
    }
    
}
