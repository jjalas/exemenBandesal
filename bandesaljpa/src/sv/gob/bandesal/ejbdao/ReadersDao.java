package sv.gob.bandesal.ejbdao;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface ReadersDao extends EJBHome {
	ReadersDaoRemote create() throws RemoteException, CreateException;
}
