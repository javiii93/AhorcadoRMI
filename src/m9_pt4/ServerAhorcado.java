package m9_pt4;

import java.rmi.registry.Registry;

public class ServerAhorcado {

	public static void main(String args[]) {
		try {
	    	Registry r = java.rmi.registry.LocateRegistry.createRegistry(1159);
			r.rebind("Palabra", new AhorcadoImpl());
			System.out.println("Server connected");
	     } catch (Exception e) {
	       System.out.println("Trouble: " + e);
	     }
		
	}


	
	

}
