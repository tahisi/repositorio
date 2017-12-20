/**
 * WSVisorService.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * m1116.12 v5211201433
 */

package com.bbva.visor.extranet;

public interface WSVisorService extends javax.xml.rpc.Service {
	public com.bbva.visor.extranet.WSVisorDelegate getWSVisorPort() throws javax.xml.rpc.ServiceException;

	public java.lang.String getWSVisorPortAddress();

	public com.bbva.visor.extranet.WSVisorDelegate getWSVisorPort(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException;
}
