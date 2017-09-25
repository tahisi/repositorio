
package com.bbva.originacion.ws.oi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for WSDocumento complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="WSDocumento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tituloAplicacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idGabinete" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idCarpetaPadre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idDocumento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreDocumento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombreUsuario" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prioridad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idTipoDocto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreTipoDocto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaCreacion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fechaModificacion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="numeroAccesos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numeroPaginas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="autor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="materia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="claseDocumento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoDocumento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="paginasDocumento" type="{http://oi.ws.bancomer.com}ArrayOfWSPagina"/>
 *         &lt;element name="tamanoBytes" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="compartir" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tokenCompartir" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="claveDocumento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSDocumento", propOrder = { "tituloAplicacion", "idGabinete", "idCarpetaPadre", "idDocumento",
		"nombreDocumento", "nombreUsuario", "prioridad", "idTipoDocto", "nombreTipoDocto", "fechaCreacion",
		"fechaModificacion", "numeroAccesos", "numeroPaginas", "titulo", "autor", "materia", "descripcion",
		"claseDocumento", "estadoDocumento", "extension", "paginasDocumento", "tamanoBytes", "compartir",
		"tokenCompartir", "claveDocumento" })
public class WSDocumento {

	@XmlElement(required = true, nillable = true)
	protected String tituloAplicacion;
	protected int idGabinete;
	protected int idCarpetaPadre;
	protected int idDocumento;
	@XmlElement(required = true, nillable = true)
	protected String nombreDocumento;
	@XmlElement(required = true, nillable = true)
	protected String nombreUsuario;
	protected int prioridad;
	protected int idTipoDocto;
	@XmlElement(required = true, nillable = true)
	protected String nombreTipoDocto;
	@XmlElement(required = true, nillable = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar fechaCreacion;
	@XmlElement(required = true, nillable = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar fechaModificacion;
	protected int numeroAccesos;
	protected int numeroPaginas;
	@XmlElement(required = true, nillable = true)
	protected String titulo;
	@XmlElement(required = true, nillable = true)
	protected String autor;
	@XmlElement(required = true, nillable = true)
	protected String materia;
	@XmlElement(required = true, nillable = true)
	protected String descripcion;
	protected int claseDocumento;
	@XmlElement(required = true, nillable = true)
	protected String estadoDocumento;
	@XmlElement(required = true, nillable = true)
	protected String extension;
	@XmlElement(required = true, nillable = true)
	protected ArrayOfWSPagina paginasDocumento;
	protected double tamanoBytes;
	@XmlElement(required = true, nillable = true)
	protected String compartir;
	@XmlElement(required = true, nillable = true)
	protected String tokenCompartir;
	@XmlElement(required = true, nillable = true)
	protected String claveDocumento;

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
	 * Gets the value of the idGabinete property.
	 * 
	 */
	public int getIdGabinete() {
		return idGabinete;
	}

	/**
	 * Sets the value of the idGabinete property.
	 * 
	 */
	public void setIdGabinete(int value) {
		this.idGabinete = value;
	}

	/**
	 * Gets the value of the idCarpetaPadre property.
	 * 
	 */
	public int getIdCarpetaPadre() {
		return idCarpetaPadre;
	}

	/**
	 * Sets the value of the idCarpetaPadre property.
	 * 
	 */
	public void setIdCarpetaPadre(int value) {
		this.idCarpetaPadre = value;
	}

	/**
	 * Gets the value of the idDocumento property.
	 * 
	 */
	public int getIdDocumento() {
		return idDocumento;
	}

	/**
	 * Sets the value of the idDocumento property.
	 * 
	 */
	public void setIdDocumento(int value) {
		this.idDocumento = value;
	}

	/**
	 * Gets the value of the nombreDocumento property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNombreDocumento() {
		return nombreDocumento;
	}

	/**
	 * Sets the value of the nombreDocumento property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNombreDocumento(String value) {
		this.nombreDocumento = value;
	}

	/**
	 * Gets the value of the nombreUsuario property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * Sets the value of the nombreUsuario property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNombreUsuario(String value) {
		this.nombreUsuario = value;
	}

	/**
	 * Gets the value of the prioridad property.
	 * 
	 */
	public int getPrioridad() {
		return prioridad;
	}

	/**
	 * Sets the value of the prioridad property.
	 * 
	 */
	public void setPrioridad(int value) {
		this.prioridad = value;
	}

	/**
	 * Gets the value of the idTipoDocto property.
	 * 
	 */
	public int getIdTipoDocto() {
		return idTipoDocto;
	}

	/**
	 * Sets the value of the idTipoDocto property.
	 * 
	 */
	public void setIdTipoDocto(int value) {
		this.idTipoDocto = value;
	}

	/**
	 * Gets the value of the nombreTipoDocto property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNombreTipoDocto() {
		return nombreTipoDocto;
	}

	/**
	 * Sets the value of the nombreTipoDocto property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNombreTipoDocto(String value) {
		this.nombreTipoDocto = value;
	}

	/**
	 * Gets the value of the fechaCreacion property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Sets the value of the fechaCreacion property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setFechaCreacion(XMLGregorianCalendar value) {
		this.fechaCreacion = value;
	}

	/**
	 * Gets the value of the fechaModificacion property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * Sets the value of the fechaModificacion property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setFechaModificacion(XMLGregorianCalendar value) {
		this.fechaModificacion = value;
	}

	/**
	 * Gets the value of the numeroAccesos property.
	 * 
	 */
	public int getNumeroAccesos() {
		return numeroAccesos;
	}

	/**
	 * Sets the value of the numeroAccesos property.
	 * 
	 */
	public void setNumeroAccesos(int value) {
		this.numeroAccesos = value;
	}

	/**
	 * Gets the value of the numeroPaginas property.
	 * 
	 */
	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * Sets the value of the numeroPaginas property.
	 * 
	 */
	public void setNumeroPaginas(int value) {
		this.numeroPaginas = value;
	}

	/**
	 * Gets the value of the titulo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Sets the value of the titulo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTitulo(String value) {
		this.titulo = value;
	}

	/**
	 * Gets the value of the autor property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Sets the value of the autor property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAutor(String value) {
		this.autor = value;
	}

	/**
	 * Gets the value of the materia property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMateria() {
		return materia;
	}

	/**
	 * Sets the value of the materia property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMateria(String value) {
		this.materia = value;
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
	 * Gets the value of the claseDocumento property.
	 * 
	 */
	public int getClaseDocumento() {
		return claseDocumento;
	}

	/**
	 * Sets the value of the claseDocumento property.
	 * 
	 */
	public void setClaseDocumento(int value) {
		this.claseDocumento = value;
	}

	/**
	 * Gets the value of the estadoDocumento property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEstadoDocumento() {
		return estadoDocumento;
	}

	/**
	 * Sets the value of the estadoDocumento property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEstadoDocumento(String value) {
		this.estadoDocumento = value;
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
	 * Gets the value of the paginasDocumento property.
	 * 
	 * @return possible object is {@link ArrayOfWSPagina }
	 * 
	 */
	public ArrayOfWSPagina getPaginasDocumento() {
		return paginasDocumento;
	}

	/**
	 * Sets the value of the paginasDocumento property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfWSPagina }
	 * 
	 */
	public void setPaginasDocumento(ArrayOfWSPagina value) {
		this.paginasDocumento = value;
	}

	/**
	 * Gets the value of the tamanoBytes property.
	 * 
	 */
	public double getTamanoBytes() {
		return tamanoBytes;
	}

	/**
	 * Sets the value of the tamanoBytes property.
	 * 
	 */
	public void setTamanoBytes(double value) {
		this.tamanoBytes = value;
	}

	/**
	 * Gets the value of the compartir property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCompartir() {
		return compartir;
	}

	/**
	 * Sets the value of the compartir property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCompartir(String value) {
		this.compartir = value;
	}

	/**
	 * Gets the value of the tokenCompartir property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTokenCompartir() {
		return tokenCompartir;
	}

	/**
	 * Sets the value of the tokenCompartir property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTokenCompartir(String value) {
		this.tokenCompartir = value;
	}

	/**
	 * Gets the value of the claveDocumento property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getClaveDocumento() {
		return claveDocumento;
	}

	/**
	 * Sets the value of the claveDocumento property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setClaveDocumento(String value) {
		this.claveDocumento = value;
	}

}
