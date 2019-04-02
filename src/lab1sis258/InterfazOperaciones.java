package lab1sis258;


import java.rmi.*;

public interface InterfazOperaciones extends Remote {
    void IntroducirValor(String arg) throws RemoteException; 
    String Invertir(String arg) throws RemoteException;
    String AumentarEspacios(int arg) throws RemoteException;
    String Aumentar(String arg) throws RemoteException;

    
}


