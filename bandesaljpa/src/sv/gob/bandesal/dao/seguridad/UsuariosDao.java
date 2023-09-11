package sv.gob.bandesal.dao.seguridad;


import sv.gob.bandesal.entidades.seguridad.Usuarios;
import sv.gob.bandesal.persistencia.DaoGenerico;



public interface UsuariosDao extends DaoGenerico<Usuarios, Long> {
	    Usuarios getUsuarioByUser(String user);
	    Usuarios getUsuariosById(int iduser);
}
