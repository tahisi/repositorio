
package syc.bbva.firdig.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the syc.bbva.digitalizacion.ws package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _ServicioGlobalResponse_QNAME = new QName("http://ws.digitalizacion.bbva.syc/",
			"servicioGlobalResponse");
	private final static QName _ServicioGlobal_QNAME = new QName("http://ws.digitalizacion.bbva.syc/",
			"servicioGlobal");
	private final static QName _ServicioGlobalGenericFile_QNAME = new QName("", "genericFile");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: syc.bbva.digitalizacion.ws
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link ServicioGlobal }
	 * 
	 */
	public ServicioGlobal createServicioGlobal() {
		return new ServicioGlobal();
	}

	/**
	 * Create an instance of {@link ServicioGlobalResponse }
	 * 
	 */
	public ServicioGlobalResponse createServicioGlobalResponse() {
		return new ServicioGlobalResponse();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ServicioGlobalResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://ws.digitalizacion.bbva.syc/", name = "servicioGlobalResponse")
	public JAXBElement<ServicioGlobalResponse> createServicioGlobalResponse(ServicioGlobalResponse value) {
		return new JAXBElement<ServicioGlobalResponse>(_ServicioGlobalResponse_QNAME, ServicioGlobalResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ServicioGlobal
	 * }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://ws.digitalizacion.bbva.syc/", name = "servicioGlobal")
	public JAXBElement<ServicioGlobal> createServicioGlobal(ServicioGlobal value) {
		return new JAXBElement<ServicioGlobal>(_ServicioGlobal_QNAME, ServicioGlobal.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}
	 * {@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "", name = "genericFile", scope = ServicioGlobal.class)
	public JAXBElement<byte[]> createServicioGlobalGenericFile(byte[] value) {
		return new JAXBElement<byte[]>(_ServicioGlobalGenericFile_QNAME, byte[].class, ServicioGlobal.class,
				((byte[]) value));
	}

}
