package ud2_manejoficheros;

import java.io.*;
import java.util.Scanner;

/*
 * Ejercicio 2. Realiza un programa en Java que muestre los ficheros de un directorio.
 * El nombre del directorio se pasará al programa desde la línea de comandos al
 * ejecutarlo(muestra el primer nivel).
 */
/**
 *
 * @author pabloarqueros
 */
public class AD2_Ej3_ManejoFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre del directorio...");
        String nomDirectorio = entrada.next();
        listarDirRecurs();
    }

    public static void listarDirRecurs() {
        
        
        String nom = null;
        System.out.println("Ficheros en directorio actual: ");
        File f = new File(nom);
        File[] archivos = f.listFiles();

        for (int i = 0; i < archivos.length; i++) {
            System.out.println(archivos[i].getName());
            if (archivos[i].isDirectory()) {
               
               listarDirRecurs();

            }
        }
    }
}
