package sv.gob.bandesal.negocio.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sv.gob.bandesal.entidades.negocio.BlogsReaders;

@ManagedBean (name="mBBlRe")
@ViewScoped
public class MBBlogReaders {
	 private String blog;
	 private String reader;
	 private List<BlogsReaders> blrel;
	 
	 private Map<String, String> blomap = new HashMap<>();
	 private Map<String, String> readmap = new HashMap<>();

	@PostConstruct
	public void init(){
		
	}
	 
	public void guardar(){
		
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
	 
}
