package sv.gob.bandesal.util;
import java.io.Serializable;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="mBFunciones")
@SessionScoped
public class Funciones
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  public static String NUMEROS = "0123456789";
  public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
  
  
  
 
  
  public String horaTexto(Date hora)
  {
    SimpleDateFormat formateador = new SimpleDateFormat("HH:mm");
    
    return formateador.format(hora);
  }
  
  public String fechaTexto(Date fecha)
  {
    SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
    return formateador.format(fecha);
  }
  
  public Date texttoFechafl(String fecha)
  {
    SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
    Date fech = null;
    try
    {
      fech = formateador.parse(fecha);
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    return fech;
  }
 
  
  public Date textoFecha(String fecha)
  {
    SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
    Date fech = null;
    try
    {
      fech = formateador.parse(fecha);
     
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    return fech;
  }
  
  public String generaCarnet(String prefijo)
  {
    return "";
  }
  
  public String encripClave(String clear)
    throws Exception
  {
    StringBuffer h = null;
    try
    {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] b = md.digest(clear.getBytes());
      
      int size = b.length;
      h = new StringBuffer(size);
      for (int i = 0; i < size; i++)
      {
        int u = b[i] & 0xFF;
        if (u < 16) {
          h.append("0" + Integer.toHexString(u));
        } else {
          h.append(Integer.toHexString(u));
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return h.toString();
  }
  
 
  public String nombreMes(int mes){
	  String nmes="";
	  switch (mes) {
	case 1:
		nmes="Enero";
		break;
	case 2:
		nmes="Febrero";
		break;
	case 3:
		nmes="Marzo";
		break;
	case 4:
		nmes="Abril";
		break;
	case 5:
		nmes="Mayo";
		break;
	case 6:
		nmes="Junio";
		break;
	case 7:
		nmes="Julio";
		break;
	case 8:
		nmes="Agosto";
		break;
	case 9:
		nmes="Septiembre";
		break;
	case 10:
		nmes="Octubre";
		break;	
	case 11:
		nmes="Noviembre";
		break;
	case 12:
		nmes="Diciembre";
		break;	
	default:
		break;
	}
	  return nmes;
  }
  
  public void mensajes(String mensaje,String sev){
      FacesMessage.Severity fsev=null;
      	      
   if (sev.equals("1")){
    	 fsev = FacesMessage.SEVERITY_INFO;
     }else{
    	 fsev = FacesMessage.SEVERITY_ERROR;
     }
	 FacesMessage message = new FacesMessage(fsev, "Atencion", mensaje);
     FacesContext.getCurrentInstance().addMessage(null, message);
}

  
  
  
  public String crearClave(int tipo){
	 if (tipo==0){ 
	  return getPing();
	 }else{
	  return getPassword();	 
	 }
  }
  
  private static String getPassword() {
		return getPassword(8);
	}
   
   private static String getPing(){
	   return ping(4);
   }
  
    private static String ping(int length){
    	return getPassword(NUMEROS, length);
    }
  
	private static String getPassword(int length) {
		return getPassword(NUMEROS + MAYUSCULAS + MINUSCULAS, length);
	}

	private static String getPassword(String key, int length) {
		String pswd = "";

		for (int i = 0; i < length; i++) {
			pswd+=(key.charAt((int)(Math.random() * key.length())));
		}

		return pswd;
	}
 
	
}


