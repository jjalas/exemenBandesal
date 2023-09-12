package sv.gob.bandesal.ejbdao;

import java.util.List;

import javax.ejb.Local;

import sv.gob.bandesal.entidades.negocio.BlogsReaders;

@Local
public interface BlogReaderDao {
     List<BlogsReaders> findAll();
     void guardar(BlogsReaders ob);
     void actualizar(BlogsReaders ob);
     void eliminar(BlogsReaders ob);
}
