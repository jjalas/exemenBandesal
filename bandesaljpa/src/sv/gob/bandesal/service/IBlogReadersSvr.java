package sv.gob.bandesal.service;

import java.util.List;

import javax.ejb.Local;

import sv.gob.bandesal.entidades.negocio.BlogsReaders;

@Local
public interface IBlogReadersSvr {
	 List<BlogsReaders> findAll();
     void guardar(BlogsReaders ob);
     void actualizar(BlogsReaders ob);
     void eliminar(BlogsReaders ob);
     
}
