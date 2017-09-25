
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
 *         &lt;element name="getDocumentoReturn" type="{http://oi.ws.bancomer.com}WSDocumento"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getDocumentoReturn" })
@XmlRootElement(name = "getDocumentoResponse")
public class GetDocumentoResponse {

	@XmlElement(required = true, nillable = true)
	protected WSDocumento getDocumentoReturn;

	/**
	 * Gets the value of the getDocumentoReturn property.
	 * 
	 * @return possible object is {@link WSDocumento }
	 * 
	 */
	public WSDocumento getGetDocumentoReturn() {
		return getDocumentoReturn;
	}

	/**
	 * Sets the value of the getDocumentoReturn property.
	 * 
	 * @param value
	 *            allowed object is {@link WSDocumento }
	 * 
	 */
	public void setGetDocumentoReturn(WSDocumento value) {
		this.getDocumentoReturn = value;
	}

}
