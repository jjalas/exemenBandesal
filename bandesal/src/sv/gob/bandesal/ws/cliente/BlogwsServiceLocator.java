/**
 * BlogwsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sv.gob.bandesal.ws.cliente;

import sv.gob.bandesal.ws.Blogws;

public class BlogwsServiceLocator extends org.apache.axis.client.Service implements sv.gob.bandesal.ws.cliente.BlogwsService {

    public BlogwsServiceLocator() {
    }


    public BlogwsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BlogwsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BlogwsPort
    private java.lang.String BlogwsPort_address = "http://localhost:8080/blogWS";

    public java.lang.String getBlogwsPortAddress() {
        return BlogwsPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BlogwsPortWSDDServiceName = "BlogwsPort";

    public java.lang.String getBlogwsPortWSDDServiceName() {
        return BlogwsPortWSDDServiceName;
    }

    public void setBlogwsPortWSDDServiceName(java.lang.String name) {
        BlogwsPortWSDDServiceName = name;
    }

    public sv.gob.bandesal.ws.Blogws getBlogwsPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BlogwsPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBlogwsPort(endpoint);
    }

    public sv.gob.bandesal.ws.Blogws getBlogwsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            sv.gob.bandesal.ws.cliente.BlogwsPortBindingStub _stub = new sv.gob.bandesal.ws.cliente.BlogwsPortBindingStub(portAddress, this);
            _stub.setPortName(getBlogwsPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBlogwsPortEndpointAddress(java.lang.String address) {
        BlogwsPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (sv.gob.bandesal.ws.Blogws.class.isAssignableFrom(serviceEndpointInterface)) {
                sv.gob.bandesal.ws.cliente.BlogwsPortBindingStub _stub = new sv.gob.bandesal.ws.cliente.BlogwsPortBindingStub(new java.net.URL(BlogwsPort_address), this);
                _stub.setPortName(getBlogwsPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BlogwsPort".equals(inputPortName)) {
            return getBlogwsPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.bandesal.gob.sv/", "BlogwsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.bandesal.gob.sv/", "BlogwsPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BlogwsPort".equals(portName)) {
            setBlogwsPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
