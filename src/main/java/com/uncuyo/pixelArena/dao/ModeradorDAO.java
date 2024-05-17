package com.uncuyo.pixelArena.dao;

import com.uncuyo.pixelArena.model.Moderador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ModeradorDAO implements DAO<Moderador> {

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("Persistencia");
    }

    @Override
    public void insertar(Moderador moderador) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(moderador);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void modificar(Moderador moderador) {
        EntityManager em = emf.createEntityManager();
        Moderador moderadorModificar = em.find(Moderador.class, moderador.getLegajo());
        em.getTransaction().begin();
        moderadorModificar.setNombre(moderador.getNombre());
        moderadorModificar.setApellido(moderador.getApellido());
        moderadorModificar.setEmail(moderador.getEmail());
        moderadorModificar.setNombreUsuario(moderador.getNombreUsuario());
        moderadorModificar.setPass(moderador.getPass());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Moderador moderador) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Moderador moderadorEliminar = em.find(Moderador.class, moderador.getLegajo());
            moderadorEliminar.setActivo(false);
            em.getTransaction().commit();

        } catch (NullPointerException e) {
            System.out.println("No se encontró al moderador");
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            em.close();
        }   
    }

    @Override
    public Moderador buscarPorId(long id) {
        EntityManager em = emf.createEntityManager();
        Moderador moderador = null;
        try {
            moderador = em.find(Moderador.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return moderador;
    }

    @Override
    public List<Moderador> listar() {
        EntityManager em = emf.createEntityManager();
        List<Moderador> moderadores = null;
        try {
            moderadores = em.createQuery("FROM Moderador", Moderador.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return moderadores;
    }
}

