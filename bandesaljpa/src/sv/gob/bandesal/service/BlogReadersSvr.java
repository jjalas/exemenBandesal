package sv.gob.bandesal.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sv.gob.bandesal.ejbdao.BlogReadersDaoImp;
import sv.gob.bandesal.entidades.negocio.BlogsReaders;
@Stateless
public class BlogReadersSvr implements IBlogReadersSvr {
    @EJB
    BlogReadersDaoImp brdao = new BlogReadersDaoImp();
	@Override
	public List<BlogsReaders> findAll() {
		
		return brdao.findAll();
	}

	@Override
	public void guardar(BlogsReaders ob) {
		brdao.guardar(ob);

	}

	@Override
	public void actualizar(BlogsReaders ob) {
		brdao.actualizar(ob);

	}

	@Override
	public void eliminar(BlogsReaders ob) {
		brdao.eliminar(ob);

	}

}
