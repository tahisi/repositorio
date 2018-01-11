/**
 * GetMsdAvaluos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package processmsd;

public interface GetMsdAvaluos extends java.rmi.Remote {
    public java.lang.String deleteFile(java.lang.String FOLIOEXPEDIENTE, java.lang.String tipoArchivo, java.lang.String aplicacion) throws java.rmi.RemoteException;
    public java.lang.String addFile(java.lang.String CADENABASE64, java.lang.String FOLIOEXPEDIENTE, java.lang.String tipoArchivo, java.lang.String extesion, java.lang.String aplicacion) throws java.rmi.RemoteException;
    public java.lang.String[] getListFol(java.lang.String FOLIOEXPEDIENTE, java.lang.String aplicacion) throws java.rmi.RemoteException;
    public java.lang.String downloadfile(java.lang.String FOLIOEXPEDIENTE, java.lang.String tipoArchivo, java.lang.String aplicacion) throws java.rmi.RemoteException;
}
