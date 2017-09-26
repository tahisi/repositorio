package mx.bbva.bancomer.hsm.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import mx.bbva.bancomer.hsm.bean.ResponseBean;

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
 *         &lt;element name="cifrarArchivoXMLReturn" type="{http://bean.hsm.bancomer.bbva.mx}ResponseBean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "cifrarArchivoXMLReturn" })
@XmlRootElement(name = "cifrarArchivoXMLResponse")
public class CifrarArchivoXMLResponse {

	@XmlElement(required = true)
	protected ResponseBean cifrarArchivoXMLReturn;

	/**
	 * Gets the value of the cifrarArchivoXMLReturn property.
	 * 
	 * @return possible object is {@link ResponseBean }
	 * 
	 */
	public ResponseBean getCifrarArchivoXMLReturn() {
		return cifrarArchivoXMLReturn;
	}

	/**
	 * Sets the value of the cifrarArchivoXMLReturn property.
	 * 
	 * @param value
	 *            allowed object is {@link ResponseBean }
	 * 
	 */
	public void setCifrarArchivoXMLReturn(ResponseBean value) {
		this.cifrarArchivoXMLReturn = value;
	}

}
