package com.uncuyo.pixelArena.control;

import com.uncuyo.pixelArena.dao.JuegoDAO;
import com.uncuyo.pixelArena.model.Empresa;
import com.uncuyo.pixelArena.model.Juego;
import java.util.List;

public class JuegoControlador {
    
      
    static EmpresaControlador empresaControlador = new EmpresaControlador();
    static JuegoDAO juegoDAO = new JuegoDAO();
    
    public JuegoControlador() {
        juegoDAO = new JuegoDAO();
    }
    
    public String crearJuego(String nombreJuego, String idEmpresa){
       if(!empresaControlador.existeEmpresa(idEmpresa)){
           return "No existe la empresa";
       }else {
           juegoDAO.insertar(new Juego(nombreJuego, empresaControlador.buscarEmpresa(idEmpresa)));
       }
        
        return "Juego creado exitosamente";                
    }
    
    public String borrarJuego(String idJuego){
        if(!existeJuego(idJuego)){
            return "El juego no existe";
        } else {
            juegoDAO.eliminar(juegoDAO.buscarPorId(Long.parseLong(idJuego)));
            return "Juego eliminado exitosamente";
        }
    }
    
    public boolean existeJuego(String id){
        long idJuego;
        try {
            idJuego = Long.parseLong(id);
        } catch (Exception e) {
            return false;
        }
        Juego juego = juegoDAO.buscarPorId(idJuego);
        return juego != null;
    }
    
    public Juego buscarJuegoPorId(String id){
        if(!existeJuego(id)){
            return null;
        }
        return juegoDAO.buscarPorId(Long.parseLong(id));
    }
    
    public Juego buscarJuegoPorNombre(String nombre){
        Juego juegoSeleccionado = null;
        List<Juego> juegos = listarJuegos();
        for (Juego juego : juegos) {
            if (juego.getNombre().equals(nombre)) {
                juegoSeleccionado = juego;
                break;
            }
        }
        return juegoSeleccionado;
    }
    
    public String  modificarJuego(String idJuego, String nombre, String idEmpresa, String estado){
        Empresa empresa = empresaControlador.buscarEmpresa(idEmpresa);
        if(empresa == null){
            return "No existe la empresa";
         }
        Juego juego = juegoDAO.buscarPorId(Long.parseLong(idJuego));
        juego.setActivo(estado.equals("Activo"));
        juego.setNombre(nombre);
        juego.setEmpresa(empresa);
        juegoDAO.modificar(juego);
        return "Juego modificado exitosamente";

    }
    
    public List<Juego> listarJuegos(){
        List<Juego> juegos;
        juegos = juegoDAO.listar();
        return juegos;
    }
}
