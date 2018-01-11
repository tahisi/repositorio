
package com.bbva.live.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for enviaExpediente complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="enviaExpediente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documento" type="{http://ws.live.bbva.com/}documentoBean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enviaExpediente", propOrder = { "documento" })
public class EnviaExpediente {

	@XmlElement(required = true)
	protected DocumentoBean documento;

	/**
	 * Gets the value of the documento property.
	 * 
	 * @return possible object is {@link DocumentoBean }
	 * 
	 */
	public DocumentoBean getDocumento() {
		return documento;
	}

	/**
	 * Sets the value of the documento property.
	 * 
	 * @param value
	 *            allowed object is {@link DocumentoBean }
	 * 
	 */
	public void setDocumento(DocumentoBean value) {
		this.documento = value;
	}

}
