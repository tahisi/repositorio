/**
 * WSVisorServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * m1116.12 v5211201433
 */

package com.bbva.visor.extranet;

public class WSVisorServiceLocator extends com.ibm.ws.webservices.multiprotocol.AgnosticService
		implements com.ibm.ws.webservices.multiprotocol.GeneratedService, com.bbva.visor.extranet.WSVisorService {

	public WSVisorServiceLocator() {
		super(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://extranet.visor.bbva.com/",
				"WSVisorService"));

		context.setLocatorName("com.bbva.visor.extranet.WSVisorServiceLocator");
	}

	public WSVisorServiceLocator(com.ibm.ws.webservices.multiprotocol.ServiceContext ctx) {
		super(ctx);
		context.setLocatorName("com.bbva.visor.extranet.WSVisorServiceLocator");
	}

	// Utilizar para obtener la clase de proxy para WSVisorPort
//	private final java.lang.String WSVisorPort_address = "http://150.250.234.123:37041/visorlive_mx_web/WSVisorPort?wsdl";
//	private final java.lang.String WSVisorPort_address = "http://localhost:9081/consultasaso_mx_web/WSVisorPort?wsdl";
	private final java.lang.String WSVisorPort_address ="http://150.100.210.22:36061/fimxvisor/WSVisorPort?wsdl";

	public java.lang.String getWSVisorPortAddress() {
		if (context.getOverriddingEndpointURIs() == null) {
			return WSVisorPort_address;
		}
		String overriddingEndpoint = (String) context.getOverriddingEndpointURIs().get("WSVisorPort");
		if (overriddingEndpoint != null) {
			return overriddingEndpoint;
		} else {
			return WSVisorPort_address;
		}
	}

	private java.lang.String WSVisorPortPortName = "WSVisorPort";

	// The WSDD port name defaults to the port name.
	private java.lang.String WSVisorPortWSDDPortName = "WSVisorPort";

	public java.lang.String getWSVisorPortWSDDPortName() {
		return WSVisorPortWSDDPortName;
	}

	public void setWSVisorPortWSDDPortName(java.lang.String name) {
		WSVisorPortWSDDPortName = name;
	}

	public com.bbva.visor.extranet.WSVisorDelegate getWSVisorPort() throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(getWSVisorPortAddress());
		} catch (java.net.MalformedURLException e) {
			return null; // es poco probable ya que URL se ha validado en
							// WSDL2Java
		}
		return getWSVisorPort(endpoint);
	}

	public com.bbva.visor.extranet.WSVisorDelegate getWSVisorPort(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException {
		com.bbva.visor.extranet.WSVisorDelegate _stub = (com.bbva.visor.extranet.WSVisorDelegate) getStub(
				WSVisorPortPortName, (String) getPort2NamespaceMap().get(WSVisorPortPortName),
				com.bbva.visor.extranet.WSVisorDelegate.class, "com.bbva.visor.extranet.WSVisorPortBindingStub",
				portAddress.toString());
		if (_stub instanceof com.ibm.ws.webservices.engine.client.Stub) {
			((com.ibm.ws.webservices.engine.client.Stub) _stub).setPortName(WSVisorPortWSDDPortName);
		}
		return _stub;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		try {
			if (com.bbva.visor.extranet.WSVisorDelegate.class.isAssignableFrom(serviceEndpointInterface)) {
				return getWSVisorPort();
			}
		} catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException(
				"WSWS3273E: Error: No hay ninguna implementación de apéndice para la interfaz:  "
						+ (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		String inputPortName = portName.getLocalPart();
		if ("WSVisorPort".equals(inputPortName)) {
			return getWSVisorPort();
		} else {
			throw new javax.xml.rpc.ServiceException();
		}
	}

	public void setPortNamePrefix(java.lang.String prefix) {
		WSVisorPortWSDDPortName = prefix + "/" + WSVisorPortPortName;
	}

	public javax.xml.namespace.QName getServiceName() {
		return com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://extranet.visor.bbva.com/",
				"WSVisorService");
	}

	private java.util.Map port2NamespaceMap = null;

	protected synchronized java.util.Map getPort2NamespaceMap() {
		if (port2NamespaceMap == null) {
			port2NamespaceMap = new java.util.HashMap();
			port2NamespaceMap.put("WSVisorPort", "http://schemas.xmlsoap.org/wsdl/soap/");
		}
		return port2NamespaceMap;
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			String serviceNamespace = getServiceName().getNamespaceURI();
			for (java.util.Iterator i = getPort2NamespaceMap().keySet().iterator(); i.hasNext();) {
				ports.add(com.ibm.ws.webservices.engine.utils.QNameTable.createQName(serviceNamespace,
						(String) i.next()));
			}
		}
		return ports.iterator();
	}

	public javax.xml.rpc.Call[] getCalls(javax.xml.namespace.QName portName) throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			throw new javax.xml.rpc.ServiceException("WSWS3062E: Error: portName no debe ser nulo.");
		}
		if (portName.getLocalPart().equals("WSVisorPort")) {
			return new javax.xml.rpc.Call[] { createCall(portName, "getFiles", "null"),
					createCall(portName, "getDocuments", "null"), };
		} else {
			throw new javax.xml.rpc.ServiceException("WSWS3062E: Error: portName no debe ser nulo.");
		}
	}
}
