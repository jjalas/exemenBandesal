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

import sv.gob.bandesal.entidades.negocio.*;
import sv.gob.bandesal.persistencia.DaoGenerico;
import sv.gob.bandesal.persistencia.DaoGenericoImp;

@SuppressWarnings("unused")
@Stateless
public class BlogDaoImp  implements BlogDao,DaoGenerico<Blogs, Long>{

	@Override
	public EJBMetaData getEJBMetaData() throws RemoteException {
	
		return null;
	}

	@Override
	public HomeHandle getHomeHandle() throws RemoteException {
		
		return null;
	}

	@Override
	public void remove(Handle arg0) throws RemoteException, RemoveException {
		
		
	}

	@Override
	public void remove(Object arg0) throws RemoteException, RemoveException {
	
		
	}



	@Override
	public void Guardar(Blogs t) {
		
		
	}

	

	
	

	

	
	

	

	@Override
	public void Actualizar(Blogs t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Blogs Buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Eliminar(Blogs t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Blogs> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogDaoRemote create() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
    
}
