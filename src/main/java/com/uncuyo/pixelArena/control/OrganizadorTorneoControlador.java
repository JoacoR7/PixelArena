package com.uncuyo.pixelArena.control;

import com.uncuyo.pixelArena.dao.OrganizadorTorneoDAO;
import com.uncuyo.pixelArena.model.OrganizadorTorneo;

public class OrganizadorTorneoControlador {
    
    static OrganizadorTorneoDAO organizadorTorneoDAO = new OrganizadorTorneoDAO();
    
    public OrganizadorTorneo buscarPorEmail(String email){
        OrganizadorTorneo organizadorTorneo =  organizadorTorneoDAO.buscarPorEmail(email);
        return organizadorTorneo;
    }
    
    public boolean login(String email, String pass){
        OrganizadorTorneo organizadorTorneo = buscarPorEmail(email);
        if(organizadorTorneo == null){
            return false;
        }
        return organizadorTorneo.getPassword().equals(pass);
    }
}
