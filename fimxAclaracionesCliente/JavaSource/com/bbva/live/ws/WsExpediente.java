
package com.bbva.live.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsExpediente complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsExpediente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="folio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsExpediente", propOrder = { "codigo", "error", "folio" })
public class WsExpediente {

	protected String codigo;
	protected String error;
	protected String folio;

	/**
	 * Gets the value of the codigo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Sets the value of the codigo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCodigo(String value) {
		this.codigo = value;
	}

	/**
	 * Gets the value of the error property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getError() {
		return error;
	}

	/**
	 * Sets the value of the error property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setError(String value) {
		this.error = value;
	}

	/**
	 * Gets the value of the folio property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * Sets the value of the folio property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFolio(String value) {
		this.folio = value;
	}

}
