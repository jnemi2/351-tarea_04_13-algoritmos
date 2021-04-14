/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.org.fie.algoritmos.components;

import java.util.Random;

/**
 *
 * @author bauti
 */
public class Ejemplos {
    /*
    Agregar otra Clase “Ejemplos” con los métodos necesarios para cumplir la consigna,
    crear una instancia de esta misma en el main de la Clase Principal.
    */
    public Ejemplos()
    {
        
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
    public String calcularSueldo(float sueldoBruto, float porcentObraSoc, float porcentJubilacion, float creditosImpositivos)
    {
        final int BASE1 = 45000, BASE2 = 90000, CRED_BASE1 = 10000, CRED_BASE2 = 18100;
        final float CRED1 = 0.18f, CRED2 = 0.1f, IMP1 = 0.15f, IMP2 = 0.205F, IMP3 = 0.3f;
        
        String recibo = "Sueldo bruto: $" + sueldoBruto + '\n';
        float obraSoc = 0;
        float jubilacion = 0;
        float impuestos = 0;
        
        obraSoc += sueldoBruto * porcentObraSoc;
        jubilacion += sueldoBruto * porcentJubilacion;
        recibo = recibo + "Obra social: -$" + obraSoc + '\n' + "Jubilación: -$" + jubilacion + '\n';
        
        if (sueldoBruto < BASE1)
        {
            //Impuesto marginal 15% | puede deducir hasta CRED_BASE1 en creditos impositivos
            if (creditosImpositivos > CRED_BASE1)
            {
                impuestos = (sueldoBruto - CRED_BASE1) * IMP1;
            }else
            {
                impuestos = (sueldoBruto - creditosImpositivos) * IMP1;
            }
            
        } else if (sueldoBruto < BASE2)
        {
            //Impuesto marginal 20.5% | puede deducir hasta CRED_BASE1 + CRED1 del excedente de BASE1 en creditos impositivos
            if (creditosImpositivos > (CRED_BASE1 + (sueldoBruto - BASE1) * CRED1))
            {
                impuestos = BASE1 * IMP1 + (sueldoBruto - BASE1) * IMP2;
                if (impuestos - BASE1*IMP1 > (CRED_BASE1 + (sueldoBruto - BASE1) * CRED1)*IMP2)
                    impuestos -= (CRED_BASE1 + (sueldoBruto - BASE1) * CRED1)*IMP2;
            }
            else
            {
                impuestos = BASE1 * IMP1 + (sueldoBruto - BASE1)*IMP2;
                if (impuestos - BASE1*IMP1 > creditosImpositivos*IMP2)
                    impuestos -= creditosImpositivos*IMP2;
            }
        } else
        {
            //Impuesto marginal 30% | puede deducir hasta CRED_BASE2 + CRED2 del excedente de BASE2 en creditos impositivos
            if (creditosImpositivos > (CRED_BASE2 + (sueldoBruto - BASE2) * CRED2))
            {
                impuestos = BASE1 * IMP1 + BASE2 * IMP2 + (sueldoBruto - BASE2 - (CRED_BASE2 + (sueldoBruto - BASE2) * CRED2)) * IMP3;
                impuestos = BASE1 * IMP1 + (BASE2-BASE1) * IMP2 + (sueldoBruto - BASE2)*IMP3;
                if (impuestos - BASE1*IMP1 - (BASE2-BASE1) * IMP2 > (CRED_BASE2 + (sueldoBruto - BASE2) * CRED2)*IMP3)
                    impuestos -= (CRED_BASE2 + (sueldoBruto - BASE2) * CRED2)*IMP3;
            }else
            {
                impuestos = BASE1 * IMP1 + BASE2 * IMP2 + (sueldoBruto - BASE2 - creditosImpositivos) * IMP3;
                impuestos = BASE1 * IMP1 + (BASE2-BASE1) * IMP2 + (sueldoBruto - BASE2)*IMP3;
                if (impuestos - BASE1*IMP1 - (BASE2-BASE1) * IMP2 > creditosImpositivos*IMP3)
                    impuestos -= creditosImpositivos*IMP3;
            }
        }
        
        recibo = recibo + "Impuestos: -$" + impuestos + "\n\nNeto: $" + (sueldoBruto - obraSoc - jubilacion - impuestos) + '\n';
        return recibo;
    }
}
