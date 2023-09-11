package sv.gob.bandesal.seguridad.servicios;

import java.util.List;

import sv.gob.bandesal.entidades.seguridad.Usuarios;



public interface IUsuariosSvr {
	public Usuarios getUsuarioByUser(String user);
	void guardar(Usuarios us);
	void actualizar(Usuarios us);
	List<Usuarios> findAll();
	public Usuarios getUsuariosById(int iduser);
}
