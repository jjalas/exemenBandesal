package sv.gob.bandesal.dao.seguridad;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.gob.bandesal.entidades.seguridad.Menu;
import sv.gob.bandesal.util.PersistenceListener;
import sv.gob.bandesal.persistencia.*;



public class MenuDaoImp extends DaoGenericoImp<Menu, Long> implements MenuDao {
	EntityManager session=null;
	List<Menu> menul=null;

	
	
	@SuppressWarnings("unchecked")
	public List<Menu> getByRol(int idrol) {
		String sql="";
		try{
			 session=PersistenceListener.createEntityManager();
		    sql = "select * from menu where nivel=2 and not exists ( "
            +"select 1 from menu_roles where roles_idrol=:idrol " 
            +"and menu.idmenu=menu_idmenu)";
		    Query q = session.createNativeQuery(sql,Menu.class);
		  menul = q.setParameter("idrol", idrol).getResultList();
		
		}catch(Exception e){
			menul=null; 
			e.printStackTrace();
		 }finally{
			 session.close();
		 }		
		
		return menul;
	}

	@SuppressWarnings("unchecked")
	public List<Menu> getSubmenu(int idp, int idrol) {
		try{
			 session=PersistenceListener.createEntityManager();
		Query q = session.createQuery("from Menu menu where menu.menuSup=:idmp and "
      	+"exists (from MenuRole mr where mr.menu=menu and mr.role.idrol=:idrol)");
		q.setParameter("idmp", idp);
		q.setParameter("idrol",idrol);
		menul = q.getResultList();
		}catch(Exception e){
			menul=null; 
			e.printStackTrace();;
		 }finally{
			 session.close();
		 }		
		
		return menul;
	}

	@SuppressWarnings("unchecked")
	public List<Menu> listarMenu() {
		try{
			 session=PersistenceListener.createEntityManager();
			Query q = session.createQuery("from Menu  menu where  menu.menuSup=0 order by menu.idmenu");
			menul = q.getResultList();
			
		}catch(Exception e){
			menul=null; 
			e.printStackTrace();;
		 }finally{
			 session.close();
		 }		
		return menul;
	}

}
