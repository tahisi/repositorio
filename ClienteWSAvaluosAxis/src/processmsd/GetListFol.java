
package processmsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FOLIOEXPEDIENTE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Aplicacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "folioexpediente", "aplicacion" })
@XmlRootElement(name = "getListFol")
public class GetListFol {

	@XmlElement(name = "FOLIOEXPEDIENTE", required = true)
	protected String folioexpediente;
	@XmlElement(name = "Aplicacion", required = true)
	protected String aplicacion;

	/**
	 * Gets the value of the folioexpediente property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFOLIOEXPEDIENTE() {
		return folioexpediente;
	}

	/**
	 * Sets the value of the folioexpediente property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFOLIOEXPEDIENTE(String value) {
		this.folioexpediente = value;
	}

	/**
	 * Gets the value of the aplicacion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAplicacion() {
		return aplicacion;
	}

	/**
	 * Sets the value of the aplicacion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAplicacion(String value) {
		this.aplicacion = value;
	}

}
