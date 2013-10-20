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
public class Ej10 {



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
        while (file.getFilePointer() < file.length() - 36) { /*con while */
            //for(;;){
            file.seek(posicion); //apuntador de fichero se sitúa en posicion
            id = file.readInt(); //obtener id de empleado
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();//recorremos uno a uno los caracteres del apellido
                apellido[i] = aux; //los voy guardando en el array
            }
            String apellidos = new String(apellido); //convierto a String el array 
            dep = file.readInt(); //obtengo dep
            salario = file.readDouble(); //obtengo salario

            //  CAMBIAR POR UN PRINTF
            System.out.println("ID: " + id + ", Apellido: " + apellidos
                    + ", Departamento: " + dep + ", Salario:" + salario);
            posicion += 36; //cada empleado ocupa 36 bytes (4+20+4+8)
            //if(file.getFilePointer() == file.length()) break; //sale del bucle
            file.seek(posicion); /*con while */
        }

        file.close(); //cerrar fichero


    }

    public static void buscaEmpleado(int numEmpleado) throws IOException {

        File fichero = new File("EmpleAleatorio.dat");
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        int posicion = (numEmpleado - 1) * 36; //calculo donde empieza el registro
        if (posicion > file.length() || posicion < 0) {
            System.out.println("El empleado con ID: " + numEmpleado + " no existe...");
        } else {

            file.seek(posicion);
            posicion = file.readInt();
            char apellido[] = new char[10], aux;
            int dep;
            Double salario;

            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();//recorremos uno a uno los caracteres del apellido
                apellido[i] = aux; //los voy guardando en el array
            }
            String apellidos =
                    new String(apellido); //convierto aString el array 
            dep = file.readInt(); //obtengo dep
            salario = file.readDouble(); //obtengo salario

            System.out.println("El empleado buscado es: \n");

            System.out.printf("Apellidos: %s, Departamento: %d, Salario: %.2f\n", apellidos, dep, salario);
            posicion += 40; //cada empleado ocupa 36 bytes (4+20+4+8)
            //if(file.getFilePointer() == file.length()) break; //sale del bucle
            file.seek(posicion); /*con while */

        }

        file.close();
    }
}
