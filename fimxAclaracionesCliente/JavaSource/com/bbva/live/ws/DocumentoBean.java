
package com.bbva.live.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for documentoBean complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="documentoBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="archivo" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="cve_docto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="folio_aclaracion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nb_archivo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nb_documento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nu_cliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="titulo_aplicacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documentoBean", propOrder = { "archivo", "cveDocto", "descripcion", "extension", "folioAclaracion",
		"nbArchivo", "nbDocumento", "nuCliente", "tituloAplicacion", "usuario", "version" })
public class DocumentoBean {

	@XmlElement(required = true)
	protected byte[] archivo;
	@XmlElement(name = "cve_docto")
	protected String cveDocto;
	@XmlElement(required = true)
	protected String descripcion;
	@XmlElement(required = true)
	protected String extension;
	@XmlElement(name = "folio_aclaracion", required = true)
	protected String folioAclaracion;
	@XmlElement(name = "nb_archivo", required = true)
	protected String nbArchivo;
	@XmlElement(name = "nb_documento", required = true)
	protected String nbDocumento;
	@XmlElement(name = "nu_cliente", required = true)
	protected String nuCliente;
	@XmlElement(name = "titulo_aplicacion", required = true)
	protected String tituloAplicacion;
	@XmlElement(required = true)
	protected String usuario;
	protected int version;

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

	/**
	 * Gets the value of the cveDocto property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCveDocto() {
		return cveDocto;
	}

	/**
	 * Sets the value of the cveDocto property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCveDocto(String value) {
		this.cveDocto = value;
	}

	/**
	 * Gets the value of the descripcion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Sets the value of the descripcion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescripcion(String value) {
		this.descripcion = value;
	}

	/**
	 * Gets the value of the extension property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * Sets the value of the extension property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExtension(String value) {
		this.extension = value;
	}

	/**
	 * Gets the value of the folioAclaracion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFolioAclaracion() {
		return folioAclaracion;
	}

	/**
	 * Sets the value of the folioAclaracion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFolioAclaracion(String value) {
		this.folioAclaracion = value;
	}

	/**
	 * Gets the value of the nbArchivo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNbArchivo() {
		return nbArchivo;
	}

	/**
	 * Sets the value of the nbArchivo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNbArchivo(String value) {
		this.nbArchivo = value;
	}

	/**
	 * Gets the value of the nbDocumento property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNbDocumento() {
		return nbDocumento;
	}

	/**
	 * Sets the value of the nbDocumento property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNbDocumento(String value) {
		this.nbDocumento = value;
	}

	/**
	 * Gets the value of the nuCliente property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNuCliente() {
		return nuCliente;
	}

	/**
	 * Sets the value of the nuCliente property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNuCliente(String value) {
		this.nuCliente = value;
	}

	/**
	 * Gets the value of the tituloAplicacion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTituloAplicacion() {
		return tituloAplicacion;
	}

	/**
	 * Sets the value of the tituloAplicacion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTituloAplicacion(String value) {
		this.tituloAplicacion = value;
	}

	/**
	 * Gets the value of the usuario property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Sets the value of the usuario property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUsuario(String value) {
		this.usuario = value;
	}

	/**
	 * Gets the value of the version property.
	 * 
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * Sets the value of the version property.
	 * 
	 */
	public void setVersion(int value) {
		this.version = value;
	}

}
