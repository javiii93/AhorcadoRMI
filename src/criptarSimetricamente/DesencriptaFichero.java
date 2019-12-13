package criptarSimetricamente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AlgorithmParameters;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class DesencriptaFichero {
	public static final int ITERACIONES = 1024; 
	 public static final int TAMANO_BUFFER = 1024; 
	 
	 public static void main (String args[]) throws Exception 
	        { 
		 String password="12345";
		 File f=new File("archivoEncriptado.des");
	
	         // Abrimos los ficheros 
	         System.out.print("Abriendo fichero..."); 
	         DataInputStream fichero_encriptado = 
	                 new DataInputStream(new FileInputStream(f)); 
	         FileOutputStream fichero_plano = new FileOutputStream("ficheroDesencriptado.txt"); 
	          
	         // Generamos una clave secreta a partir 
	         // del password 
	         System.out.print("\rGenerando clave secreta"); 
	         PBEKeySpec objeto_password =  
	             new PBEKeySpec(password.toCharArray()); 
	         SecretKeyFactory skf =  
	                SecretKeyFactory.getInstance( 
	                                 "PBEWithMD5AndDES"); 
	         SecretKey clave_secreta =  
	                skf.generateSecret(objeto_password); 
	 
	          
	         // Leemos los parametros encoded 
	         int longitud_encoded = 
	              fichero_encriptado.readInt(); 
	         byte[] encoded = new byte[longitud_encoded]; 
	         fichero_encriptado.read(encoded); 
	         AlgorithmParameters ap = 
	               AlgorithmParameters.getInstance( 
	               "PBEWithMD5AndDES"); 
	         ap.init(encoded); 
	          
	         // Creamos el cifrador 
	         Cipher cifrador =  
	              Cipher.getInstance("PBEWithMD5andDES"); 
	         cifrador.init(Cipher.DECRYPT_MODE 
	              ,clave_secreta,ap); 
	              
	         // Desencriptamos el contenido del fichero 
	         // encriptado y lo pasamos al fichero plano 
	         System.out.print("\rDesencriptando fichero..."); 
	         byte[] buffer = new byte[TAMANO_BUFFER]; 
	         int bytes_leidos =  
	              fichero_encriptado.read(buffer); 
	         while (bytes_leidos>0) 
	               { 
	                fichero_plano.write(cifrador.update( 
	                                  buffer,0,bytes_leidos)); 
	                bytes_leidos =  
	                     fichero_encriptado.read(buffer); 
	               } 
	         fichero_plano.write(cifrador.doFinal()); 
	         // Cerramos los ficheros 
	         fichero_encriptado.close(); 
	         fichero_plano.close(); 
	         System.out.println("\rHecho                   "); 
	        }
	
}
