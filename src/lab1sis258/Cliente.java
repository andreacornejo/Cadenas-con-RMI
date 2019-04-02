/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1sis258;

import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author andrea
 */
public class Cliente {
    
    public static void main(String args[]){
      InterfazOperaciones calculadora;
      String cadena;
      int num;
	try {
            Scanner sn = new Scanner(System.in);
            boolean salir = false;
            int opcion; 
            calculadora=(InterfazOperaciones)Naming.lookup("rmi://localhost/Calculadora");
            //cadena = "Hola";
            //num = 3;
	    System.out.println("Introducir una cadena: \n");
            cadena = sn.nextLine();
            calculadora.IntroducirValor(cadena);
            
            
            while(!salir){
            System.out.println("1) Invertir cadena");
            System.out.println("2) Aumentar espacios");
            System.out.println("3) Aumentar");
            System.out.println("4) Salir");
            opcion = sn.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("La cadena invertida es: \n"); 
                    System.out.println( calculadora.Invertir(cadena));
                break;
                case 2:
                    System.out.println("Introducir numero de espacios: \n");
                    num = sn.nextInt();
                    System.out.println("La cadena aumentada con" + num + "espacios es: \n"); 
                    System.out.println( calculadora.AumentarEspacios(num));
                break;
                case 3:
                    Scanner cadena2 = new Scanner(System.in);
                    System.out.println("Inserte la cadena que desea aumentar: \n");
                    String cadenaumentada = cadena2.nextLine();
                    System.out.println("La cadena aumentada es: \n"); 
                    System.out.println( calculadora.Aumentar(cadenaumentada));
                break;
                case 4:
                    salir=true;
                break;
                default:
                    System.out.println("Opcion invalida \n"); 
                break;
                }
            }
	    
            
	    //System.out.println( calculadora.AumentarEspacios(num));
            //System.out.println( calculadora.Invertir(cadena));
            //System.out.println( calculadora.Aumentar(cadena));

	}
	catch (Exception e){
	    e.printStackTrace();
	}
    }
}
