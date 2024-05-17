package testing;

//import com.uncuyo.dbapp.model.Domicilio;
//import com.uncuyo.dbapp.model.Empleado;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Test {
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");;
    
    public static void main(String[] args) {
        /*Crear el gestor de persistencia*/
        EntityManager man=emf.createEntityManager();
        man.getTransaction().begin();
        //Empleado e = new Empleado(26L, "Forges","Franco", new GregorianCalendar(1979,6,6).getTime());
        //e.setDomicilio(new Domicilio(11L,"Calle Fake, 123","Mendoza", "Mendoza","Argentin"));
        //man.persist(e);
        man.getTransaction().commit();
        //imprimirTodo();
        man.close(); //Para evitar que queden usuarios en memoria sin persistir.
    }
    
    /*
    private static void update(Empleado enew){
        EntityManager man = emf.createEntityManager();        
        Empleado e = man.find(Empleado.class,enew.getCodigo());
        man.getTransaction().begin();
        e.setNombre(enew.getNombre());
        man.getTransaction().commit();
        man.close();
    }
    
    private static void remove(Empleado edel){
        EntityManager man = emf.createEntityManager();
        man.getTransaction().begin();
        Empleado e = man.find(Empleado.class,edel.getCodigo());
        man.remove(e);
        man.getTransaction().commit();
        man.close();
    }
    
    private static void insertEmpleado(){
        EntityManager man = emf.createEntityManager();
        long cod;
        cod = (long)Math.random();
        Empleado e = new Empleado(cod,"Pérez","Pepito", new GregorianCalendar(1979,6,6).getTime());
        man.getTransaction().begin();
        man.persist(e);
        e.setApellidos("López");        
        man.getTransaction().commit();
        man.close();
    }
    private static void imprimirTodo(){
        EntityManager man = emf.createEntityManager();
        List<Empleado> empleados= (List<Empleado>) man.createQuery("From Empleado").getResultList();
        System.out.println("En esta base de datos hay "+empleados.size()+" empleados");
        for(Empleado emp : empleados){
            System.out.println(emp.toString());
        }
        man.close();
    }*/
}