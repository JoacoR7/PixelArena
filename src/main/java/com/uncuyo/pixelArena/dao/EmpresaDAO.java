package com.uncuyo.pixelArena.dao;

import com.uncuyo.pixelArena.model.Empresa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmpresaDAO implements DAO<Empresa> {

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("Persistencia");
    }

    @Override
    public void insertar(Empresa empresa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        empresa.setActivo(true);
        em.persist(empresa);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void modificar(Empresa empresa) {
        EntityManager em = emf.createEntityManager();
        Empresa empresaModificar = em.find(Empresa.class, empresa.getId());
        em.getTransaction().begin();
        empresaModificar.setNombre(empresa.getNombre());
        empresaModificar.setEmail(empresa.getEmail());
        empresaModificar.setNumtelefono(empresa.getNumtelefono());
        empresaModificar.setActivo(empresa.isActivo());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Empresa empresa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Empresa empresaEliminar = em.find(Empresa.class, empresa.getId());
            empresaEliminar.setActivo(false);
            em.getTransaction().commit();

        } catch (NullPointerException e) {
            System.out.println("No se encontró la empresa");
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            em.close();
        }   
    }

    @Override
    public Empresa buscarPorId(long id) {
        EntityManager em = emf.createEntityManager();
        Empresa empresa = null;
        try {
            empresa = em.find(Empresa.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return empresa;
    }

    @Override
    public List<Empresa> listar() {
        EntityManager em = emf.createEntityManager();
        List<Empresa> empresas = null;
        try {
            empresas = em.createQuery("FROM Empresa ORDER BY id", Empresa.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return empresas;
    }

}
