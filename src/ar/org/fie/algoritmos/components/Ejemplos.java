/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.org.fie.algoritmos.components;

import java.util.Random;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 *
 * @author bauti
 */
public class Ejemplos {
    /*
    Agregar otra Clase “Ejemplos” con los métodos necesarios para cumplir la consigna,
    crear una instancia de esta misma en el main de la Clase Principal.
    */
    
    private int attributoGlobalX;
    private ArrayList<String> nombres;
    
    public Ejemplos()
    {
        this.attributoGlobalX = 10;
        this.nombres = new ArrayList<>();
        this.nombres.add("Agustin");
        this.nombres.add("Gonzalo");
        this.nombres.add("Isabel");
    }
    
    public byte ultimoDigito(int numero)
    {
        return ((byte) (numero % 10));
    }
    
    public double potencia(int base, int exponente)
    {
        double resultado = 1;
        int exp = exponente;
        if (exp < 0)
            exp = -exp;
        for (int i = 0; i < exp; i++)
            resultado = resultado * base;
        if (exponente < 0)
            resultado = 1 / ((float) resultado);
        return resultado;
    }
    
    public long sumaGaussiana(int n)
    {
        long resultado = (n * (long)(n+1))/2;
        return resultado;
    }
    
    public short contarChar(char c, String txt)
    {
        short cantidad = 0;
        for (int i = 0; i < txt.length(); i++)
            if (txt.charAt(i) == c)
                cantidad++;
        return cantidad;
    }
    
    public boolean randBool(float probabilidad)
    {
        Random rnd = new Random();
        if (rnd.nextFloat() <= probabilidad)
            return true;
        else
            return false;
    }
    
    //Ejercicio 2
    public String ejemploAritmetica()
    {
        Random rnd = new Random();
        int a = rnd.nextInt(50);
        int b = rnd.nextInt(49) + 1;
        String txt = "";
        txt = txt + a + " + " + b + " = " + (a+b) + "\n";
        txt = txt + a + " - " + b + " = " + (a-b) + "\n";
        txt = txt + a + " * " + b + " = " + (a*b) + "\n";
        txt = txt + a + " / " + b + " = " + (a/b) + "\n";
        txt = txt + a + " % " + b + " = " + (a%b) + "\n";
        txt = txt + a + " / (float) " + b + " = " + (a/(float)b) + "\n";
        txt = txt + "\nprintln(a)   --> " + a + "\n";
        txt = txt + "println(a++) --> " + a++ + "\n";
        txt = txt + "println(a)   --> " + a + "\n";
        txt = txt + "println(++a) --> " + ++a + "\n";
        txt = txt + "println(a)   --> " + a + "\n";
        txt = txt + "\nprintln(b)   --> " + b + "\n";
        txt = txt + "println(b--) --> " + b-- + "\n";
        txt = txt + "println(b)   --> " + b + "\n";
        txt = txt + "println(--b) --> " + --b + "\n";
        txt = txt + "println(b)   --> " + b;
        
        return txt;
    }
    
    //Ejercicio 3
    public String tablaVerdad()
    {
        boolean p, q;
        String pTxt, qTxt;
        String tabla = "p    q    y    o   xor  -->  <->\n";
        for (int i = 0; i < 4; i++)
        {
            p = (i%2 == 0);
            q = ((i/2)%2 == 0);
            if (p)
                pTxt = "v    ";
            else
                pTxt = "f    ";
            if (q)
                qTxt = "v    ";
            else
                qTxt = "f    ";
            tabla = tabla + pTxt + qTxt;
            if (p && q)
                tabla = tabla + "v    ";
            else
                tabla = tabla + "f    ";
            if (p || q)
                tabla = tabla + "v    ";
            else
                tabla = tabla + "f    ";
            if ((p || q)&&(!(p && q)))
                tabla = tabla + "v    ";
            else
                tabla = tabla + "f    ";
            if (!p || q)
                tabla = tabla + "v    ";
            else
                tabla = tabla + "f    ";
            if (p == q)
                tabla = tabla + "v    ";
            else
                tabla = tabla + "f    ";
            
            tabla = tabla + '\n';
        }
        
        return tabla;
    }
    
