package com.uncuyo.pixelArena.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.uncuyo.pixelArena.model.OrganizadorTorneo;
import com.uncuyo.pixelArena.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioDAO implements DAO<Usuario>{
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("Persistencia");
    }

    @Override
    public void insertar(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void modificar(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        Usuario usuarioModificar = em.find(Usuario.class, usuario.getId());
        em.getTransaction().begin();
        usuarioModificar.setNombre(usuario.getNombre());
        usuarioModificar.setEmail(usuario.getEmail());
        usuarioModificar.setPassword(usuario.getPassword());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Usuario usuarioEliminar = em.find(Usuario.class, usuario.getId());
            em.remove(usuarioEliminar);
            em.getTransaction().commit();

        } catch (NullPointerException e) {
            System.out.println("No se encontró al usuario");
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            em.close();
        }   
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public Usuario buscarPorId(long id) {
        EntityManager em = emf.createEntityManager();
        Usuario usuario = null;
        try {
            usuario = em.find(Usuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return usuario;
    }

    @Override
    @SuppressWarnings("JPQLValidation")
    public List<Usuario> listar() {
        EntityManager em = emf.createEntityManager();
        List<Usuario> usuarios = null;
        try {
            usuarios = em.createQuery("FROM Usuario", Usuario.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return usuarios;
    }

}

