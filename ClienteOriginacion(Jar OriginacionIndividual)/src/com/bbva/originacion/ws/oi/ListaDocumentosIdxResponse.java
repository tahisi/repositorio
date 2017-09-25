
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
 *         &lt;element name="listaDocumentosIdxReturn" type="{http://oi.ws.bancomer.com}ArrayOfArrayOf_xsd_nillable_string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "listaDocumentosIdxReturn" })
@XmlRootElement(name = "listaDocumentosIdxResponse")
public class ListaDocumentosIdxResponse {

	@XmlElement(required = true, nillable = true)
	protected ArrayOfArrayOfXsdNillableString listaDocumentosIdxReturn;

	/**
	 * Gets the value of the listaDocumentosIdxReturn property.
	 * 
	 * @return possible object is {@link ArrayOfArrayOfXsdNillableString }
	 * 
	 */
	public ArrayOfArrayOfXsdNillableString getListaDocumentosIdxReturn() {
		return listaDocumentosIdxReturn;
	}

	/**
	 * Sets the value of the listaDocumentosIdxReturn property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfArrayOfXsdNillableString }
	 * 
	 */
	public void setListaDocumentosIdxReturn(ArrayOfArrayOfXsdNillableString value) {
		this.listaDocumentosIdxReturn = value;
	}

}
