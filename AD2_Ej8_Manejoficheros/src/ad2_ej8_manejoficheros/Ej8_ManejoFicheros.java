/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ad2_ej8_manejoficheros;

import java.io.*;
import java.util.Scanner;

/**
 * Ejercicio 8. Realiza un programa que añada a un fichero de texto, el
 * contenido de otro fichero de texto.
 */
/**
 *
 * @author pabloarqueros
 */
public class Ej8_ManejoFicheros {

    /**
     * @param args the command line arguments
     */
    public static void leeFicheroConBuffer(File archivo) {

//        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
//            archivo = new File("parrafo1.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero línea a línea
            String linea;
            while ((linea = br.readLine()) != null) {

                System.out.println(linea);
            }

        } catch (Exception e) {
        } finally {
            // En el finally cerrar el fichero, para asegurarse
            // que se cierra tanto si todo va bien como si salta una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }

            } catch (Exception e2) {
            }

        } // fin finally


    }

    public static void leeFicheroSinBuffer(File fichero) {
        // cadena que almacenará el contenido del archivo
        // OjO!! => para archivos grandes no se puede almacenar el contenido en una cadena
        String cad = "";

        // declaración del manejador del archivo para lectura => f
        FileInputStream f = null;

        try {


            // ver si el fichero no existe
            if (!fichero.exists()) {
                System.out.println("El fichero " + fichero.getName() + " no existe, no se puede leer.");
                // salida incondicional del programa
                System.exit(1);
            } else {
                // === LEER UN FICHERO DE TEXTO ====		

                // abrir el fichero para lectura
                f = new FileInputStream(fichero);
                // también vale así:
                // f = new FileInputStream ("nuevo.txt", true);				

                // tamaño en bytes del archivo
                long tamano = f.available();
                // también vale así:
                // long tamano = fichero.length();				

                // leer caracter a caracter (byte a byte) en el fichero f
                for (int i = 1; i <= tamano; i++) {
                    char car = (char) f.read();
                    cad = cad + car;
                }
            }// fin else

        } catch (IOException e) {
            // En caso de error			
            System.out.println("Error en la lectura del archivo " + e);
        } finally {
            try {
                // cerrar el archivo
                if (f != null) {
                    f.close();
                }
            } catch (IOException e) {
                // En caso de error			
                System.out.println("Error al cerrar el archivo abierto para lectura " + e);
            }
            System.out.println(cad);
        }	// fin finally	

    }

    public static String leeFichero(File archivo) {
        // cadena que almacenará el contenido del archivo
        // OjO!! => para archivos grandes no se puede almacenar el contenido en una cadena
        String cad = "";

        // declaración del manejador del archivo para lectura => f
        FileInputStream f = null;

        try {

            // ver si el fichero no existe
            if (!archivo.exists()) {
                System.out.println("El fichero " + archivo.getName() + " no existe, no se puede leer.");
                // salida incondicional del programa
                System.exit(1);
            } else {
                // === LEER UN FICHERO DE TEXTO ====		

                // abrir el fichero para lectura
                f = new FileInputStream(archivo);
                // también vale así:
                // f = new FileInputStream ("nuevo.txt", true);				

                // tamaño en bytes del archivo
                long tamano = f.available();
                // también vale así:
                // long tamano = fichero.length();				

                // leer caracter a caracter (byte a byte) en el fichero f
                for (int i = 1; i <= tamano; i++) {
                    char car = (char) f.read();
                    cad = cad + car;
                }
            }// fin else

        } catch (IOException e) {
            // En caso de error			
            System.out.println("Error en la lectura del archivo " + e);
        } finally {
            try {
                // cerrar el archivo
                if (f != null) {
                    f.close();
                }
            } catch (IOException e) {
                // En caso de error			
                System.out.println("Error al cerrar el archivo abierto para lectura " + e);
            }

        }	// fin finally	
        return cad;


    }

    public static void insertaTextoString(String cad, File fichero, String ruta) {

        // declaración del manejador del archivo para escritura => f
        FileOutputStream f = null;

        fichero = new File(ruta);

        // === AÑADIR AL FINAL DE UN FICHERO DE TEXTO ====		
        try {
//			File fichero = new File ("nuevo.txt");		

            // ver si el fichero no existe
            if (!fichero.exists()) {
                System.out.println("El fichero " + fichero.getName() + " no existe, se crea nuevo");
            }

            // abrir el fichero para añadir al final
            f = new FileOutputStream(ruta, true);

            // escribir caracter a caracter (byte a byte) en el fichero f
            for (int i = 0; i < cad.length(); i++) {
                char car = cad.charAt(i);
                f.write((byte) car);
            }

        } catch (IOException e) {
            // En caso de error			
            System.out.println("Error en la escritura del archivo " + e);
        } finally {
            try {
                // cerrar el archivo
                if (f != null) {
                    f.close();
                }
            } catch (IOException e) {
                // En caso de error			
                System.out.println("Error al cerrar el archivo abierto para escritura " + e);
            }

        }

    }

    public static void separador() {
        System.out.println("");
        for (int i = 0; i < 80; i++) {
            System.out.printf("_");
        }
        System.out.println("\n");
    }
    //fin separador

    public static void creaArchivoTxt(String nomArchivo) {
        Scanner sc = new Scanner(System.in);

        try (PrintWriter salida = new PrintWriter(nomArchivo)) {
            String cadena;
            System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
            cadena = sc.nextLine();
            while (!cadena.equalsIgnoreCase("FIN")) {
                salida.println(cadena);
                cadena = sc.nextLine();
            }
            salida.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        String titulo1 = "\n\n\"parrafo 1\"\n\n";
        String titulo2 = "\n\n\"parrafo 2\"\n\n";

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el nombre del archivo a crear... ");
        String nomArchivo = entrada.nextLine();
        creaArchivoTxt(nomArchivo);

        System.out.println("Introduce el nombre del archivo a crear... ");
        String nomArchivo2 = entrada.nextLine();
        creaArchivoTxt(nomArchivo2);



        File parrafo1 = new File(nomArchivo);
        File parrafo2 = new File(nomArchivo2);
        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca el nombre del fichero final...");
        String nomFinal = in.nextLine();
        File parrafoFinal = new File(nomFinal);



        String lecFichero1 = leeFichero(parrafo1);
        String lecFichero2 = leeFichero(parrafo2);

        System.out.println("Comprobacion de que lee bien los dos ficheros");
        separador();
        System.out.println("Archivo parrafo1");
        leeFicheroConBuffer(parrafo1);
        separador();
        System.out.println("Archivo parrafo2");
        leeFicheroSinBuffer(parrafo2);

        separador();

        System.out.println("Creacion del fichero con todos los parrafos");

        insertaTextoString(titulo1, parrafoFinal, nomFinal);
        insertaTextoString(lecFichero1, parrafoFinal, nomFinal);
        insertaTextoString(titulo2, parrafoFinal, nomFinal);
        insertaTextoString(lecFichero2, parrafoFinal, nomFinal);

        separador();

        System.out.println(nomFinal);
        leeFicheroConBuffer(parrafoFinal);

    }
}
