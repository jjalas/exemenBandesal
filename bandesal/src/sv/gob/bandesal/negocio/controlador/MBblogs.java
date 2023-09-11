package sv.gob.bandesal.negocio.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sv.gob.bandesal.entidades.negocio.Blogs;
import sv.gob.bandesal.service.BlogsSvrImp;
import sv.gob.bandesal.service.IBlogsSvr;

@ManagedBean(name="mBBlogs")
@ViewScoped
public class MBblogs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Blogs> blogl;
	private Blogs blogsel;
	
	BlogsSvrImp blogsvr = new BlogsSvrImp()  ;
	
	@PostConstruct
	
	public void init(){
	  blogl = blogsvr.findAll();	
	}
	
	
	
	
	
	
	
	
	
	public List<Blogs> getBlogl() {
		return blogl;
	}
	public void setBlogl(List<Blogs> blogl) {
		this.blogl = blogl;
	}
	public Blogs getBlogsel() {
		return blogsel;
	}
	public void setBlogsel(Blogs blogsel) {
		this.blogsel = blogsel;
	}

}
