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
public class Ej13 {

    /**
     *
     * @param iden
     * @param apellido
     * @param dep
     * @param salario
     * @throws IOException
     */
    public static void insertEmpleado(int iden, String apellido, int dep, double salario) throws IOException {


        File fichero = new File("EmpleAleatorio.dat"); //fichero

        //declara el fichero de acceso aleatorio y modo acceso lectura/escritura
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        int id;
        StringBuffer buffer;
        int lreg = 36; //lreg= longitud o tamaño en bytes del registro
        long posicion = (iden - 1) * lreg;
        //si dentro del rango del fichero existente
        if (posicion < fichero.length() && posicion >= 0) {
            //mueve apuntador del fichero a la posición=(iden-1)*lreg;
            file.seek(posicion);
            id = file.readInt();
            if (id == -1) {

                //hay que reescribir ese id
                file.seek(posicion);
                file.writeInt(iden);
                buffer = new StringBuffer(apellido);
                buffer.setLength(10); //10 caracteres para el apellido
                file.writeChars(buffer.toString()); //insertar apellido
                file.writeInt(dep); //insertar departamento
                file.writeDouble(salario); //insertar salario
                System.out.println("Nuevo registro con ID: " + iden + " creado.");
                file.close();
            } else {
                System.out.println("No se puede escribir. El registro con ID: " + iden + "está ocupado");
            }

        } else {
            //si fuera del rango existente escribimos con -1 el espacio libre.
            //Hay que aumentar el tamaño dle fichero
            while (file.length() < posicion) {
                file.seek(file.length());
                file.writeInt(-1);
                file.seek(file.length() + 32);
            }
            //posicionamos y escribimos el nuevo registro en su posición
            file.seek(posicion);
            file.writeInt(iden);
            buffer = new StringBuffer(apellido);
            buffer.setLength(10); //10 caracteres para el apellido
            file.writeChars(buffer.toString()); //insertar apellido
            file.writeInt(dep); //insertar departamento
            file.writeDouble(salario); //insertar salario
            System.out.println("El registro con ID " + iden + "ha sido creado. Se ha aumentado el tamaño del fichero");
            file.close();
        }



    }
}