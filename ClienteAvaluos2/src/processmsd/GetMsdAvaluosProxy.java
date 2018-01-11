package processmsd;

public class GetMsdAvaluosProxy implements processmsd.GetMsdAvaluos {
  private String _endpoint = null;
  private processmsd.GetMsdAvaluos getMsdAvaluos = null;
  
  public GetMsdAvaluosProxy() {
    _initGetMsdAvaluosProxy();
  }
  
  public GetMsdAvaluosProxy(String endpoint) {
    _endpoint = endpoint;
    _initGetMsdAvaluosProxy();
  }
  
  private void _initGetMsdAvaluosProxy() {
    try {
      getMsdAvaluos = (new processmsd.GetMsdAvaluosServiceLocator()).getGetMsdAvaluos();
      if (getMsdAvaluos != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)getMsdAvaluos)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)getMsdAvaluos)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (getMsdAvaluos != null)
      ((javax.xml.rpc.Stub)getMsdAvaluos)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public processmsd.GetMsdAvaluos getGetMsdAvaluos() {
    if (getMsdAvaluos == null)
      _initGetMsdAvaluosProxy();
    return getMsdAvaluos;
  }
  
  public java.lang.String deleteFile(java.lang.String FOLIOEXPEDIENTE, java.lang.String tipoArchivo, java.lang.String aplicacion) throws java.rmi.RemoteException{
    if (getMsdAvaluos == null)
      _initGetMsdAvaluosProxy();
    return getMsdAvaluos.deleteFile(FOLIOEXPEDIENTE, tipoArchivo, aplicacion);
  }
  
  public java.lang.String addFile(java.lang.String CADENABASE64, java.lang.String FOLIOEXPEDIENTE, java.lang.String tipoArchivo, java.lang.String extesion, java.lang.String aplicacion) throws java.rmi.RemoteException{
    if (getMsdAvaluos == null)
      _initGetMsdAvaluosProxy();
    return getMsdAvaluos.addFile(CADENABASE64, FOLIOEXPEDIENTE, tipoArchivo, extesion, aplicacion);
  }
  
  public java.lang.String[] getListFol(java.lang.String FOLIOEXPEDIENTE, java.lang.String aplicacion) throws java.rmi.RemoteException{
    if (getMsdAvaluos == null)
      _initGetMsdAvaluosProxy();
    return getMsdAvaluos.getListFol(FOLIOEXPEDIENTE, aplicacion);
  }
  
  public java.lang.String downloadfile(java.lang.String FOLIOEXPEDIENTE, java.lang.String tipoArchivo, java.lang.String aplicacion) throws java.rmi.RemoteException{
    if (getMsdAvaluos == null)
      _initGetMsdAvaluosProxy();
    return getMsdAvaluos.downloadfile(FOLIOEXPEDIENTE, tipoArchivo, aplicacion);
  }
  
  
}