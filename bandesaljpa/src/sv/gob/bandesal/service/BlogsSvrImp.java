package sv.gob.bandesal.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sv.gob.bandesal.ejbdao.BlogDaoImp;
import sv.gob.bandesal.entidades.negocio.Blogs;


public class BlogsSvrImp implements IBlogsSvr {
    @EJB
	BlogDaoImp blda = new BlogDaoImp();
    
	@Override
	public List<Blogs> findAll() {
		
		return blda.findAll();
	}

	@Override
	public void guardar(Blogs ob) {
		blda.Guardar(ob);

	}

	@Override
	public void actualizar(Blogs ob) {
		blda.Actualizar(ob);

	}

	@Override
	public void eliminar(Blogs ob) {
		blda.Eliminar(ob);

	}

	@Override
	public Blogs findById(int id) {
		
		return blda.findById(id);
	}

}
