package sv.gob.bandesal.dao.seguridad;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.gob.bandesal.entidades.seguridad.Usuarios;
import sv.gob.bandesal.persistencia.DaoGenericoImp;
import sv.gob.bandesal.util.PersistenceListener;


public class UsuariosDaoImp extends DaoGenericoImp<Usuarios, Long> implements UsuariosDao {
	EntityManager session=null;
	List<Usuarios> userl=null;
	@SuppressWarnings("unchecked")
	@Override
	public Usuarios getUsuarioByUser(String user) {
		Usuarios us = null;
		String sql ="from Usuarios u where u.login=:user";
		
		try{
			 session=PersistenceListener.createEntityManager();
			Query q = session.createQuery(sql);
			q.setParameter("user",user);
			userl = q.getResultList();
			if (!userl.isEmpty()){
				us = userl.get(0);
			}
		}catch(Exception e){
			 
			e.printStackTrace();;
		 }finally{
		  if(session.isOpen()){	
			 session.close();
		  }
		 }		
		return us;
	}
	@Override
	public Usuarios getUsuariosById(int iduser) {
		Usuarios us = null;
		try{
			 session=PersistenceListener.createEntityManager();
			Query q = session.createNamedQuery("Usuarios.findByIdUsuario");
			q.setParameter("idUsuario",iduser);
			userl = q.getResultList();
			if (!userl.isEmpty()){
				us = userl.get(0);
			}
		}catch(Exception e){
			 
			e.printStackTrace();;
		 }finally{
			 session.close();
		 }		
		return us;
		
	}

}
