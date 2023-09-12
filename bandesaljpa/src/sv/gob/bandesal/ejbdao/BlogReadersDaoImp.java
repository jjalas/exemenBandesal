package sv.gob.bandesal.ejbdao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.gob.bandesal.entidades.negocio.BlogsReaders;
import sv.gob.bandesal.util.PersistenceListener;
@Stateless
public class BlogReadersDaoImp implements BlogReaderDao {
	EntityManager session=null;
	List<BlogsReaders> res=null; 
	@SuppressWarnings("unchecked")
	@Override
	public List<BlogsReaders> findAll() {
		try{
			 session=PersistenceListener.createEntityManager();
			 Query q = session.createNamedQuery("BlogsReaders.findAll");
			 res = q.getResultList();
		}catch(Exception e){
			 
			e.printStackTrace();;
		 }finally{
			 session.close();
		 }	 
		return res;
	}

	@Override
	public void guardar(BlogsReaders ob) {
		try{
			 session=PersistenceListener.createEntityManager();
			 session.getTransaction().begin();
			 session.persist(ob);
			 session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();;
		 }finally{
			 session.close();
		 }	

	}

	@Override
	public void actualizar(BlogsReaders ob) {
		try{
			 session=PersistenceListener.createEntityManager();
			 session.getTransaction().begin();
			 session.merge(ob);
			 session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();;
		 }finally{
			 session.close();
		 }	
	}

	@Override
	public void eliminar(BlogsReaders ob) {
		try{
			 session=PersistenceListener.createEntityManager();
			 session.getTransaction().begin();
			 session.remove(session.contains(ob) ? ob : session.merge(ob));
			 session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();;
		 }finally{
			 session.close();
		 }	

	}

}
