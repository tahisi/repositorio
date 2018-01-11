
package com.bbva.live.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for enviaExpedienteResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="enviaExpedienteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.live.bbva.com/}wsExpediente" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enviaExpedienteResponse", propOrder = { "_return" })
public class EnviaExpedienteResponse {

	@XmlElement(name = "return")
	protected WsExpediente _return;

	/**
	 * Gets the value of the return property.
	 * 
	 * @return possible object is {@link WsExpediente }
	 * 
	 */
	public WsExpediente getReturn() {
		return _return;
	}

	/**
	 * Sets the value of the return property.
	 * 
	 * @param value
	 *            allowed object is {@link WsExpediente }
	 * 
	 */
	public void setReturn(WsExpediente value) {
		this._return = value;
	}

}
