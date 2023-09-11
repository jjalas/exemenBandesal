package sv.gob.bandesal.controlador.seguridad;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import sv.gob.bandesal.controlador.sesion.MBSesiones;
import sv.gob.bandesal.dao.seguridad.MenuDaoImp;
import sv.gob.bandesal.entidades.seguridad.*;





@ManagedBean(name="mBMenuindex")
@ViewScoped
public class MBMenuindex implements Serializable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private MenuModel menumodel;
  private List<Menu> menul;
  private List<Menu> submenul;
  FacesContext context = FacesContext.getCurrentInstance();
 

  @ManagedProperty("#{mBSesion}")
  private MBSesiones logsession ;
  
  @PostConstruct
  public void init(){
	  if (logsession!=null){
		  crearMenu();	 
	  }
  }
  
  public void crearMenu()
  {
     
    try
    {
      if (logsession.getUsuarioLogeado().trim().length() > 0) {
        armarMenu();
      } else {
        try
        {
          FacesContext.getCurrentInstance().getExternalContext().redirect("default.xhtml");
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
      return;
    }
    catch (Exception e)
    {
    	e.printStackTrace();
      try
      {
        FacesContext.getCurrentInstance().getExternalContext().redirect("default.xhtml");
      }
      catch (IOException e1)
      {
        e1.printStackTrace();
      }
    }
  }
  
  public void armarMenu()
  {
    this.menumodel = new DefaultMenuModel();
    @SuppressWarnings("unused")
	FacesContext facesCtx = FacesContext.getCurrentInstance();
  
    String url = "";
    @SuppressWarnings("unused")
	String usuario = "";
  
    usuario = logsession.getUsuarioLogeado();
    int idrol = logsession.getIdRol();
    MenuDaoImp daom = new MenuDaoImp();
    menul = daom.listarMenu();
      int mit=0;
    for (int z = 0; z < this.menul.size(); z++)
    {
      DefaultSubMenu sb = new DefaultSubMenu();
      sb.setId("sm"+z);
      sb.setLabel(((Menu)this.menul.get(z)).getNombre());
      submenul = daom.getSubmenu(((Menu)this.menul.get(z)).getIdmenu(), idrol);
      if (this.submenul != null) {
        for (int i = 0; i < this.submenul.size(); i++)
        {
          DefaultMenuItem mi = new DefaultMenuItem();
          mi.setId("mit"+mit);
          mi.setValue(((Menu)this.submenul.get(i)).getNombre());
          url = ((Menu)this.submenul.get(i)).getObjeto();
          mi.setCommand("#{mBNaveg.doPagina}");
          mi.setParam("pagina",url);
 //         mi.setActionExpression(expFact.createMethodExpression(elCtx, "#{mBNavegacion.setPaginaActual('" + url + "')}", Void.class, new Class[0]));
 //         mi.setOncomplete("actualizarcon()");
  //        mi.setUpdate("@none");
          sb.addElement(mi);
          mit++;
        }
      }
      this.menumodel.addElement(sb);
    }
  }
  
  public MenuModel getMenumodel()
  {
    return this.menumodel;
  }
  
  public void setMenumodel(MenuModel menumodel)
  {
    this.menumodel = menumodel;
  }

/**
 * @return the logsession
 */
public MBSesiones getLogsession() {
	return logsession;
}

/**
 * @param logsession the logsession to set
 */
public void setLogsession(MBSesiones logsession) {
	this.logsession = logsession;
}
}


