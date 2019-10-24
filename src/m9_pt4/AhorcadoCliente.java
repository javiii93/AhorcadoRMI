package m9_pt4;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AhorcadoCliente {
	public static void main(String[] args) {
		try {
			Palabra p = (Palabra) Naming.lookup("//192.168.41.46/Palabra");
			p.comprobarLetra("l");
			/*System.out.println("4 - 3 = "+c.sub(4, 3));
			System.out.println("4 + 5 = "+c.add(4, 5));
			System.out.println("3 * 6 = "+c.mul(3, 6));
			System.out.println("9 / 3 = "+c.div(9, 3));*/
		} catch (MalformedURLException murle) {
			System.out.println();
			System.out.println("MalformedURLException");
			System.out.println(murle);
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
		}
	}
}
