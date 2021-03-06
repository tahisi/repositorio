//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//

package syc.bbva.gestorremoto.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;



@WebServiceClient(name = "DigitalizacionService", targetNamespace = "http://ws.gestorRemoto.bbva.syc/", wsdlLocation = "http://150.250.235.63:36061/gestor_remoto_mx_web/DigitalizacionService/WEB-INF/wsdl/DigitalizacionService.wsdl")
public class DigitalizacionService extends Service {

	private final static URL DIGITALIZACIONSERVICE_WSDL_LOCATION;
	private final static Logger logger = Logger
			.getLogger(syc.bbva.gestorremoto.ws.DigitalizacionService.class
					.getName());

	static {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = syc.bbva.gestorremoto.ws.DigitalizacionService.class
					.getResource(".");
			url = new URL(
					baseUrl,
					"http://150.250.235.63:36061/gestor_remoto_mx_web/DigitalizacionService/WEB-INF/wsdl/DigitalizacionService.wsdl");
		} catch (MalformedURLException e) {
			logger.warning("Failed to create URL for the wsdl Location: 'http://150.250.235.63:36061/gestor_remoto_mx_web/DigitalizacionService/WEB-INF/wsdl/DigitalizacionService.wsdl', retrying as a local file");
			logger.warning(e.getMessage());
		}
		DIGITALIZACIONSERVICE_WSDL_LOCATION = url;
	}

	public DigitalizacionService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public DigitalizacionService() {
		super(DIGITALIZACIONSERVICE_WSDL_LOCATION, new QName(
				"http://ws.gestorRemoto.bbva.syc/", "DigitalizacionService"));
	}

	/**
	 * 
	 * @return returns DigitalizacionServiceDelegate
	 */
	@WebEndpoint(name = "DigitalizacionServicePort")
	public DigitalizacionServiceDelegate getDigitalizacionServicePort() {
		return super.getPort(new QName("http://ws.gestorRemoto.bbva.syc/",
				"DigitalizacionServicePort"),
				DigitalizacionServiceDelegate.class);
	}

}
