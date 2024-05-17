package com.uncuyo.pixelArena.dao;

import com.uncuyo.pixelArena.model.OrganizadorTorneo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OrganizadorTorneoDAO implements DAO<OrganizadorTorneo>{
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("Persistencia");
    }

    @Override
    public void insertar(OrganizadorTorneo organizadorTorneo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        organizadorTorneo.setActivo(true);
        em.persist(organizadorTorneo);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void modificar(OrganizadorTorneo organizadorTorneo) {
        EntityManager em = emf.createEntityManager();
        OrganizadorTorneo organizadorTorneoModificar = em.find(OrganizadorTorneo.class, organizadorTorneo.getLegajo());
        em.getTransaction().begin();
        organizadorTorneoModificar.setNombre(organizadorTorneo.getNombre());
        organizadorTorneoModificar.setApellido(organizadorTorneo.getApellido());
        organizadorTorneoModificar.setEmail(organizadorTorneo.getEmail());
        organizadorTorneoModificar.setNumtel(organizadorTorneo.getNumtel());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(OrganizadorTorneo organizadorTorneo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            OrganizadorTorneo OrganizadorTorneoEliminar = em.find(OrganizadorTorneo.class, organizadorTorneo.getLegajo());
            OrganizadorTorneoEliminar.setActivo(false);
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
    public OrganizadorTorneo buscarPorId(long id) {
        EntityManager em = emf.createEntityManager();
        OrganizadorTorneo organizadorTorneo = null;
        try {
            organizadorTorneo = em.find(OrganizadorTorneo.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return organizadorTorneo;
    }

    @Override
    @SuppressWarnings("JPQLValidation")
    public List<OrganizadorTorneo> listar() {
        EntityManager em = emf.createEntityManager();
        List<OrganizadorTorneo> organizadoresTorneo = null;
        try {
            organizadoresTorneo = em.createQuery("FROM OrganizadorTorneo", OrganizadorTorneo.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return organizadoresTorneo;
    }

}
