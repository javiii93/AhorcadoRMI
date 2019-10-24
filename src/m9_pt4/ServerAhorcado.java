package m9_pt4;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class ServerAhorcado extends java.rmi.server.UnicastRemoteObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ServerAhorcado() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
	    	Registry r = java.rmi.registry.LocateRegistry.createRegistry(1159);
			r.rebind("Palabra", new AhorcadoImpl());
			System.out.println("Server connected");
	     } catch (Exception e) {
	       System.out.println("Trouble: " + e);
	     }
		
	}


	
	

}
