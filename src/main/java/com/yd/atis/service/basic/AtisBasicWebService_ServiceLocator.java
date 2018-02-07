/**
 * AtisBasicWebService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.yd.atis.service.basic;

public class AtisBasicWebService_ServiceLocator extends org.apache.axis.client.Service implements AtisBasicWebService_Service {

    public AtisBasicWebService_ServiceLocator() {
    }


    public AtisBasicWebService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AtisBasicWebService_ServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AtisBasicWebServicePort
    private String AtisBasicWebServicePort_address = "http://172.16.200.81:7001/AtisWebService/AtisBasicWebService";

    public String getAtisBasicWebServicePortAddress() {
        return AtisBasicWebServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private String AtisBasicWebServicePortWSDDServiceName = "AtisBasicWebServicePort";

    public String getAtisBasicWebServicePortWSDDServiceName() {
        return AtisBasicWebServicePortWSDDServiceName;
    }

    public void setAtisBasicWebServicePortWSDDServiceName(String name) {
        AtisBasicWebServicePortWSDDServiceName = name;
    }

    public AtisBasicWebService_PortType getAtisBasicWebServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AtisBasicWebServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAtisBasicWebServicePort(endpoint);
    }

    public AtisBasicWebService_PortType getAtisBasicWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            AtisBasicWebServicePortBindingStub _stub = new AtisBasicWebServicePortBindingStub(portAddress, this);
            _stub.setPortName(getAtisBasicWebServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAtisBasicWebServicePortEndpointAddress(String address) {
        AtisBasicWebServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (AtisBasicWebService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                AtisBasicWebServicePortBindingStub _stub = new AtisBasicWebServicePortBindingStub(new java.net.URL(AtisBasicWebServicePort_address), this);
                _stub.setPortName(getAtisBasicWebServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
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
        String inputPortName = portName.getLocalPart();
        if ("AtisBasicWebServicePort".equals(inputPortName)) {
            return getAtisBasicWebServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.atis.hisense.com/", "AtisBasicWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.atis.hisense.com/", "AtisBasicWebServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("AtisBasicWebServicePort".equals(portName)) {
            setAtisBasicWebServicePortEndpointAddress(address);
        }
        else
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
