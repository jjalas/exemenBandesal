package sv.gob.bandesal.controlador.seguridad;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sv.gob.bandesal.controlador.sesion.MBSesiones;
import sv.gob.bandesal.entidades.seguridad.Usuarios;
import sv.gob.bandesal.seguridad.servicios.UsuariosSvr;
import sv.gob.bandesal.util.Funciones;



//import com.snackbar.util.Funciones;






@ManagedBean (name="mBLogin")
@ViewScoped
public class MBLoginInterno implements Serializable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  private String usuario = null;
  private String clave;
    
  UsuariosSvr lesvr = null;
  
  
 @ManagedProperty("#{mBSesion}")
  private MBSesiones logsession ;
  
  public MBLoginInterno() {
	lesvr = new UsuariosSvr();
}
  
  public String getUsuario()
  {
    return this.usuario;
  }
  
  public void setUsuario(String usuario)
  {
    this.usuario = usuario;
  }
  
  public String getClave()
  {
    return this.clave;
  }
  
  public void setClave(String clave)
  {
    this.clave = clave;
  }
  
  /**
 * @return the logsession
 */
public MBSesiones getLogsession() {
	return logsession;
}


public void setLogsession(MBSesiones logsession) {
	this.logsession = logsession;
}




public void doLogin(){
    boolean valido = false;

    String clavetabla = "";
    String clavencriptada = "";
    String codusuario = "";
   
    
    Usuarios log = lesvr.getUsuarioByUser(usuario);
   
      if (log != null){
        clavetabla = log.getClave().trim();
        codusuario = log.getLogin();
        codusuario = codusuario.trim();
     
       Funciones f = new Funciones();
        try
        {
          clavencriptada = f.encripClave(this.clave);
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
        if (clavencriptada.trim().equals(clavetabla)){
        	try {
        	
        		
        		logsession.setUsuarioLogeado(log.getLogin());
        		logsession.setNombreLog(log.getNombre()+" "+log.getApellido());
        		logsession.setUser(log);
        	
        		
        		fechaSistema();
        		
			
				
        		FacesContext.getCurrentInstance().getExternalContext().redirect("Principal.xhtml");
			   
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Clave no Valida"));
        }
      }
    }

 
  public void doSalir(){
		
	  try {
		  if(logsession.idRol==1 || logsession.idRol==6){
			  logsession=null;
			 
			FacesContext.getCurrentInstance().getExternalContext().redirect("Principal.xhtml");
		  }else{
			 
			  logsession=null;
			  FacesContext.getCurrentInstance().getExternalContext().redirect("../default.xhtml");
		  }
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
  }
	  
  private void fechaSistema(){
	 
	  Funciones f = new Funciones();
	  Date ahora = new Date();
      ahora = f.textoFecha(f.fechaTexto(ahora));
   
      logsession.setFechasistema(f.fechaTexto(ahora));
  }
}


