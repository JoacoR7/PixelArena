package com.uncuyo.pixelArena.dao;

import com.uncuyo.pixelArena.model.Juego;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JuegoDAO implements DAO<Juego> {

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("Persistencia");
    }

    @Override
    public void insertar(Juego juego) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(juego);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void modificar(Juego juego) {
        EntityManager em = emf.createEntityManager();
        Juego juegoModificar = em.find(Juego.class, juego.getId());
        em.getTransaction().begin();
        juegoModificar.setNombre(juego.getNombre());
        juegoModificar.setEmpresa(juego.getEmpresa());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Juego juego) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Juego juegoEliminar = em.find(Juego.class, juego.getId());
            juegoEliminar.setActivo(false);
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
    public Juego buscarPorId(long id) {
        EntityManager em = emf.createEntityManager();
        Juego juego = null;
        try {
            juego = em.getReference(Juego.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return juego;
    }

    @Override
    public List<Juego> listar() {
        EntityManager em = emf.createEntityManager();
        List<Juego> juegos = null;
        try {
            juegos = em.createQuery("FROM Juego", Juego.class).getResultList();
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

