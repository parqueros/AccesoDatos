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
                    Ej10.EscribeFichAleatorio();
                    Ej10.LeeFichAleatorio();
                    Menu.separador();
                    int numero = ES.leeNº("Introduzca el numero de empleado a buscar...\n");
                    Ej10.buscaEmpleado(numero);
                    Menu.separador();
                    break;


                case '2':
                    System.out.println("Ejercicio 11\n");
                    Ej11.LeeFichAleatorio();
                    Menu.separador();
                    int numEmple = ES.leeNº("Introduzca el numero de empleado...");
                    double numAumento = ES.leeNºR("Introduzca el aumento de salario...");
                    Ej11.AumentoSalarial(numEmple, numAumento);


                    break;

                case '3': // ACABAR PROGRAMA
                    System.out.println("\nHasta la próxima......Recuerda ");
                    Menu.asteriscos("Si crees que algo es imposible,tú lo harás imposible    (Bruce Lee)");
                    System.out.println("\nBye, bye..\n");


            }	// fin switch
        } while (car != '3');

    }
}
