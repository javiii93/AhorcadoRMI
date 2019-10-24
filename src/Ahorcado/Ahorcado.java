package Ahorcado;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Ahorcado extends Remote {
public boolean comprobarLetra(String a) throws RemoteException;
}
