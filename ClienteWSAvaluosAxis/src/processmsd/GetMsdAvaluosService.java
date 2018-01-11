
package processmsd;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * <p>
 * An example of how this class may be used:
 * 
 * <pre>
* GetMsdAvaluosService service = new GetMsdAvaluosService();
* GetMsdAvaluos portType = service.getGetMsdAvaluos();
* portType.deleteFile(...);
 * </pre>
 * </p>
 * 
 */
@WebServiceClient(name = "GetMsdAvaluosService", targetNamespace = "http://processmsd", wsdlLocation = "http://150.100.210.236:36081/gesavaluos_mx_web/services/GetMsdAvaluos?wsdl")
public class GetMsdAvaluosService extends Service {

	private final static URL GETMSDAVALUOSSERVICE_WSDL_LOCATION;
	private final static Logger logger = Logger.getLogger(processmsd.GetMsdAvaluosService.class.getName());

	static {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = processmsd.GetMsdAvaluosService.class.getResource(".");
			url = new URL(baseUrl, "http://150.100.210.236:36081/gesavaluos_mx_web/services/GetMsdAvaluos?wsdl");
		} catch (MalformedURLException e) {
			logger.warning(
					"Failed to create URL for the wsdl Location: 'http://150.100.210.236:36081/gesavaluos_mx_web/services/GetMsdAvaluos?wsdl', retrying as a local file");
			logger.warning(e.getMessage());
		}
		GETMSDAVALUOSSERVICE_WSDL_LOCATION = url;
	}

	public GetMsdAvaluosService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public GetMsdAvaluosService() {
		super(GETMSDAVALUOSSERVICE_WSDL_LOCATION, new QName("http://processmsd", "GetMsdAvaluosService"));
	}

	/**
	 * 
	 * @return returns GetMsdAvaluos
	 */
	@WebEndpoint(name = "GetMsdAvaluos")
	public GetMsdAvaluos getGetMsdAvaluos() {
		return super.getPort(new QName("http://processmsd", "GetMsdAvaluos"), GetMsdAvaluos.class);
	}

}
