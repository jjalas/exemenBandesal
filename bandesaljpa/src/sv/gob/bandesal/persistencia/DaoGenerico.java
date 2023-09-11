package sv.gob.bandesal.persistencia;

import java.io.Serializable;
import java.util.List;
/**
 * @author jj
 * @version 1.0 2015
 * Interface dao de tipo generico 
 * 
 * 
 */
public interface DaoGenerico<Entity, PK extends Serializable> {
	  void Guardar(Entity t);
	  void Actualizar(Entity t);
	  Entity Buscar(PK id);
	  void Eliminar(Entity t);
	  List<Entity>  findAll();

}
