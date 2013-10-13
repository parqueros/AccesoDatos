/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ad2_manejoficheros_ej4;

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
public class AD2_ManejoFicheros_Ej4 {

    public static void main(String[] args) {

        String sep = " ";

        creaDir();

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el directorio a listar:....");
        String sDirectorio = entrada.nextLine();
        File l = new File(sDirectorio);

        listarDirectorio(l, sep);

        System.out.println("Introduzca la ruta del directorio a borrar...");
        Scanner entrada1 = new Scanner(System.in);
        String rutaDirectorio = entrada1.next();

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

    public static void listarDirectorio(File f, String separador) {

        File[] ficheros = f.listFiles();

        for (int x = 0; x < ficheros.length; x++) {
            System.out.println(separador + ficheros[x].getName());

            if (ficheros[x].isDirectory()) {
                String nuevo_separador;
                nuevo_separador = separador + " ";
                listarDirectorio(ficheros[x], nuevo_separador);
            }
        }
    }

    public static void creaDir() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre del directorio a crear:");
        String nomDirectorio = entrada.nextLine();
        System.out.println("Introduzca el nombre del directorio 1 a crear:");
        String nomDirectorio1 = entrada.nextLine();
        System.out.println("Introduzca el nombre del directorio 2 a crear:");
        String nomDirectorio2 = entrada.nextLine();
        System.out.println("Introduzca el nombre del archivo 1 a crear:");
        String nomFichero1 = entrada.nextLine();
        System.out.println("Introduzca el nombre del archivo 2 a crear:");
        String nomFichero2 = entrada.nextLine();
        System.out.println("Introduzca el nombre del archivo 3 a crear:");
        String nomFichero3 = entrada.nextLine();

        File d = new File(nomDirectorio); //directorio que creo a partir del actual
        File d1 = new File(d, nomDirectorio1);
        File d2 = new File(d1, nomDirectorio2);
        File f1 = new File(d, nomFichero1);
        File f2 = new File(d1, nomFichero2);
        File f3 = new File(d2, nomFichero3);

        d.mkdir(); //crea el directorio
        d1.mkdir();
        d2.mkdir();
        System.out.println("Directorios creados correctamente...");
        try {
            if (f1.createNewFile()) {
                System.out.println("File f1 creado correctamente....");
            } else {
                System.out.println("No se ha podido crear File f1");
            }
            if (f2.createNewFile()) {
                System.out.println("File f2 creado correctamente");
            } else {
                System.out.println("No se ha podido crear File f2....");
            }
            if (f3.createNewFile()) {
                System.out.println("File f3 creado correctamente");
            } else {
                System.out.println("No se ha podido crear File f3....");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
