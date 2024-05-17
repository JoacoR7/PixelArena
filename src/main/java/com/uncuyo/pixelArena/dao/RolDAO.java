package com.uncuyo.pixelArena.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.uncuyo.pixelArena.model.Rol;
import com.uncuyo.pixelArena.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RolDAO implements DAO<Rol>{
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("Persistencia");
    }
    
    public static void main(String[] args) {
        RolDAO rd = new RolDAO();
        Rol rolmodificar = rd.buscarPorId(2);
        rolmodificar.setRol("Jugador");
        rd.modificar(rolmodificar);
    }

    @Override
    public void insertar(Rol rol) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(rol);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void modificar(Rol rol) {
        EntityManager em = emf.createEntityManager();
        Rol rolModificar = em.find(Rol.class, rol.getId());
        em.getTransaction().begin();
        rolModificar.setRol(rol.getRol());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Rol rol) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Rol rolEliminar = em.find(Rol.class, rol.getId());
            em.remove(rolEliminar);
            em.getTransaction().commit();

        } catch (NullPointerException e) {
            System.out.println("No se encontró el rol");
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            em.close();
        }   
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public Rol buscarPorId(long id) {
        EntityManager em = emf.createEntityManager();
        Rol rol = null;
        try {
            rol = em.find(Rol.class, (int) id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return rol;
    }

    @Override
    @SuppressWarnings("JPQLValidation")
    public List<Rol> listar() {
        EntityManager em = emf.createEntityManager();
        List<Rol> roles = null;
        try {
            roles = em.createQuery("FROM Rol", Rol.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return roles;
    }

}
