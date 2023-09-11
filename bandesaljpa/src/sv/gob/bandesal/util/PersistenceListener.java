package sv.gob.bandesal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.*;
/**
 * @author jj
 * @version 1.0 2015
 * Escucha encargado de la inicializacion  
 * de la unidad de persistencia
 * 
 */

@WebListener
public class PersistenceListener implements ServletContextListener {

	private static EntityManagerFactory emf;
	String usuario="";
	String clave="";
	public void contextDestroyed(ServletContextEvent ctx) {
		
		 try{
	       if(emf!=null){	
			 emf.close();
	       }
	      }catch(Exception e){
	    	  e.printStackTrace();
	      }
	}

	@SuppressWarnings("unchecked")
	public void contextInitialized(ServletContextEvent ctx) {
	      
	       @SuppressWarnings("rawtypes")
		Map pro = new HashMap();
	      // leerConf();
	 
	       pro.put("javax.persistence.jdbc.user", "snackbar");
	       pro.put("javax.persistence.jdbc.password", "snackbar2021");
		  
		    try {
		      	emf = Persistence.createEntityManagerFactory("snackbarPU",pro);
		    
	        
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
  
		    
	}

	 public static EntityManager createEntityManager() {
	        if (emf == null) {
	            throw new IllegalStateException("Context is not initialized yet.");
	        }
           
	        return emf.createEntityManager();
	    }
	
	@SuppressWarnings("unused")
	private void leerConf(){
		ResourceBundle rb=null;
		
	try{
		rb = ResourceBundle.getBundle("");
		if (rb!=null){
		
			usuario = rb.getString("usuario");
			clave = rb.getString("clave");
			
		}
	}catch(MissingResourceException e){
		
	}	
	}
}
