package criptarSimetricamente;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.AlgorithmParameters;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class EncriptaFichero {
	public static final int ITERACIONES = 1024; 
	 public static final int TAMANO_SALT_BYTES = 8; 
	 public static final int TAMANO_BUFFER = 1024; 
	                       
	 public static void main (String args[]) throws Exception 
	        { 
		 String password="12345";
		 File f=new File("palabras.txt");
	        
	         // Abrimos los ficheros 
	        
	         FileInputStream fichero_plano =  
	                          new FileInputStream(f); 
	         DataOutputStream fichero_encriptado= new DataOutputStream( 
	                    new FileOutputStream("archivoEncriptado.des")); 
	                     
	         //Generamos un salt aleatorio 
	         System.out.print("Generando salt..."); 
	         SecureRandom sr = new SecureRandom(); 
	         byte[] salt = new byte[8]; 
	         sr.nextBytes(salt); 
	                   
	         // Generamos una clave secreta a  
	         // partir del password 
	         System.out.print("\rGenerando clave secreta"); 
	         PBEKeySpec objeto_password = 
	                   new PBEKeySpec(password.toCharArray()); 
	         SecretKeyFactory skf =  
	          SecretKeyFactory.getInstance("PBEWithMD5AndDES"); 
	         
	         SecretKey clave_secreta = 
	                       skf.generateSecret(objeto_password); 
	          
	         // Generamos los parametros de PBEParameterSpec 
	         
	         PBEParameterSpec pbeps =  
	                    new PBEParameterSpec(salt,ITERACIONES); 
	          
	         // Generamos el cifrador 
	         Cipher cifrador =  
	                      Cipher.getInstance("PBEWithMD5AndDES"); 
	         cifrador.init(Cipher.ENCRYPT_MODE 
	                      ,clave_secreta,pbeps); 
	          
	         // Escribimos en el fichero encriptado los  
	         // parametros encoded 
	         System.out.print("\rEscribiendo fichero" 
	                        + " encriptado...           "); 
	         AlgorithmParameters ap = cifrador.getParameters(); 
	         byte[] encoded = ap.getEncoded(); 
	         fichero_encriptado.writeInt(encoded.length); 
	         fichero_encriptado.write(encoded); 
	          
	         // Escribimos en el fichero encriptado los 
	         // datos del fichero plano 
	         byte[] buffer_plano = new byte[TAMANO_BUFFER]; 
	         int leidos = fichero_plano.read(buffer_plano); 
	         while(leidos>0) 
	              { 
	               byte[] buffer_encriptado =  
	                    cifrador.update(buffer_plano,0,leidos); 
	               fichero_encriptado.write(buffer_encriptado); 
	               leidos = fichero_plano.read(buffer_plano); 
	              } 
	         fichero_encriptado.write(cifrador.doFinal()); 
	          
	         // Cerramos los ficheros 
	         fichero_plano.close(); 
	         fichero_encriptado.close();  
	         System.out.println("\rHecho       "); 
	        } 
}
