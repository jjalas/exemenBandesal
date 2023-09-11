package sv.gob.bandesal.seguridad.servicios;

import java.io.Serializable;
import java.util.List;

import sv.gob.bandesal.dao.seguridad.UsuariosDaoImp;
import sv.gob.bandesal.entidades.seguridad.Usuarios;



public class UsuariosSvr implements IUsuariosSvr,Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UsuariosDaoImp udao = new UsuariosDaoImp();
	@Override
	public Usuarios getUsuarioByUser(String user) {
		
		return udao.getUsuarioByUser(user);
	}
	@Override
	public void guardar(Usuarios us) {
		udao.Guardar(us);
		
	}
	@Override
	public void actualizar(Usuarios us) {
		udao.Actualizar(us);
		
	}
	@Override
	public List<Usuarios> findAll() {
	
		return udao.findAll();
	}
	@Override
	public Usuarios getUsuariosById(int iduser) {
		// TODO Auto-generated method stub
		return udao.getUsuariosById(iduser);
	}
	
	

}
