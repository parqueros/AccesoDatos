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
public class Ej12 {

    /**
     *
     * @param numEmpleado
     * @throws IOException
     */
    
    public static void eliminaRegistro(int numEmpleado) throws IOException {
        File fichero = new File("EmpleAleatorio.dat"); //fichero

        //declara el fichero de acceso aleatorio y modo acceso lectura/escritura
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        int id, iden = numEmpleado; //id del empleado a eliminar
        int lreg = 36; //lreg= longitud o tamaño en bytes del registro
        long posicion = (iden - 1) * lreg;
        //si dentro del rango del fichero existente
        if (posicion < fichero.length() && posicion >= 0) {
        //mueve apuntador del fichero a la posición=(iden-1)*lreg;
            file.seek(posicion);
            id = file.readInt();
            if (id != -1) {
                id = -1; //marcamos como borrado lógico
                    //hay que reescribir ese id
                file.seek(posicion);
                file.writeInt(id);
                System.out.println("Eliminando empleado: " + iden);
            } else {
                System.out.println("no existe el empleado: " + iden);
            }
        }

    }
    
    
}
