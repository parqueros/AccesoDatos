/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ad2_ej10_13_pabloarqueros;

import java.io.IOException;

/**
 *
 * @author pabloarqueros
 */
public class Main {

    public static void main(String[] args) throws IOException {


        char car;


        do {
            car = Menu.menuPrincipal();
            Menu.separador();
            switch (car) {
                case '1':
                    System.out.println("Ejercicio 10\n");
                    Menu.separador();
                    int numero = ES.leeNº("Introduzca el numero de empleado a buscar...\n");
                    Ej10.buscaEmpleado(numero);
                    Menu.separador();
                    break;


                case '2':
                    System.out.println("Ejercicio 11\n");
                    Ej10.LeeFichAleatorio();
                    Menu.separador();
                    int numEmple = ES.leeNº("Introduzca el numero de empleado...");
                    double numAumento = ES.leeNºR("\nIntroduzca el aumento de salario...");
                    Ej11.AumentoSalarial(numEmple, numAumento);

                    break;

                case '3':
                    System.out.println("Ejercicio 12\n");
                    int numEmpleBorr = ES.leeNº("Introduzca el numero de empleado a eliminar...");
                    Ej12.eliminaRegistro(numEmpleBorr);
                    break;

                case '4':
                    System.out.println("Ejercicio 13\n");
                    int numEmplInser = ES.leeNº("Introduzca el numero de empleado a insertar...");
                    String apellido=ES.leeDeTeclado("Introduzca apellido (max.10 caracteres):\n");
                    int dep=ES.leeNº("Introduzca numero de departamento:\n");
                    double salario=ES.leeNºR("Introduzca salario:\n");
                    Ej13.insertEmpleado(numEmplInser,apellido,dep,salario);
//                    Ejercicio13.ejercicioJuan();
                    break;

                case '5':
                    
                    Ej10.EscribeFichAleatorio();
                    
                    break;

                case '6':
                    
                    Ej10.LeeFichAleatorio();
                    
                    break;

                    
                case '7': // ACABAR PROGRAMA
                    System.out.println("\nHasta la próxima......Recuerda ");
                    Menu.asteriscos("Si crees que algo es imposible,tú lo harás imposible    (Bruce Lee)");
                    System.out.println("\nBye, bye..\n");


            }	// fin switch
        } while (car != '7');

    }
}
