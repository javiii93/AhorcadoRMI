package Ahorcado;

import java.rmi.registry.Registry;

import m9_pt4.AhorcadoImpl;

public class AhorcadoServer {

	public static void main(String args[]) {
		try {
	    	Registry r = java.rmi.registry.LocateRegistry.createRegistry(1159);
			r.rebind("Ahorcado", new AhorcadoImpl());
			System.out.println("Server connected");
	     } catch (Exception e) {
	       System.out.println("Trouble: " + e);
	     }
		
	}


	
	

}
