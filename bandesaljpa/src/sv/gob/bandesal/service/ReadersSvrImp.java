package sv.gob.bandesal.service;

import java.util.List;

import javax.ejb.EJB;

import sv.gob.bandesal.ejbdao.ReadersDaoImp;
import sv.gob.bandesal.entidades.negocio.Readers;

public class ReadersSvrImp implements IReadersSvr {
	@EJB
	ReadersDaoImp readdao = new ReadersDaoImp();
	@Override
	public List<Readers> findAll() {
	  
		return readdao.findAll();
	}

	@Override
	public void guardar(Readers ob) {
		readdao.Guardar(ob);
	}

	@Override
	public void actualizar(Readers ob) {
		readdao.Actualizar(ob);

	}

	@Override
	public void eliminar(Readers ob) {
		readdao.Eliminar(ob);

	}

	@Override
	public Readers findById(int id) {
		
		return readdao.findById(id);
	}

}
