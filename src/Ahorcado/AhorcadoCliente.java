package Ahorcado;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import m9_pt4.AhorcadoImpl;
import m9_pt4.Palabra;

public class AhorcadoCliente {
	// static Palabra p;
	public static void main(String[] args) {
		try {
		// Registry r=LocateRegistry.getRegistry("192.168.41.46",1159);
			Palabra p = (Palabra) Naming.lookup("//localhost/Palabra");
			// Palabra p=(AhorcadoImpl) r.lookup("Palabra");
			 p.comprobarLetra("l");

		} catch (RemoteException re) {
			System.out.println();
			System.out.println("RemoteException");
			System.out.println(re);
		} catch (NotBoundException nbe) {
			System.out.println();
			System.out.println("NotBoundException");
			System.out.println(nbe);
		} catch (java.lang.ArithmeticException ae) {
			System.out.println();
			System.out.println("java.lang.ArithmeticException");
			System.out.println(ae);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
