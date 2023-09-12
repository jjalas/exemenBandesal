package sv.gob.bandesal.negocio.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sv.gob.bandesal.entidades.negocio.Blogs;
import sv.gob.bandesal.entidades.negocio.BlogsReaders;
import sv.gob.bandesal.entidades.negocio.Readers;
import sv.gob.bandesal.service.BlogReadersSvr;
import sv.gob.bandesal.service.BlogsSvrImp;
import sv.gob.bandesal.service.ReadersSvrImp;

@ManagedBean (name="mBBlRe")
@ViewScoped
public class MBBlogReaders {
	 private String blog;
	 private String reader;
	 private List<BlogsReaders> blrel;
	 private BlogsReaders brsel;
	 
	 private Map<String, String> blomap = new HashMap<>();
	 private Map<String, String> readmap = new HashMap<>();
     
	 BlogsSvrImp bsvr = new BlogsSvrImp();
	 ReadersSvrImp rsvr = new ReadersSvrImp();
	 BlogReadersSvr brsvr = new BlogReadersSvr();
	 
	@PostConstruct
	public void init(){
		listar();
	}
	private void listar(){
		blrel = brsvr.findAll();

	}
	public void guardar(){
	    Blogs blo = bsvr.findById(Integer.parseInt(blog));  
	   
		Readers read = rsvr.findById(Integer.parseInt(reader));
	
	    brsel.setBlogsID(blo);
	    brsel.setReadersID(read);
		brsvr.guardar(brsel);
		listar();
	}
	
    public void onCreate(){
    	brsel = new BlogsReaders();
    	llenarBlog();
    	llenarReaders();
    }
	public void actualizar(){
		brsvr.actualizar(brsel);
	}
	public void eliminar(){
		brsvr.eliminar(brsel);
	}
	
	private void llenarBlog(){
		List<Blogs> blol = bsvr.findAll();
		System.out.println("bl size "+blol.size());
		
		if (!blol.isEmpty()){
		 for (Blogs blo : blol){
			 blomap.put(blo.getDescription(), blo.getId().toString());
		 }
		}
	}
	private void llenarReaders(){
		List<Readers> readl = rsvr.findAll();
		if (!readl.isEmpty()){
			for (Readers rea : readl){
				readmap.put(rea.getName(), rea.getId().toString());
			}
		}
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	public String getReader() {
		return reader;
	}
	public void setReader(String reader) {
		this.reader = reader;
	}
	public Map<String, String> getBlomap() {
		return blomap;
	}
	public void setBlomap(Map<String, String> blomap) {
		this.blomap = blomap;
	}
	public Map<String, String> getReadmap() {
		return readmap;
	}
	public void setReadmap(Map<String, String> readmap) {
		this.readmap = readmap;
	}
	public List<BlogsReaders> getBlrel() {
		return blrel;
	}
	public void setBlrel(List<BlogsReaders> blrel) {
		this.blrel = blrel;
	}
	public BlogsReaders getBrsel() {
		return brsel;
	}
	public void setBrsel(BlogsReaders brsel) {
		this.brsel = brsel;
	}
	 
}
