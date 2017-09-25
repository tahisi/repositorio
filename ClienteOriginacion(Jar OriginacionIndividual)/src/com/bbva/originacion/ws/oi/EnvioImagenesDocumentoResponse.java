
package com.bbva.originacion.ws.oi;

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
 *         &lt;element name="envioImagenesDocumentoReturn" type="{http://oi.ws.bancomer.com}ArrayOf_xsd_base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "envioImagenesDocumentoReturn" })
@XmlRootElement(name = "envioImagenesDocumentoResponse")
public class EnvioImagenesDocumentoResponse {

	@XmlElement(required = true, nillable = true)
	protected ArrayOfXsdBase64Binary envioImagenesDocumentoReturn;

	/**
	 * Gets the value of the envioImagenesDocumentoReturn property.
	 * 
	 * @return possible object is {@link ArrayOfXsdBase64Binary }
	 * 
	 */
	public ArrayOfXsdBase64Binary getEnvioImagenesDocumentoReturn() {
		return envioImagenesDocumentoReturn;
	}

	/**
	 * Sets the value of the envioImagenesDocumentoReturn property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfXsdBase64Binary }
	 * 
	 */
	public void setEnvioImagenesDocumentoReturn(ArrayOfXsdBase64Binary value) {
		this.envioImagenesDocumentoReturn = value;
	}

}
