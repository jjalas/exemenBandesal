package sv.gob.bandesal.ejbdao;


import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.EJBMetaData;
import javax.ejb.Handle;
import javax.ejb.HomeHandle;
import javax.ejb.RemoveException;
import javax.ejb.Stateless;

import sv.gob.bandesal.entidades.negocio.Readers;
import sv.gob.bandesal.persistencia.DaoGenerico;

@Stateless
public class ReadersDaoImp implements ReadersDao,DaoGenerico<Readers, Long> {

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
	public void Guardar(Readers t) {
		
		
	}

	@Override
	public void Actualizar(Readers t) {
		
		
	}

	@Override
	public Readers Buscar(Long id) {
	
		return null;
	}

	@Override
	public void Eliminar(Readers t) {
		
		
	}

	@Override
	public List<Readers> findAll() {
		
		return null;
	}

	@Override
	public ReadersDaoRemote create() throws RemoteException, CreateException {
		return null;
	}

	

/*	@Override
	public ReadersDaoImp create() throws RemoteException {
		
		return null;
	}*/

	

}
