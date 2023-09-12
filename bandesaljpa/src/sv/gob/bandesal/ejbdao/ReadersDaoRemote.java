package sv.gob.bandesal.ejbdao;

import java.util.List;

import javax.ejb.Remote;

import sv.gob.bandesal.entidades.negocio.Readers;
@Remote
public interface ReadersDaoRemote  {
       List<Readers> findAll();
       void guardar(Readers ob);
       void actualizar(Readers ob);
       void eliminar(Readers ob);
       
}
