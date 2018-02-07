/**
 * AtisDynamicWebService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.yd.atis.service.dynamicService;

public class AtisDynamicWebService_ServiceLocator extends org.apache.axis.client.Service implements AtisDynamicWebService_Service {

    public AtisDynamicWebService_ServiceLocator() {
    }


    public AtisDynamicWebService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AtisDynamicWebService_ServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AtisDynamicWebServicePort
    private String AtisDynamicWebServicePort_address = "http://172.16.200.81:7001/AtisWebService/AtisDynamicWebService";

    public String getAtisDynamicWebServicePortAddress() {
        return AtisDynamicWebServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private String AtisDynamicWebServicePortWSDDServiceName = "AtisDynamicWebServicePort";

    public String getAtisDynamicWebServicePortWSDDServiceName() {
        return AtisDynamicWebServicePortWSDDServiceName;
    }

    public void setAtisDynamicWebServicePortWSDDServiceName(String name) {
        AtisDynamicWebServicePortWSDDServiceName = name;
    }

    public AtisDynamicWebService_PortType getAtisDynamicWebServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AtisDynamicWebServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAtisDynamicWebServicePort(endpoint);
    }

    public AtisDynamicWebService_PortType getAtisDynamicWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            AtisDynamicWebServicePortBindingStub _stub = new AtisDynamicWebServicePortBindingStub(portAddress, this);
            _stub.setPortName(getAtisDynamicWebServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAtisDynamicWebServicePortEndpointAddress(String address) {
        AtisDynamicWebServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (AtisDynamicWebService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                AtisDynamicWebServicePortBindingStub _stub = new AtisDynamicWebServicePortBindingStub(new java.net.URL(AtisDynamicWebServicePort_address), this);
                _stub.setPortName(getAtisDynamicWebServicePortWSDDServiceName());
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
        if ("AtisDynamicWebServicePort".equals(inputPortName)) {
            return getAtisDynamicWebServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.atis.hisense.com/", "AtisDynamicWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.atis.hisense.com/", "AtisDynamicWebServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("AtisDynamicWebServicePort".equals(portName)) {
            setAtisDynamicWebServicePortEndpointAddress(address);
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
