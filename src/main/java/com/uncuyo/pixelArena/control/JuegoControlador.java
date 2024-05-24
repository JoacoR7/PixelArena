package com.uncuyo.pixelArena.control;

import com.uncuyo.pixelArena.dao.JuegoDAO;
import com.uncuyo.pixelArena.model.Empresa;
import com.uncuyo.pixelArena.model.Juego;

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
    
    public Juego buscarJuego(String id){
        if(!existeJuego(id)){
            return null;
        }
        return juegoDAO.buscarPorId(Long.parseLong(id));
    }
    
    public String  modificarJuego(String idJuego, String nombre, String idEmpresa, String estado){
        Juego juego = juegoDAO.buscarPorId(Long.parseLong(idJuego));
        juego.setActivo(estado.equals("Activo"));
        System.out.println(estado);
        if((!nombre.equals("") || !nombre.equals("Ingrese el nombre")) && (!idEmpresa.equals("") || (!idEmpresa.equals("Ingrese el id de la empresa")))){
            Empresa empresa = empresaControlador.buscarEmpresa(idEmpresa);
            if(empresa == null){
                return "No existe la empresa";
            }
            
            juego.setNombre(nombre);
            juego.setEmpresa(empresa);
            juegoDAO.modificar(juego);
            
        } else if(!nombre.equals("") || !nombre.equals("Ingrese el nombre")){
            juegoDAO.modificar(juego);
            
        } else{
            Empresa empresa = empresaControlador.buscarEmpresa(idEmpresa);
            if(empresa == null){
                return "No existe la empresa";
            }
            juego.setEmpresa(empresa);
            juegoDAO.modificar(juego);
        }
        
        return "Juego modificado exitosamente";

    }
}
