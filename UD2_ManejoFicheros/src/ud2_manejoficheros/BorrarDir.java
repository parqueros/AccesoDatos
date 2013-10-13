package ud2_manejoficheros;

import java.io.File;

/**
 *
 */
public class BorrarDir {

  //ruta del directorio padre que contine los fichero que van a borrarse
  private static final String rutaDirectorio = "NUEVODIR";

  /**
   * **************************************************************************
   * @param args
   */
  public static void main(String[] args) {

    //variables locales
    File f;
    String[] archivos;

    //objeto File hacia la ruta del directorio padre
    File d = new File(rutaDirectorio);

    //si la ruta existe
    if (d.exists()) {
      archivos = d.list();  //obtengo la lista de archivos
      for (int i = 0; i < archivos.length; i++) {
        //objeto File hacia la ruta completa del archivo i-�simo
        f = new File(d, archivos[i]);
        //borra el archivo (se recibe true si la operaci�n tiene �xito)
        if (!f.delete()) {
          //muestra un mensaje si falla la operaci�n (por ejemplo, porque
          //otro usuario lo borra justo antes)
          System.out.printf("\nNo se pudo borrar el fichero %s\n",
                  f.getName());
        }
      }

      //borra la ruta padre (no tendr� efecto si qued� alg�n fichero sin borrar)
      if(!d.delete())
         System.out.println("No se ha podido eliminar directorio");
      
    } else {
      //si la ruta no existe
      System.out.printf("\nNo se encuentra el directorio %s\n", rutaDirectorio);
    }
    
  }
}