/**
 * GetMsdAvaluosServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package processmsd;

public class GetMsdAvaluosServiceLocator extends org.apache.axis.client.Service implements processmsd.GetMsdAvaluosService {

    public GetMsdAvaluosServiceLocator() {
    }


    public GetMsdAvaluosServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GetMsdAvaluosServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }
//    https://150.250.235.63:36050//services/GetMsdAvaluos?wsdl
    // Use to get a proxy class for GetMsdAvaluos
//    private java.lang.String GetMsdAvaluos_address = "http://150.250.235.63:36051/WSAvaluosAxis/services/GetMsdAvaluos";
//    private java.lang.String GetMsdAvaluos_address = "http://localhost:9081/WSAvaluosAxis/services/GetMsdAvaluos";
//    private java.lang.String GetMsdAvaluos_address = "http://150.250.234.123:36051/gesavaluos_mx_web/services/GetMsdAvaluos";
//    private java.lang.String GetMsdAvaluos_address = "http://150.250.234.124:36051/gesavaluos_mx_web/services/GetMsdAvaluos";
    private java.lang.String GetMsdAvaluos_address = "http://150.100.210.236:36081/gesavaluos_mx_web/services/GetMsdAvaluos"; //PRODUCCION
    public java.lang.String getGetMsdAvaluosAddress() {
        return GetMsdAvaluos_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GetMsdAvaluosWSDDServiceName = "GetMsdAvaluos";

    public java.lang.String getGetMsdAvaluosWSDDServiceName() {
        return GetMsdAvaluosWSDDServiceName;
    }

    public void setGetMsdAvaluosWSDDServiceName(java.lang.String name) {
        GetMsdAvaluosWSDDServiceName = name;
    }

    public processmsd.GetMsdAvaluos getGetMsdAvaluos() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GetMsdAvaluos_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGetMsdAvaluos(endpoint);
    }

    public processmsd.GetMsdAvaluos getGetMsdAvaluos(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            processmsd.GetMsdAvaluosSoapBindingStub _stub = new processmsd.GetMsdAvaluosSoapBindingStub(portAddress, this);
            _stub.setPortName(getGetMsdAvaluosWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGetMsdAvaluosEndpointAddress(java.lang.String address) {
        GetMsdAvaluos_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (processmsd.GetMsdAvaluos.class.isAssignableFrom(serviceEndpointInterface)) {
                processmsd.GetMsdAvaluosSoapBindingStub _stub = new processmsd.GetMsdAvaluosSoapBindingStub(new java.net.URL(GetMsdAvaluos_address), this);
                _stub.setPortName(getGetMsdAvaluosWSDDServiceName());
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
        if ("GetMsdAvaluos".equals(inputPortName)) {
            return getGetMsdAvaluos();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://processmsd", "GetMsdAvaluosService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://processmsd", "GetMsdAvaluos"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GetMsdAvaluos".equals(portName)) {
            setGetMsdAvaluosEndpointAddress(address);
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
