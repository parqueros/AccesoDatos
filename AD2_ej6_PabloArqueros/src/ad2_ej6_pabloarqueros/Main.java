/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ad2_ej6_pabloarqueros;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pabloarqueros
 */
public class Main {
    
    
    public static void main(String[] args) {
        System.out.println("Lista ficheros modificados entre dos fechas en un directorio dado\n");
        
        String fechaInicio=ES.leeDeTeclado("Introduzca la fecha de inicio...(Formato yyyy.MM.dd)");
        String fechaFin=ES.leeDeTeclado("Introduzca la fecha de fin...(Formato yyyy.MM.dd)");
        String directorio=ES.leeDeTeclado("Introduzca la ruta del directorio...");
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy.MM.dd");
        FiltroFecha filter = new FiltroFecha(fechaInicio, fechaFin);
        File dir =  new File(directorio);
        
//        FiltroFecha filter = new FiltroFecha("2013.06.01", "2013.09.31");
//        File dir =  new File("/Users/pabloarqueros");
        
        File files[] = dir.listFiles(filter);
        for (File f : files) {
            System.out.printf("%-20s %-10s\n",f.getName(),formatoFecha.format(new Date(f.lastModified())));
        }
    }
}

