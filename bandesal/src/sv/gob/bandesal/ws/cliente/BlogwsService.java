/**
 * BlogwsService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sv.gob.bandesal.ws.cliente;

import sv.gob.bandesal.ws.Blogws;

public interface BlogwsService extends javax.xml.rpc.Service {
    public java.lang.String getBlogwsPortAddress();

    public sv.gob.bandesal.ws.Blogws getBlogwsPort() throws javax.xml.rpc.ServiceException;

    public sv.gob.bandesal.ws.Blogws getBlogwsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
