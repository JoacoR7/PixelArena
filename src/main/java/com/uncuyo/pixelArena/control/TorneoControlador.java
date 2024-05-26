package com.uncuyo.pixelArena.control;

import com.uncuyo.pixelArena.dao.TorneoDAO;
import com.uncuyo.pixelArena.model.Juego;
import com.uncuyo.pixelArena.model.Torneo;
import com.uncuyo.pixelArena.util.DateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TorneoControlador {

    static TorneoDAO torneoDAO = new TorneoDAO();
    static JuegoControlador juegoControlador = new JuegoControlador();
    static DateUtil dateUtil = new DateUtil();

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

    public String crearTorneo(String nombre, String descripcion, String nombreJuego, String textoFechaInicio, String textoFechaFinal, String costo) {
        Juego juegoSeleccionado = juegoControlador.buscarJuegoPorNombre(nombreJuego);
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
        
        Date fechaInicio = dateUtil.obtenerFecha(textoFechaInicio);
        if(fechaInicio == null){
            return "Formato de fecha no válido, use dd/mm/aaaa";
        }
        Date fechaFinal = dateUtil.obtenerFecha(textoFechaFinal);
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
    
    public String modificarTorneo(String id, String nombre, String descripcion, String nombreJuego, String fechaInicioString, String fechaFinalString, String costo){
        Torneo torneo = buscarTorneo(id);
        torneo.setNombreTorneo(nombre);
        torneo.setDescripcionTorneo(descripcion);
        torneo.setJuego(juegoControlador.buscarJuegoPorNombre(nombreJuego));
        Date fechaInicio = dateUtil.obtenerFecha(fechaInicioString);
        if(fechaInicio == null){
            return "Fecha de inicio incorrecta";
        }
        torneo.setFechaInicioTorneo(fechaInicio);
        Date fechaFinal = dateUtil.obtenerFecha(fechaFinalString);
        if(fechaFinal == null){
            return "Fecha de finalización incorrecta";
        }
        torneo.setFechaFinalTorneo(fechaFinal);
        double costoInscripcion;
        try {
            costo = costo.replace(",", ".");
            costoInscripcion = Double.parseDouble(costo);
            torneo.setCostoInscripcionTorneo(costoInscripcion);
        } catch (Exception e) {
            return "El precio de inscripción no está escrito en un formato válido";
        }      
        torneoDAO.modificar(torneo);
        return "Torneo editado exitosamente";
    }
    
    public String borrarTorneo(String id){
        Torneo torneoBorrar = buscarTorneo(id);
        if(torneoBorrar == null){
            return "No existe el torneo";
        }
        torneoDAO.eliminar(torneoBorrar);
        return "Torneo eliminado exitosamente";
    }
    
    public List<Torneo> listarTorneos(){
        return torneoDAO.listar();
    }

}
