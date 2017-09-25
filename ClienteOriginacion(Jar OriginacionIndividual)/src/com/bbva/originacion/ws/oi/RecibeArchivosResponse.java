
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
 *         &lt;element name="recibeArchivosReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "recibeArchivosReturn" })
@XmlRootElement(name = "recibeArchivosResponse")
public class RecibeArchivosResponse {

	@XmlElement(required = true, nillable = true)
	protected String recibeArchivosReturn;

	/**
	 * Gets the value of the recibeArchivosReturn property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRecibeArchivosReturn() {
		return recibeArchivosReturn;
	}

	/**
	 * Sets the value of the recibeArchivosReturn property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRecibeArchivosReturn(String value) {
		this.recibeArchivosReturn = value;
	}

}
