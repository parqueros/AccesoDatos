/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ad2_ej6_pabloarqueros;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pabloarqueros
 */


public class FiltroFecha implements FilenameFilter {
    String fechaInicio;
    String fechaFin;
    SimpleDateFormat formatoFecha;

    public FiltroFecha(String fechaInicio, String fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        formatoFecha = new SimpleDateFormat("yyyy.MM.dd");
    }

    @Override
    public boolean accept(File dir, String name) {
        Date d = new Date(new File(dir, name).lastModified());
        String actual = formatoFecha.format(d);
        return ((fechaInicio.compareTo(actual) < 0 
                && (fechaFin.compareTo(actual) >= 0)));
    }
}

