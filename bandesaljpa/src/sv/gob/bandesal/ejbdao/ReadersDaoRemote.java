package sv.gob.bandesal.ejbdao;

import java.util.List;

import javax.ejb.EJBObject;

import sv.gob.bandesal.entidades.negocio.Readers;

public interface ReadersDaoRemote extends EJBObject {
       List<Readers> findAll();
       void guardar(Readers ob);
       void actualizar(Readers ob);
       void eliminar(Readers ob);
       
}
