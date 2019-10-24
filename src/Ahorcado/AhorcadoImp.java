package Ahorcado;
import java.rmi.RemoteException;



public class AhorcadoImp extends java.rmi.server.UnicastRemoteObject  implements Ahorcado {
	private static final long serialVersionUID = 1L;

	public AhorcadoImp() throws java.rmi.RemoteException {
		super();
	}

	@Override
	public boolean comprobarLetra(String a) throws RemoteException  {
	System.out.println(a);
		return false;
	}


}
