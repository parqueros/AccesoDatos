import java.io.*;
public class VerInf{
public static void main(String[] args){
  System.out.println("Informaci�n sobre el fichero");
  File f = new File ("VerInf.java");
  if(f.exists()){
	System.out.println("Nombre del fichero: " + f.getName());
	System.out.println("Ruta: " + f.getPath());
	System.out.println("Ruta absoluta: " + f.getAbsolutePath());
	System.out.println("Se puede leer: " + f.canRead());
	System.out.println("Se puede escribir: " + f.canWrite());

	System.out.println("Tama�o: " + f.length());
	System.out.println("Es un directorio: " + f.isDirectory());
	System.out.println("Es un fichero: " + f.isFile());
	}
     }
}