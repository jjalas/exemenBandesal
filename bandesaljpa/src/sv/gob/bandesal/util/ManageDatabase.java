package sv.gob.bandesal.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * @author Zoom
 * @version 1.0 2015
 * Clase para el manejo de entidades  
 * 
 * 
 */


public class ManageDatabase {
	 private EntityManagerFactory emf=null;
	  
	    //private static final Logger logger = Logger.getLogger(DatabaseManager.class.getName());

	    public ManageDatabase() {
	        try {
	         
	        	emf = Persistence.createEntityManagerFactory("bandesaljpa");
	        
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    /**
	     * Metodo encargado retornar el hilo de conexion 
	     *  
	     * @return Entity Manager
	     */
	    public EntityManager getConexion(){
	    	return emf.createEntityManager();
	        	
	    }
	    /**
	     * Metodo encargado de cerrr el hilo de conexion  
	     *  
	     * @return none
	     */
	    public void cerrar(){
	    	emf.close();
	    }
	
}
