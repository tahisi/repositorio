//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//

package com.syc.bbva.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for recibeInformacion complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="recibeInformacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lista_campos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lista_valores" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="generic_file" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recibeInformacion", namespace = "http://ws.bbva.syc.com/", propOrder = {
		"listaCampos", "listaValores", "genericFile" })
public class RecibeInformacion {

	@XmlElement(name = "lista_campos")
	protected String listaCampos;
	@XmlElement(name = "lista_valores")
	protected String listaValores;
	@XmlElement(name = "generic_file")
	protected byte[] genericFile;

	/**
	 * Gets the value of the listaCampos property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getListaCampos() {
		return listaCampos;
	}

	/**
	 * Sets the value of the listaCampos property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setListaCampos(String value) {
		this.listaCampos = value;
	}

	/**
	 * Gets the value of the listaValores property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getListaValores() {
		return listaValores;
	}

	/**
	 * Sets the value of the listaValores property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setListaValores(String value) {
		this.listaValores = value;
	}

	/**
	 * Gets the value of the genericFile property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getGenericFile() {
		return genericFile;
	}

	/**
	 * Sets the value of the genericFile property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setGenericFile(byte[] value) {
		this.genericFile = ((byte[]) value);
	}

}
