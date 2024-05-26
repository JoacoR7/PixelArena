package com.uncuyo.pixelArena.control;

import com.uncuyo.pixelArena.dao.EmpresaDAO;
import com.uncuyo.pixelArena.model.Empresa;
import java.util.List;

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
    
    public String crearEmpresa(String nombre, String email, String numTelefono){
        int numTelefonoInt;
        try {
            numTelefonoInt = Integer.valueOf(numTelefono);
        } catch (Exception e) {
            return "Numero de teléfono inválido";
        }
        empresaDAO.insertar(new Empresa(nombre, email, numTelefonoInt));
        return "Empresa creada exitosamente";
    }
    
    public String modificarEmpresa(String idEmpresa, String nombre, String email, String numTelefono, String estadoEmpresa){
        Empresa empresa = empresaDAO.buscarPorId(Long.parseLong(idEmpresa));
        empresa.setNombre(nombre);
        empresa.setEmail(email);
        empresa.setNumtelefono(Integer.parseInt(numTelefono));
        empresa.setActivo(estadoEmpresa.equals("Activa"));
        empresaDAO.modificar(empresa);
        return "Empresa modificada exitosamente";
    }
    
    public List<Empresa> listarEmpresas(){
        return empresaDAO.listar();
    }
    
}
