/**
 * Blogws.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sv.gob.bandesal.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import sv.gob.bandesal.entidades.negocio.Blogs;
import sv.gob.bandesal.service.BlogsSvrImp;
@WebService
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT)

public class Blogws {
    BlogsSvrImp bsvr = new BlogsSvrImp();
	List<Blogs> res;
	@WebMethod
	public List<Blogs> lista(){
	   res = bsvr.findAll();
	   return res;
	}
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/blogWS", new Blogws());

	}

}
