package com.uncuyo.pixelArena.dao;

import com.uncuyo.pixelArena.model.Premio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PremioDAO implements DAO<Premio> {

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("Persistencia");
    }

    @Override
    public void insertar(Premio premio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(premio);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void modificar(Premio premio) {
        EntityManager em = emf.createEntityManager();
        Premio premioModificar = em.find(Premio.class, premio.getId());
        em.getTransaction().begin();
        premioModificar.setNombre(premio.getNombre());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Premio premio) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Premio premioEliminar = em.find(Premio.class, premio.getId());
            em.remove(premioEliminar);
            em.getTransaction().commit();

        } catch (NullPointerException e) {
            System.out.println("No se encontró el juego");
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            em.close();
        }   
    }

    @Override
    public Premio buscarPorId(long id) {
        EntityManager em = emf.createEntityManager();
        Premio premio = null;
        try {
            premio = em.find(Premio.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return premio;
    }

    @Override
    public List<Premio> listar() {
        EntityManager em = emf.createEntityManager();
        List<Premio> juegos = null;
        try {
            juegos = em.createQuery("FROM Premio", Premio.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return juegos;
    }
}

