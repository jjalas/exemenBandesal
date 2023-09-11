package sv.gob.bandesal.negocio.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sv.gob.bandesal.entidades.negocio.Readers;
import sv.gob.bandesal.service.ReadersSvrImp;

@ManagedBean(name="mBRead")
@ViewScoped
public class mBReaders {
  private List<Readers> readl;
  private Readers readersel;

  ReadersSvrImp rdsvr = new ReadersSvrImp();
  @PostConstruct
  public void init(){
	  readl = rdsvr.findAll();
  }
  
  public void onCreate(){
	  readersel = new Readers();
  }
  
  public void guardar(){
	 try{
	  rdsvr.guardar(readersel);
	 }catch(Exception ex){
		 ex.printStackTrace();
	 }
  }
  public void actualizar(){
	 try{
	  rdsvr.actualizar(readersel);
	 }catch(Exception ex){
		 ex.printStackTrace();
	 }
  }
  
  public void eliminar(){
	try{
	  rdsvr.eliminar(readersel);
	}catch(Exception ex){
		ex.printStackTrace();
	}
  }
  
  public List<Readers> getReadl() {
	return readl;
}
public void setReadl(List<Readers> readl) {
	this.readl = readl;
}
public Readers getReadersel() {
	return readersel;
}
public void setReadersel(Readers readersel) {
	this.readersel = readersel;
}




}
