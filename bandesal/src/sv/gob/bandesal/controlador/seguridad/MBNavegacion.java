package sv.gob.bandesal.controlador.seguridad;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.MenuItem;

import sv.gob.bandesal.controlador.sesion.MBSesiones;


@ManagedBean(name="mBNaveg")
@SessionScoped
public class MBNavegacion implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public String pagina;
  
  @ManagedProperty("#{mBSesion}")
  private MBSesiones logs ;
 
  @PostConstruct
  public void init(){
	 
	
		
  }
  
  public void doPagina(ActionEvent event){
		
		 MenuActionEvent j = (MenuActionEvent) event;
		 MenuItem item = j.getMenuItem();
		 @SuppressWarnings("rawtypes")
		List mapa = item.getParams().get("pagina");
		 
		pagina = mapa.get(0).toString();
	 	
   	  
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("navegacion.xhtml");
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	  }

  public void doBack(){
	  try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("navegacion.xhtml");
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
  }
  
  
/**
 * @return the pagina
 */
public String getPagina() {
	return pagina;
}


/**
 * @param pagina the pagina to set
 */
public void setPagina(String pagina) {
	
	this.pagina = pagina;
}

/**
 * @return the logs
 */
public MBSesiones getLogs() {
	return logs;
}


/**
 * @param logs the logs to set
 */
public void setLogs(MBSesiones logs) {
	this.logs = logs;
}


public void navegar(){
	try {
	 
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("navegacion.xhtml");
		
	} catch (IOException e) {
	
		e.printStackTrace();
	}
}
	
}
