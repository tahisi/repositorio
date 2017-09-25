
package com.bbva.originacion.ws.oi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for WSPagina complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="WSPagina">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tituloAplicacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idGabinete" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idCarpetaPadre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idDocumento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numeroPagina" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="volumen" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoVolumen" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nomArchivoVol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nomArchivoOrg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoPagina" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="anotaciones" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estadoPagina" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tamanoBytes" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="unidadDisco" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rutaBase" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rutaDirectorio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSPagina", propOrder = { "tituloAplicacion", "idGabinete", "idCarpetaPadre", "idDocumento",
		"numeroPagina", "volumen", "tipoVolumen", "nomArchivoVol", "nomArchivoOrg", "tipoPagina", "anotaciones",
		"estadoPagina", "tamanoBytes", "unidadDisco", "rutaBase", "rutaDirectorio" })
public class WSPagina {

	@XmlElement(required = true, nillable = true)
	protected String tituloAplicacion;
	protected int idGabinete;
	protected int idCarpetaPadre;
	protected int idDocumento;
	protected int numeroPagina;
	@XmlElement(required = true, nillable = true)
	protected String volumen;
	@XmlElement(required = true, nillable = true)
	protected String tipoVolumen;
	@XmlElement(required = true, nillable = true)
	protected String nomArchivoVol;
	@XmlElement(required = true, nillable = true)
	protected String nomArchivoOrg;
	@XmlElement(required = true, nillable = true)
	protected String tipoPagina;
	@XmlElement(required = true, nillable = true)
	protected String anotaciones;
	@XmlElement(required = true, nillable = true)
	protected String estadoPagina;
	protected double tamanoBytes;
	@XmlElement(required = true, nillable = true)
	protected String unidadDisco;
	@XmlElement(required = true, nillable = true)
	protected String rutaBase;
	@XmlElement(required = true, nillable = true)
	protected String rutaDirectorio;

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
	 * Gets the value of the numeroPagina property.
	 * 
	 */
	public int getNumeroPagina() {
		return numeroPagina;
	}

	/**
	 * Sets the value of the numeroPagina property.
	 * 
	 */
	public void setNumeroPagina(int value) {
		this.numeroPagina = value;
	}

	/**
	 * Gets the value of the volumen property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVolumen() {
		return volumen;
	}

	/**
	 * Sets the value of the volumen property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVolumen(String value) {
		this.volumen = value;
	}

	/**
	 * Gets the value of the tipoVolumen property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTipoVolumen() {
		return tipoVolumen;
	}

	/**
	 * Sets the value of the tipoVolumen property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTipoVolumen(String value) {
		this.tipoVolumen = value;
	}

	/**
	 * Gets the value of the nomArchivoVol property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNomArchivoVol() {
		return nomArchivoVol;
	}

	/**
	 * Sets the value of the nomArchivoVol property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNomArchivoVol(String value) {
		this.nomArchivoVol = value;
	}

	/**
	 * Gets the value of the nomArchivoOrg property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNomArchivoOrg() {
		return nomArchivoOrg;
	}

	/**
	 * Sets the value of the nomArchivoOrg property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNomArchivoOrg(String value) {
		this.nomArchivoOrg = value;
	}

	/**
	 * Gets the value of the tipoPagina property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTipoPagina() {
		return tipoPagina;
	}

	/**
	 * Sets the value of the tipoPagina property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTipoPagina(String value) {
		this.tipoPagina = value;
	}

	/**
	 * Gets the value of the anotaciones property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAnotaciones() {
		return anotaciones;
	}

	/**
	 * Sets the value of the anotaciones property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAnotaciones(String value) {
		this.anotaciones = value;
	}

	/**
	 * Gets the value of the estadoPagina property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEstadoPagina() {
		return estadoPagina;
	}

	/**
	 * Sets the value of the estadoPagina property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEstadoPagina(String value) {
		this.estadoPagina = value;
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
	 * Gets the value of the unidadDisco property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUnidadDisco() {
		return unidadDisco;
	}

	/**
	 * Sets the value of the unidadDisco property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUnidadDisco(String value) {
		this.unidadDisco = value;
	}

	/**
	 * Gets the value of the rutaBase property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRutaBase() {
		return rutaBase;
	}

	/**
	 * Sets the value of the rutaBase property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRutaBase(String value) {
		this.rutaBase = value;
	}

	/**
	 * Gets the value of the rutaDirectorio property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRutaDirectorio() {
		return rutaDirectorio;
	}

	/**
	 * Sets the value of the rutaDirectorio property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRutaDirectorio(String value) {
		this.rutaDirectorio = value;
	}

}
