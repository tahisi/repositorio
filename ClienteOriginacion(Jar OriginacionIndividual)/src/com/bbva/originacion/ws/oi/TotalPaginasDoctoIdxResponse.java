
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
 *         &lt;element name="totalPaginasDoctoIdxReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "totalPaginasDoctoIdxReturn" })
@XmlRootElement(name = "totalPaginasDoctoIdxResponse")
public class TotalPaginasDoctoIdxResponse {

	@XmlElement(required = true, nillable = true)
	protected String totalPaginasDoctoIdxReturn;

	/**
	 * Gets the value of the totalPaginasDoctoIdxReturn property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTotalPaginasDoctoIdxReturn() {
		return totalPaginasDoctoIdxReturn;
	}

	/**
	 * Sets the value of the totalPaginasDoctoIdxReturn property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTotalPaginasDoctoIdxReturn(String value) {
		this.totalPaginasDoctoIdxReturn = value;
	}

}
