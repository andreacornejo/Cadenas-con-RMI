package lab1sis258;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;


public class Servidor 
    extends UnicastRemoteObject
    implements InterfazOperaciones
    
	 
{
    String cadena;
    String cadena2;
    Servidor() throws java.rmi.RemoteException{
	super();
    }
    
    @Override
    public void IntroducirValor(String arg) {
	cadena = arg;
        
    }
    
    @Override
    public String Invertir(String arg) {
        StringBuilder builder = new StringBuilder(cadena);
        String CadenaInvertida = builder.reverse().toString();
        return CadenaInvertida+"\n";
    }
    
    @Override
    public String AumentarEspacios(int espacios){
       
        String CadenaEspacios = "";
        
        for(int i = 0; i < cadena.length(); i++){
            
            CadenaEspacios = CadenaEspacios + Character.toString(cadena.charAt(i));
            for(int j = 1 ; j <= espacios; j++){
                CadenaEspacios= CadenaEspacios + " ";
            }
            
       }
        return CadenaEspacios +"\n";
    }
    
    @Override
    public String Aumentar(String arg){
       cadena2 = arg;
       return cadena + " " + cadena2 + "\n"; 
    }
    
    public static void main(String args[]) { 
	try {
	    Servidor calculadora;
	    LocateRegistry.createRegistry(1099);
	    calculadora=new Servidor(); 
	    Naming.bind("Calculadora", calculadora); 
            System.out.println("El servidor esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    }    


}


