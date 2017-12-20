/**
 * WSVisorDelegate.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * m1116.12 v5211201433
 */

package com.bbva.visor.extranet;

public interface WSVisorDelegate extends java.rmi.Remote {
	public byte[] getFiles(java.lang.String folio, java.lang.String aplicacion) throws java.rmi.RemoteException;

	public com.bbva.visor.extranet.Documento getDocuments(java.lang.String folio, java.lang.String aplicacion)
			throws java.rmi.RemoteException;
}
