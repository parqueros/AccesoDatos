/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ad2_ej10_13_pabloarqueros;

import java.util.Scanner;

/**
 *
 * @author pabloarqueros
 */
public class Menu {

    public static char menuPrincipal() {
        char car;

        do {
            asteriscos("Acceso a Datos - UD2_Manejo de Ficheros ");

            System.out.println("\n1. Ejercicio 10 _ Buscar Empleado");
            System.out.println("2. Ejercicio 11 _ Aumento Salario");
            System.out.println("3. Ejercicio 12 _ Eliminar Empleado");
            System.out.println("4. Ejercicio 13 _ Insertar Empleado");
            System.out.println("5. Crear Fichero Empleado Inicial");
            System.out.println("6. Leer Fichero Empleado.dat");
            System.out.println("7. Finalizar el programa \n");
            car = leer_caracter("Elige opción (1…7): ");
        } while (car < '1' || car > '7');

        // Los códigos ASCII de '1' '2' '3' y '4' son correlativos, y se puede comparar (car1 < '1' || car1 > '4')
        // también valdría comparar así: while (car1 != '1' && car1 != '2' && car1!= '3' && car1!= '4')

        return car;

    } // fin menuPrincipal

    public static char leer_caracter(String mensaje) {
        Scanner entrada = new Scanner(System.in);
        String texto = "";

        System.out.print(mensaje);
        try {
            texto = entrada.nextLine();
        } catch (Exception e) {
            System.err.println("error de lectura. codigo de error = " + e);
            e.printStackTrace();
        }
        char caracter = texto.charAt(0);
        return caracter;
    }

    public static int leer_entero(String mensaje) {
        // crea objeto entrada de la clase Scanner para la lectura desde la consola
        Scanner entrada = new Scanner(System.in);

        int entero = 0;
        System.out.print(mensaje);
        // nos aseguramos de controlar posibles errores en la lectura
        try {
            entero = entrada.nextInt();
        } // mostramos mensaje de error en caso de lectura incorrecta (p.e leer una letra)
        catch (Exception e) {
            System.err.println("Error de lectura del número. Código de error = " + e);
            e.printStackTrace();
            System.exit(1);
        }
        return entero;
    }// fin leer_entero

    public static void asteriscos(String cad) {
        int i;

        System.out.println("");

        for (i = 1; i <= cad.length() + 4; i++) {
            System.out.print("*");
        }

        System.out.println("\n* " + cad + " *");

        for (i = 1; i < cad.length() + 5; i++) {
            System.out.print("*");
        }

        System.out.println("");
    }//fin asteriscos
    
    public static void separador() {
        System.out.println("");
        for (int i = 0; i < 80; i++) {
            System.out.printf("_");
        }
        System.out.println("\n");
    }//fin separador
}
