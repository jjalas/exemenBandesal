package sv.gob.bandesal.ejbdao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.gob.bandesal.entidades.negocio.Blogs;
import sv.gob.bandesal.entidades.negocio.Readers;
import sv.gob.bandesal.util.PersistenceListener;

@Stateless
public class ReadersDaoImp implements ReadersDao {

	EntityManager session=null;
	List<Readers> res=null; 
	public void Guardar(Readers t) {
		try{
			 session=PersistenceListener.createEntityManager();
			 session.getTransaction().begin();
			 session.persist(t);
			 session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();;
		 }finally{
			 session.close();
		 }	
		
		
	}

	public void Actualizar(Readers t) {
		try{
			 session=PersistenceListener.createEntityManager();
			 session.getTransaction().begin();
			 session.merge(t);
			 session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();;
		 }finally{
			 session.close();
		 }	
		
	}

	
    public Readers findById(int id){
		
    	Readers reader=null;
    	
    	try{
			 session=PersistenceListener.createEntityManager();
			 Query q = session.createNamedQuery("Readers.findById");
			 q.setParameter("id", id);
			 res = q.getResultList();
			 /* aca pude utilizar getSingleResult pero no siempre retorna correctamente */
			if (!res.isEmpty()){
				reader = res.get(0);
			}
		}catch(Exception e){
			 
			e.printStackTrace();;
		 }finally{
			 session.close();
		 }	
    	return reader;
    }
	public void Eliminar(Readers t) {
		try{
			 session=PersistenceListener.createEntityManager();
			 session.getTransaction().begin();
			 session.remove(session.contains(t) ? t : session.merge(t));
			 session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();;
		 }finally{
			 session.close();
		 }	
		
	}

	@SuppressWarnings("unchecked")
	public List<Readers> findAll() {
		try{
			 session=PersistenceListener.createEntityManager();
			 Query q = session.createNamedQuery("Readers.findAll");
			 res = q.getResultList();
			 System.out.println("res "+res.size());
		}catch(Exception e){
			 
			e.printStackTrace();;
		 }finally{
			 session.close();
		 }	 
		return res;
	}
	

}
