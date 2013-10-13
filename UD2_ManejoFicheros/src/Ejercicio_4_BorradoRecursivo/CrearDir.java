package Ejercicio_4_BorradoRecursivo;

import java.io.*;
import java.util.Scanner;

public class CrearDir {
/**
 * La clase CrearDir crea una estructura de directorios donde hay 3 niveles de
 * profundidad y además crea archivos en cada unos de los niveles.
 * @param args 
 */
    public static void creaDir() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre del directorio a crear:");
        String nomDirectorio=entrada.nextLine();
        System.out.println("Introduzca el nombre del directorio 1 a crear:");
        String nomDirectorio1=entrada.nextLine();
        System.out.println("Introduzca el nombre del directorio 2 a crear:");
        String nomDirectorio2=entrada.nextLine();
        System.out.println("Introduzca el nombre del archivo 1 a crear:");
        String nomFichero1=entrada.nextLine();
        System.out.println("Introduzca el nombre del archivo 2 a crear:");
        String nomFichero2=entrada.nextLine();
        System.out.println("Introduzca el nombre del archivo 3 a crear:");
        String nomFichero3=entrada.nextLine();
        
        File d = new File(nomDirectorio); //directorio que creo a partir del actual
        File d1= new File(d,nomDirectorio1);
        File d2= new File(d1,nomDirectorio2);
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