
package syc.bbva.app.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for servicioGlobal complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="servicioGlobal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="genericFile" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="listaCampos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listaValores" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "servicioGlobal", propOrder = { "genericFile", "listaCampos", "listaValores" })
public class ServicioGlobal {

	@XmlElementRef(name = "genericFile", type = JAXBElement.class)
	protected JAXBElement<byte[]> genericFile;
	protected String listaCampos;
	protected String listaValores;

	/**
	 * Gets the value of the genericFile property.
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link byte[]}
	 *         {@code >}
	 * 
	 */
	public JAXBElement<byte[]> getGenericFile() {
		return genericFile;
	}

	/**
	 * Sets the value of the genericFile property.
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link byte[]}
	 *            {@code >}
	 * 
	 */
	public void setGenericFile(JAXBElement<byte[]> value) {
		this.genericFile = ((JAXBElement<byte[]>) value);
	}

	/**
	 * Gets the value of the listaCampos property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getListaCampos() {
		return listaCampos;
	}

	/**
	 * Sets the value of the listaCampos property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setListaCampos(String value) {
		this.listaCampos = value;
	}

	/**
	 * Gets the value of the listaValores property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getListaValores() {
		return listaValores;
	}

	/**
	 * Sets the value of the listaValores property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setListaValores(String value) {
		this.listaValores = value;
	}

}
