package sv.gob.bandesal.persistencia;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;



import org.springframework.beans.factory.annotation.Autowired;

import sv.gob.bandesal.util.*;

public class DaoGenericoImp<Entity, K extends Serializable> implements DaoGenerico<Entity, K> {

	 @SuppressWarnings("unchecked")
	public Class<Entity> domainClass = getDomainClass();
	 private String clazz;  
	 private EntityManager session=null;
	
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	protected Class getDomainClass() {
	   if (domainClass == null) {
	   ParameterizedType thisType = (ParameterizedType) getClass()
	     .getGenericSuperclass();
	   domainClass = (Class) thisType.getActualTypeArguments()[0];
	   }
	   clazz = domainClass.toString();
	   clazz = clazz.replaceAll("class", "");
	
	  return domainClass;
	 }
	
	
	 @Autowired(required = false)
	public void  Guardar(Entity t) {
		 session=PersistenceListener.createEntityManager();
	
		try{
			session.getTransaction().begin();
			session.persist(t);
			session.getTransaction().commit();
	     
		}catch(HibernateException he){
			he.printStackTrace();
		
		}finally{
			  session.close();
		  }
	}

	@Autowired
	public void Actualizar(Entity t) {
		session=PersistenceListener.createEntityManager();

		try{
			session.getTransaction().begin();
			session.merge(t);
			session.getTransaction().commit();
		}catch(HibernateException he){
			he.printStackTrace();
		}finally{
			  session.close();
		  }
	}

	@Autowired
	public Entity Buscar(K id) {
		
		return null;
	}

	@Autowired
	public void Eliminar(Entity t) {
		session=PersistenceListener.createEntityManager();

	  try{
		session.getTransaction().begin();
	    session.remove(session.contains(t) ? t : session.merge(t));
		session.getTransaction().commit();
		}catch(HibernateException he){
			
			//he.printStackTrace();
		}catch (javax.validation.ConstraintViolationException cve){
			
		}catch (RuntimeException ex){
			
			throw new RuntimeException(ex);
		}finally{
			  session.close();
		  }
	}

	@SuppressWarnings("unchecked")
	@Autowired
	public List<Entity> findAll() {
		session=PersistenceListener.createEntityManager();
	  try{	

	    return  session.createQuery("from " + clazz ).getResultList();
	  }catch(HibernateException e){
		  e.printStackTrace();
		  return null;
	  }finally{
		  session.close();
	  }
	     
	    	
	    
	}
	
	public void closeSession(){
		try{
			if(session.isOpen()){
				session.close();
				session=null;
			}
		}catch(Exception e){
			
		}
	}

}
