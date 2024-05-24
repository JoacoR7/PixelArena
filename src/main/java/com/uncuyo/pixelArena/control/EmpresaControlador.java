package com.uncuyo.pixelArena.control;

import com.uncuyo.pixelArena.dao.EmpresaDAO;
import com.uncuyo.pixelArena.model.Empresa;

public class EmpresaControlador {
    
    static EmpresaDAO empresaDAO = new EmpresaDAO();

    public boolean existeEmpresa(String id){
        long idEmpresa;
        try {
            idEmpresa = Long.parseLong(id);
        } catch (Exception e) {
            return false;
        }
        Empresa empresa = empresaDAO.buscarPorId(idEmpresa);
        return empresa != null;
    }
    
    public Empresa buscarEmpresa(String id){
        if(existeEmpresa(id)){
            Empresa empresa = empresaDAO.buscarPorId(Long.parseLong(id));
            return empresa;
        }
        return null;
    }
    
}
