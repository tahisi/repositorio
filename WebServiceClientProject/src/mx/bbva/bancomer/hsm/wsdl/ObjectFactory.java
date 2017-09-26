package mx.bbva.bancomer.hsm.wsdl;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the mx.bbva.bancomer.hsm.wsdl package.
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

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: mx.bbva.bancomer.hsm.wsdl
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link DescifrarArchivoXMLResponse }
	 * 
	 */
	public DescifrarArchivoXMLResponse createDescifrarArchivoXMLResponse() {
		return new DescifrarArchivoXMLResponse();
	}

	/**
	 * Create an instance of {@link DescifrarArchivoXML }
	 * 
	 */
	public DescifrarArchivoXML createDescifrarArchivoXML() {
		return new DescifrarArchivoXML();
	}

	/**
	 * Create an instance of {@link CifrarArchivoXMLResponse }
	 * 
	 */
	public CifrarArchivoXMLResponse createCifrarArchivoXMLResponse() {
		return new CifrarArchivoXMLResponse();
	}

	/**
	 * Create an instance of {@link CifrarArchivoXML }
	 * 
	 */
	public CifrarArchivoXML createCifrarArchivoXML() {
		return new CifrarArchivoXML();
	}

}
