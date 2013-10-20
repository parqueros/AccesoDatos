/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ad2_ej10_13_pabloarqueros;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author pabloarqueros
 */
public class Ej11 {

 
    public static void EscribeFichAleatorio() throws IOException {

        File fichero = new File("EmpleAleatorio.dat"); //fichero

        //declara el fichero de acceso aleatorio y modo acceso lectura/escritura
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        //arrays con los datos - apellidos
        String apellido[] = {"ARQUEROS", "SANTOS", "MARTINEZ", "PEREZ", "EGEA", "FORTES", "NOJA"};
        int dep[] = {18, 15, 18, 20, 20, 33, 15}; //departamentos
        double salario[] = {3500.58, 3000.45, 4000.85, 8125.41, 6000.51, 1900.74, 2500.0};//salarios
        StringBuffer buffer = null;// buffer para almacenar apellido
        int n = apellido.length; //número de elementos del array
        for (int i = 0; i < n; i++) { //recorrido del array
            file.writeInt(i + 1); //i+1 es el identificador del empleado (4 bytes)
            buffer = new StringBuffer(apellido[i]);
            buffer.setLength(10); //10 caracteres para el apellido
            file.writeChars(buffer.toString());//insertar apellido (20 bytes)
            file.writeInt(dep[i]); //insertar departamento (4 bytes)
            file.writeDouble(salario[i]);//insertar salario (8 bytes)
        }
        file.close();// cerrar fichero

    }

    public static void LeeFichAleatorio() throws IOException {

        File fichero = new File("EmpleAleatorio.dat");
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        int id, dep, posicion;
        Double salario;
        char apellido[] = new char[10], aux;
        posicion = 0; //para situarnos al principio
        file.seek(posicion); /*con while *///apuntador de fichero se sitúa en posicion
        System.out.printf("%-4s%-12s%-6s%-8s\n","ID","Apellido","Dept","Salario");
        while (file.getFilePointer() < file.length() - 36) { /*con while */
            
            file.seek(posicion); //apuntador de fichero se sitúa en posicion
            id = file.readInt(); //obtener id de empleado
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();//recorremos uno a uno los caracteres del apellido
                apellido[i] = aux; //los voy guardando en el array
            }
            String apellidos = new String(apellido); //convierto a String el array 
            dep = file.readInt(); //obtengo dep
            salario = file.readDouble(); //obtengo salario
   
            //muestro por pantalla los datos de los empleados
            System.out.printf("%-4s%-12s%-6s%-8s\n",id, apellidos, dep, salario);
            posicion += 36; //cada empleado ocupa 36 bytes (4+20+4+8)
            
            //posiciono el apuntador
            file.seek(posicion); /*con while */
        }

        file.close(); //cerrar fichero


    }

    public static void AumentoSalarial(int numEmpleado, double incremSalarial) throws IOException {

        File fichero = new File("EmpleAleatorio.dat");
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        int posicion = (numEmpleado - 1) * 36; //calculo donde empieza el registro
        if (posicion > file.length()-36 || posicion < 0) {
            System.out.println("El empleado con ID: " + numEmpleado + " no existe...");
        } else {

            file.seek(posicion);
            posicion = file.readInt();
            char apellido[] = new char[10], aux;
            int dep;
            Double salario;
            Double nuevoSalario;

            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();//recorremos uno a uno los caracteres del apellido
                apellido[i] = aux; //los voy guardando en el array
            }
            String apellidos = new String(apellido); //convierto aString el array 
            dep = file.readInt(); //obtengo dep
            salario = file.readDouble(); //obtengo salario
            nuevoSalario = salario + incremSalarial; //calculo nuevoSalario
            file.seek(file.getFilePointer() - 8); // retrocedo 8 posiciones Apuntador
            file.writeDouble(nuevoSalario); //escribo el nuevoSalrio en el fichero
            
            //muestro por pantalla los datos del empleado
            System.out.printf("\nActualización salario: \n\n");
            System.out.printf("\n%-12s%-6s%-10s%-8s\n\n","Apellido","Dept","Salario","Nuevo Salario");
            System.out.printf("%-12s%-6d%.2f   %.2f\n\n", apellidos, dep, salario, nuevoSalario);
//            System.out.printf("Apellidos: %s, Departamento: %d, Salario: %.2f ,Nuevo Salario: %.2f\n", apellidos, dep, salario, nuevoSalario);


        }

        file.close();

    }
}
