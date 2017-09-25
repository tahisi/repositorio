
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
 *         &lt;element name="envioImagenesIdxReturn" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "envioImagenesIdxReturn" })
@XmlRootElement(name = "envioImagenesIdxResponse")
public class EnvioImagenesIdxResponse {

	@XmlElement(required = true)
	protected byte[] envioImagenesIdxReturn;

	/**
	 * Gets the value of the envioImagenesIdxReturn property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getEnvioImagenesIdxReturn() {
		return envioImagenesIdxReturn;
	}

	/**
	 * Sets the value of the envioImagenesIdxReturn property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setEnvioImagenesIdxReturn(byte[] value) {
		this.envioImagenesIdxReturn = ((byte[]) value);
	}

}
