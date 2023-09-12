package sv.gob.bandesal.ejbdao;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBMetaData;
import javax.ejb.Handle;
import javax.ejb.HomeHandle;
import javax.ejb.RemoveException;
import javax.ejb.Stateless;
import javax.ejb.EJBHome;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.gob.bandesal.entidades.negocio.*;
import sv.gob.bandesal.persistencia.DaoGenerico;
import sv.gob.bandesal.persistencia.DaoGenericoImp;
import sv.gob.bandesal.util.PersistenceListener;

@SuppressWarnings("unused")
@Stateless
public class BlogDaoImp  implements BlogDao{
	EntityManager session=null;
	List<Blogs> res=null; 
	@Override
	public void Guardar(Blogs t) {
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

	@Override
	public void Actualizar(Blogs t) {
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

	@Override
	
	
public Blogs findById(int id) {
		Blogs blog=null;
		try{
			 session=PersistenceListener.createEntityManager();
			 Query q = session.createNamedQuery("Blogs.findById");
			 q.setParameter("id", id);
			 res = q.getResultList();
			 if (!res.isEmpty()){
				blog = res.get(0); 
			 }
		}catch(Exception e){
			 
			e.printStackTrace();;
		 }finally{
			 session.close();
		 }	 
		return blog;
	}

	@Override
	public void Eliminar(Blogs t) {
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
	@Override
	public List<Blogs> findAll() {
		try{
			 session=PersistenceListener.createEntityManager();
			 Query q = session.createNamedQuery("Blogs.findAll");
			 res = q.getResultList();
		}catch(Exception e){
			 
			e.printStackTrace();;
		 }finally{
			 session.close();
		 }	 
		return res;
	}

	@Override
	public BlogDaoRemote create() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blogs Buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	
    
}
