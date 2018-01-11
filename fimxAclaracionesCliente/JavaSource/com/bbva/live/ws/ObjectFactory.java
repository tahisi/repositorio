
package com.bbva.live.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.bbva.live.ws package.
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

	private final static QName _EnviaExpedienteResponse_QNAME = new QName("http://ws.live.bbva.com/",
			"enviaExpedienteResponse");
	private final static QName _GetDocumentoResponse_QNAME = new QName("http://ws.live.bbva.com/",
			"getDocumentoResponse");
	private final static QName _EnviaExpediente_QNAME = new QName("http://ws.live.bbva.com/", "enviaExpediente");
	private final static QName _GetDocumento_QNAME = new QName("http://ws.live.bbva.com/", "getDocumento");
	private final static QName _GetDocumentoResponseReturn_QNAME = new QName("", "return");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.bbva.live.ws
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link GetDocumentoResponse }
	 * 
	 */
	public GetDocumentoResponse createGetDocumentoResponse() {
		return new GetDocumentoResponse();
	}

	/**
	 * Create an instance of {@link GetDocumento }
	 * 
	 */
	public GetDocumento createGetDocumento() {
		return new GetDocumento();
	}

	/**
	 * Create an instance of {@link EnviaExpediente }
	 * 
	 */
	public EnviaExpediente createEnviaExpediente() {
		return new EnviaExpediente();
	}

	/**
	 * Create an instance of {@link WsExpediente }
	 * 
	 */
	public WsExpediente createWsExpediente() {
		return new WsExpediente();
	}

	/**
	 * Create an instance of {@link DocumentoBean }
	 * 
	 */
	public DocumentoBean createDocumentoBean() {
		return new DocumentoBean();
	}

	/**
	 * Create an instance of {@link EnviaExpedienteResponse }
	 * 
	 */
	public EnviaExpedienteResponse createEnviaExpedienteResponse() {
		return new EnviaExpedienteResponse();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link EnviaExpedienteResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://ws.live.bbva.com/", name = "enviaExpedienteResponse")
	public JAXBElement<EnviaExpedienteResponse> createEnviaExpedienteResponse(EnviaExpedienteResponse value) {
		return new JAXBElement<EnviaExpedienteResponse>(_EnviaExpedienteResponse_QNAME, EnviaExpedienteResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDocumentoResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://ws.live.bbva.com/", name = "getDocumentoResponse")
	public JAXBElement<GetDocumentoResponse> createGetDocumentoResponse(GetDocumentoResponse value) {
		return new JAXBElement<GetDocumentoResponse>(_GetDocumentoResponse_QNAME, GetDocumentoResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link EnviaExpediente
	 * }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://ws.live.bbva.com/", name = "enviaExpediente")
	public JAXBElement<EnviaExpediente> createEnviaExpediente(EnviaExpediente value) {
		return new JAXBElement<EnviaExpediente>(_EnviaExpediente_QNAME, EnviaExpediente.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetDocumento }
	 * {@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://ws.live.bbva.com/", name = "getDocumento")
	public JAXBElement<GetDocumento> createGetDocumento(GetDocumento value) {
		return new JAXBElement<GetDocumento>(_GetDocumento_QNAME, GetDocumento.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}
	 * {@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "", name = "return", scope = GetDocumentoResponse.class)
	public JAXBElement<byte[]> createGetDocumentoResponseReturn(byte[] value) {
		return new JAXBElement<byte[]>(_GetDocumentoResponseReturn_QNAME, byte[].class, GetDocumentoResponse.class,
				((byte[]) value));
	}

}
