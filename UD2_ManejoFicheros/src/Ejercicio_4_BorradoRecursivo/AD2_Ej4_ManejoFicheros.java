/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio_4_BorradoRecursivo;

import java.io.*;
import java.util.Scanner;

/**
 * Realiza un programa que elimine de forma recursiva un directorio. Se debe
 * contemplar la posibilidad de que el directorio contenga subdirectorios a
 * diferentes niveles de profundidad. El nombre del directorio se pasará al
 * programa desde la línea de comandos al ejecutarlo
 */
/**
 *
 * @author pabloarqueros
 */
public class AD2_Ej4_ManejoFicheros {

    public static void main(String[] args) {
        
        CrearDir.creaDir();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca la ruta del directorio a borrar...");
        String rutaDirectorio = entrada.next();

        //objeto File hacia la ruta del directorio padre
        File d = new File(rutaDirectorio);
        if (d.exists()) {

            borradoRecursivo(d);

            if (d.delete()) {
                System.out.println("El directorio " + rutaDirectorio + " ha sido borrado correctamente");
            } else {
                System.out.println("El directorio " + rutaDirectorio + " no se ha podido borrar");
            }

        } else {
            //si la ruta no existe
            System.out.printf("\nNo se encuentra el directorio %s\n", rutaDirectorio);
        }
    }

    public static void borradoRecursivo(File directorio) {

        File[] archivos = directorio.listFiles();

        for (int x = 0; x < archivos.length; x++) {
            if (archivos[x].isDirectory()) {
                borradoRecursivo(archivos[x]);
            }
            archivos[x].delete();
        }
    }
}
