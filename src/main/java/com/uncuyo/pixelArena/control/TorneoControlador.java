package com.uncuyo.pixelArena.control;

import com.uncuyo.pixelArena.dao.TorneoDAO;
import com.uncuyo.pixelArena.model.Juego;
import com.uncuyo.pixelArena.model.Torneo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TorneoControlador {

    static TorneoDAO torneoDAO = new TorneoDAO();
    static JuegoControlador juegoControlador = new JuegoControlador();

    public boolean existeTorneo(String id) {
        long idTorneo;
        try {
            idTorneo = Long.parseLong(id);
        } catch (Exception e) {
            return false;
        }
        Torneo torneo = torneoDAO.buscarPorId(idTorneo);
        return torneo != null;
    }

    public Torneo buscarTorneo(String id) {
        if (existeTorneo(id)) {
            Torneo torneo = torneoDAO.buscarPorId(Long.parseLong(id));
            return torneo;
        }
        return null;
    }

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

    public String crearTorneo(String nombre, String descripcion, String nombreJuego, String textoFechaInicio, String textoFechaFinal, String costo) {
        Juego juegoSeleccionado = null;
        List<Juego> juegos = juegoControlador.listarJuegos();
        for (Juego juego : juegos) {
            if (juego.getNombre().equals(nombreJuego)) {
                juegoSeleccionado = juego;
                break;
            }
        }
        if (nombre.equals("")) {
            return "Debe elegir un nombre para el torneo";
        }
        if (descripcion.equals("")) {
            return "Debe elegir una descripción para el torneo";
        }
        if(textoFechaInicio.equals("")) {
            return "Debe elegir una fecha de inicio para el torneo";
        }
        if (textoFechaFinal.equals("")) {
            return "Debe elegir una fecha de finalización para el torneo";
        }
        if (costo.equals("")) {
            return "Debe elegir un costo de inscripción del torneo";
        }
        
        Date fechaInicio = obtenerFecha(textoFechaInicio);
        if(fechaInicio == null){
            return "Formato de fecha no válido, use dd/mm/aaaa";
        }
        Date fechaFinal = obtenerFecha(textoFechaFinal);
        if(fechaFinal == null){
            return "Formato de fecha no válido, use dd/mm/aaaa";
        }
        double costoInscripcion;
        try {
            costo = costo.replace(",", ".");
            costoInscripcion = Double.parseDouble(costo);
        } catch (Exception e) {
            return "El precio de inscripción no está escrito en un formato válido";
        }
        Torneo torneo = new Torneo(nombre, descripcion, fechaInicio, fechaFinal, costoInscripcion, juegoSeleccionado);
        torneoDAO.insertar(torneo);
        return "Torneo creado exitosamente";
    }

}
