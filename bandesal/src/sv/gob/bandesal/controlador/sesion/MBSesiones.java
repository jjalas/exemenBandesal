package sv.gob.bandesal.controlador.sesion;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import sv.gob.bandesal.entidades.seguridad.Usuarios;




@ManagedBean (name="mBSesion")
@SessionScoped
public class MBSesiones implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String usuarioLogeado="";
	public String nombreLog="";
	public int idRol;
	public String fechasistema;
	public Usuarios user;

	
	
	public String getUsuarioLogeado() {
		return usuarioLogeado;
	}
	public void setUsuarioLogeado(String usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}
	public String getNombreLog() {
		return nombreLog;
	}
	public void setNombreLog(String nombreLog) {
		this.nombreLog = nombreLog;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getFechasistema() {
		return fechasistema;
	}
	public void setFechasistema(String fechasistema) {
		this.fechasistema = fechasistema;
	}
	
	
	public Usuarios getUser() {
		return user;
	}
	public void setUser(Usuarios user) {
		this.user = user;
	}

	
	
	
	public void logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("default.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
