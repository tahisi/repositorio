
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
 *         &lt;element name="gaveta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lista_campos" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lista_valores" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="archivo" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "gaveta", "listaCampos", "listaValores", "archivo" })
@XmlRootElement(name = "recibeArchivosIdx")
public class RecibeArchivosIdx {

	@XmlElement(required = true, nillable = true)
	protected String gaveta;
	@XmlElement(name = "lista_campos", required = true, nillable = true)
	protected String listaCampos;
	@XmlElement(name = "lista_valores", required = true, nillable = true)
	protected String listaValores;
	@XmlElement(required = true)
	protected byte[] archivo;

	/**
	 * Gets the value of the gaveta property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGaveta() {
		return gaveta;
	}

	/**
	 * Sets the value of the gaveta property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGaveta(String value) {
		this.gaveta = value;
	}

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
	 * Gets the value of the archivo property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getArchivo() {
		return archivo;
	}

	/**
	 * Sets the value of the archivo property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setArchivo(byte[] value) {
		this.archivo = ((byte[]) value);
	}

}
