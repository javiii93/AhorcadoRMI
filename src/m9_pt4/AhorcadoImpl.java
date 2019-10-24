package m9_pt4;

import java.rmi.RemoteException;

public class AhorcadoImpl extends java.rmi.server.UnicastRemoteObject  implements Palabra {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AhorcadoImpl() throws java.rmi.RemoteException {
		super();
	}

	@Override
	public String comprobarLetra(String a) throws RemoteException {
		System.out.println("toma"+ a);
		return null;
	}

}
