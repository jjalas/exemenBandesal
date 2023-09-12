package sv.gob.bandesal.ejbdao;

import java.rmi.RemoteException;

import javax.ejb.EJBHome;
import javax.ejb.Local;

import sv.gob.bandesal.entidades.negocio.Blogs;
import sv.gob.bandesal.persistencia.DaoGenerico;


@SuppressWarnings("unused")
@Local
public interface BlogDao extends DaoGenerico<Blogs, Long>{
  public  BlogDaoRemote create() throws RemoteException;

Blogs findById(int id);
  
 
}
