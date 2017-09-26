package syc.bbva.firmadig.ws.cliente;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

import syc.bbva.firmadig.utils.Constantes;

@WebServiceClient(name = "WSExpunicoService", targetNamespace = "http://ws.syc.com",  wsdlLocation = Constantes.wsdlExpUnic)

public class WSExpunicoService extends Service {

    	private static WSExpunicoService wsExpunicoService;
	private final static URL WSEXPUNICOSERVICE_WSDL_LOCATION;
	private final static Logger logger = Logger.getLogger(syc.bbva.firmadig.ws.cliente.WSExpunicoService.class.getName());

	static {
	    
		URL url = null;
		
		try {
			URL baseUrl;
			baseUrl = syc.bbva.firmadig.ws.cliente.WSExpunicoService.class.getResource(".");
			
			url = new URL( baseUrl, Constantes.wsdlExpUnic);
			
		} catch (MalformedURLException e) {
			logger.warning("Failed to create URL for the wsdl Location: '" + Constantes.wsdlExpUnic +"', retrying as a local file");
			logger.warning(e.getMessage());
		}
		
		WSEXPUNICOSERVICE_WSDL_LOCATION = url;
	}
	
	private WSExpunicoService(URL wsdlLocation, QName serviceName) {
	    super(wsdlLocation, serviceName);
	}

	private WSExpunicoService(URL wsdlLocation){
	    super(wsdlLocation, new QName("http://ws.syc.com", "WSExpunicoService"));
	}

	private WSExpunicoService() {
		super(WSEXPUNICOSERVICE_WSDL_LOCATION, new QName("http://ws.syc.com", "WSExpunicoService"));
	}

	@WebEndpoint(name = "WSExpunico")
	public WSExpunicoSEI getWSExpunico() {
		return super.getPort(new QName("http://ws.syc.com", "WSExpunico"), WSExpunicoSEI.class);
	}
	
	public static final WSExpunicoService getInstancia(URL wsdlLocation){
	    if(wsExpunicoService==null){
		synchronized(WSExpunicoService.class){
		    if(wsExpunicoService==null){
			if(wsdlLocation == null || wsdlLocation.equals(""))
			    wsExpunicoService = new WSExpunicoService();
			else
			    wsExpunicoService = new WSExpunicoService(wsdlLocation);
		    }
		}
	    }
	    return wsExpunicoService;
	}

}
