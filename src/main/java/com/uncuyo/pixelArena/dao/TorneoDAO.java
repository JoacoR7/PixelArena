package com.uncuyo.pixelArena.dao;

import com.uncuyo.pixelArena.model.Juego;
import com.uncuyo.pixelArena.model.Torneo;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TorneoDAO implements DAO<Torneo>{
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("Persistencia");
    }
    
    public static void main(String[] args) {
        TorneoDAO td = new TorneoDAO();
        td.eliminar(td.buscarPorId(2));
        
    }

    @Override
    public void insertar(Torneo torneo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        torneo.setActivo(true);
        em.persist(torneo);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void modificar(Torneo torneo) {
        EntityManager em = emf.createEntityManager();
        Torneo  torneoModificar = em.find(Torneo.class, torneo.getNumTorneo());
        em.getTransaction().begin();
        torneoModificar.setNombreTorneo(torneo.getNombreTorneo());
        torneoModificar.setDescripcionTorneo(torneo.getDescripcionTorneo());
        torneoModificar.setFechaFinalTorneo(torneo.getFechaFinalTorneo());
        torneoModificar.setFechaFinalTorneo(torneo.getFechaFinalTorneo());
        torneoModificar.setCostoInscripcionTorneo(torneo.getCostoInscripcionTorneo());
        torneoModificar.setJuego(torneo.getJuego());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Torneo torneo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Torneo torneoEliminar = em.find(Torneo.class, torneo.getNumTorneo());
            torneoEliminar.setActivo(false);
            em.getTransaction().commit();

        } catch (NullPointerException e) {
            System.out.println("No se encontró al organizador de torneos");
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            em.close();
        }   
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public Torneo buscarPorId(long id) {
        EntityManager em = emf.createEntityManager();
        Torneo torneo = null;
        try {
            torneo = em.find(Torneo.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return torneo;
    }

    @Override
    @SuppressWarnings("JPQLValidation")
    public List<Torneo> listar() {
        EntityManager em = emf.createEntityManager();
        List<Torneo> torneos = null;
        try {
            torneos = em.createQuery("FROM Torneo", Torneo.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return torneos;
    }

}

