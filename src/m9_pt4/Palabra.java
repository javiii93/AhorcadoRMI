package m9_pt4;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Palabra extends Remote {
public boolean comprobarLetra(String a) throws RemoteException;
}
