package sv.gob.bandesal.service;

import java.util.List;


import sv.gob.bandesal.entidades.negocio.Readers;

public interface IReadersSvr {
	 List<Readers> findAll();
	   void guardar(Readers ob);
	   void actualizar(Readers ob);
	   void eliminar(Readers ob);
}
