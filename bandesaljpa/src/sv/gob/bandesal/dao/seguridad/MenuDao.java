package sv.gob.bandesal.dao.seguridad;

import java.util.List;



import sv.gob.bandesal.entidades.seguridad.Menu;
import sv.gob.bandesal.persistencia.*;




public interface MenuDao extends DaoGenerico<Menu, Long> {
	public List<Menu> getByRol(int idrol);
	public List<Menu> getSubmenu(int idp, int idrol);
	public List<Menu> listarMenu();
}
