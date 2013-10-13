package ud2_manejoficheros;

import java.io.*;
public class VerDir{
  public static void main(String[] args){
    System.out.println("Ficheros en directorio actual: ");
    File f = new File(".");
    String[] archivos = f.list();
    for (int i=0; i<archivos.length; i++) {
	System.out.println(archivos[i]);
     }
   }
}