


package com.uncuyo.pixelArena.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
    
     public Date obtenerFecha(String textoFecha) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Parsear el texto a Date
            Date fecha = formatter.parse(textoFecha);

            // Imprimir la fecha
            return fecha;
        } catch (ParseException e) {
            return null;
        }
    }
     
    public String formatearFecha(String fecha){
        DateTimeFormatter formatterOriginal = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        // Formato de fecha esperado
        DateTimeFormatter formatterNuevo = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            // Parsear la cadena original a LocalDateTime
            LocalDateTime fechaHora = LocalDateTime.parse(fecha, formatterOriginal);

            // Formatear la fecha en el nuevo formato
            String cadenaFormateada = fechaHora.format(formatterNuevo);

            // Imprimir la cadena formateada
            return cadenaFormateada;
        } catch (Exception e) {
            // Manejar el error si la cadena no está en el formato esperado
            return "Error al formatear fecha";
        }
    }

}
