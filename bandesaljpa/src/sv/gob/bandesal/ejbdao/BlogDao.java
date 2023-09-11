package sv.gob.bandesal.ejbdao;

import java.rmi.RemoteException;

import javax.ejb.EJBHome;

import sv.gob.bandesal.entidades.negocio.Blogs;


@SuppressWarnings("unused")
public interface BlogDao extends EJBHome {
  public  BlogDaoRemote create() throws RemoteException;
  
  
}