    //Ejercicio 4
    public String calcularSueldo(float sueldoBruto, float creditosImpositivos)
    {
        final int BASE1 = 45000, BASE2 = 90000, CRED_BASE1 = 10000, MAX_SUELDO_CUBIERTO = 70000, MIN_EXCENTO_JUBILACION = 3500;
        final float CRED1 = 0.18f, CRED2 = 0.1f, IMP1 = 0.15f, IMP2 = 0.205f, IMP3 = 0.3f, porcentJubilacion = 0.07f, porcentObraSoc = 0.054f;
        
        String recibo = "Sueldo bruto: $" + sueldoBruto + '\n';
        float obraSoc = Math.max(Math.min(sueldoBruto, MAX_SUELDO_CUBIERTO), 0) * porcentObraSoc;
        float jubilacion = Math.max(Math.min(sueldoBruto, MAX_SUELDO_CUBIERTO) - MIN_EXCENTO_JUBILACION, 0) * porcentJubilacion;
        double impuestos = 0;
        float deduccion = CRED_BASE1;
        
        //Hasta sueldo = BASE1 --> impuesto marginal = IMP1 | deduccion = CRED_BASE1
        //Desde sueldo BASE1 hasta sueldo BASE2 --> impuesto marginal = IMP2 | deduccion = CRED_BASE1 + (sueldoBruto-BASE1) * CRED1
        //Desde sueldo BASE2 --> impuesto marginal = IMP3 | deduccion = CRED_BASE1 + (BASE2-BASE1)*CRED1 + (sueldoBruto-BASE2)*CRED2
        if (creditosImpositivos > deduccion)
        {
            if (sueldoBruto <= BASE2)
            {
                deduccion += ((sueldoBruto - BASE1) * CRED1);
            }else
            {
                deduccion += ((BASE2-BASE1)*CRED1 + (sueldoBruto-BASE2)*CRED2);
            }
        }
        deduccion = Math.min(deduccion, creditosImpositivos);
        
        recibo = recibo + "Creditos impositivos: ($" + deduccion + ")\nBase imponible: $" + (sueldoBruto-deduccion) 
                + "\nObra social: -$" + obraSoc + "\nJubilación: -$" + jubilacion + "\nImpuestos (";
        
        if (sueldoBruto-deduccion <= BASE1)
        {
            impuestos = (sueldoBruto-deduccion)*IMP1;
        }else if (sueldoBruto-deduccion <= BASE2)
        {
            impuestos = BASE1*IMP1+(sueldoBruto-deduccion-BASE1)*IMP2;
        }else
        {
            impuestos = BASE1*IMP1 + (BASE2-BASE1)*IMP2 + (sueldoBruto-deduccion-BASE2)*IMP3;
        }
        
        recibo = recibo + (float)(100*impuestos/sueldoBruto) + "%): -$" + impuestos + "\nNeto: $" + (sueldoBruto - obraSoc - jubilacion - impuestos);
                
        return recibo;
    }

    //Ejercicio 5
    public long factorialRepetitivo(int n) {
        if (n < 0)
            return -1;
        long resultado = 1;
        for (int i = 0; i < n; i++)
            resultado = resultado * (long)(i+1);
        return resultado;
    }

    //Ejercicio 6
    public long factorialRecursivo(int n) {
        if (n < 0)
            return -1;
        if (n == 0 || n == 1)
            return 1;
        else
            return (n * factorialRecursivo(n-1));
    }
    
    //Ejercicio 7
    public String raices(float a, float b, float c)
    {
        String resultado = a + "*x^2 + " + b + "*x + " + c + " = " + a + "(x + ";
        float determinante = b*b - 4*a*c;
        if (determinante >= 0)
        {
            resultado = resultado + (-(-b+Math.sqrt(determinante))/(2*a)) + ")*(x + ";
            resultado = resultado + (-(-b-Math.sqrt(determinante))/(2*a)) + ")";
        }
        else
        {
            resultado = resultado + (-(-b+Math.sqrt(-determinante))/(2*a)) + "i)*(x + ";
            resultado = resultado + (-(-b-Math.sqrt(-determinante))/(2*a)) + "i)";
        }
        return resultado;
    }
    
    //Ejercicio 8
    public boolean esPar(int num)
    {
        return (num%2 == 0);
    }
    
    //Ejercicio 9
    public int alcanceDeVariables(int numero)
    {
        if (esPar(numero))
            this.attributoGlobalX = 34;
        else
            this.attributoGlobalX = 25;
        miFuncion();
        factorialRepetitivo(ultimoDigito(this.attributoGlobalX));
        
        return this.attributoGlobalX;
    }
    
    private void miFuncion()
    {
        Random rnd = new Random();
        this.attributoGlobalX = rnd.nextInt();
    }
    
    //Ejercicio 10
    public String mostrarNotas()
    {
        int notas[] = {7, 9, 8, 7, 10};
        int suma = 0;
        String txt = "Notas:\n";
        for (int i:notas)
        {
            suma += i;
            txt = txt + i + ", ";
        }
        txt = txt + "\nPromedio: " + suma/(float)notas.length;
        return txt;
    }
    
    //Ejercicio 11
    public void mostrarLista()
    {
        for (int i = 0; i < this.nombres.size(); i++)
            System.out.printf("%s, ", this.nombres.get(i));
        System.out.printf("\nCantidad de alumnos: %d\n", this.nombres.size());
    }
    
    //Ejercicio 12
    public void contenidoDeLista()
    {
        String estudiante = "Gonzalo";
        System.out.printf("%s", estudiante);
        if (!this.nombres.contains(estudiante))
            System.out.printf("no");
        System.out.printf(" es estudiante.\n");
        System.out.printf("%s es el estudiante de la posición nº%d\n", estudiante, this.nombres.indexOf(estudiante));
        estudiante = "Micaela";
        System.out.printf("%s", estudiante);
        if (!this.nombres.contains(estudiante))
            System.out.printf(" no");
        System.out.printf(" es estudiante.\n");
    }
    
    //13
    public ArrayList<Integer> cargaRandom(ArrayList<Integer> lista, int cantidad)
    {
        Random rnd = new Random();
        for (int i = 0; i < cantidad; i++)
        {
            lista.add(rnd.nextInt(1000));
        }
        return lista;
    }
    
    //13
    public ArrayList<Integer> bubbleSort(ArrayList<Integer> lista)
    {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (lista.get(j) > lista.get(j + 1))
                {
                    //Intercambiar
                    int temporal = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temporal);
                }
        return lista;
    }
    
    //Ejercicio 15
    public void mostrarPilaInvertida(Stack pila)
    {
        Stack invertida = new Stack();
        while (pila.size() > 0)
            invertida.push(pila.pop());
        while (invertida.size() > 0)
            System.out.println(invertida.pop());
    }
}
