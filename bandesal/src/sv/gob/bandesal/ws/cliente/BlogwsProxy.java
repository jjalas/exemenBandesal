package sv.gob.bandesal.ws.cliente;

import sv.gob.bandesal.ws.Blogws;

public class BlogwsProxy implements sv.gob.bandesal.ws.Blogws {
  private String _endpoint = null;
  private sv.gob.bandesal.ws.Blogws blogws = null;
  
  public BlogwsProxy() {
    _initBlogwsProxy();
  }
  
  public BlogwsProxy(String endpoint) {
    _endpoint = endpoint;
    _initBlogwsProxy();
  }
  
  private void _initBlogwsProxy() {
    try {
      blogws = (new sv.gob.bandesal.ws.cliente.BlogwsServiceLocator()).getBlogwsPort();
      if (blogws != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)blogws)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)blogws)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (blogws != null)
      ((javax.xml.rpc.Stub)blogws)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public sv.gob.bandesal.ws.Blogws getBlogws() {
    if (blogws == null)
      _initBlogwsProxy();
    return blogws;
  }
  
  public sv.gob.bandesal.ws.cliente.Blogs[] lista() throws java.rmi.RemoteException{
    if (blogws == null)
      _initBlogwsProxy();
    return blogws.lista();
  }
  
  
}