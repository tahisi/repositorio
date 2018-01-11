
package processmsd;

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
 *         &lt;element name="CADENABASE64" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FOLIOEXPEDIENTE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TipoArchivo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Extesion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Aplicacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "cadenabase64", "folioexpediente", "tipoArchivo", "extesion", "aplicacion" })
@XmlRootElement(name = "addFile")
public class AddFile {

	@XmlElement(name = "CADENABASE64", required = true)
	protected String cadenabase64;
	@XmlElement(name = "FOLIOEXPEDIENTE", required = true)
	protected String folioexpediente;
	@XmlElement(name = "TipoArchivo", required = true)
	protected String tipoArchivo;
	@XmlElement(name = "Extesion", required = true)
	protected String extesion;
	@XmlElement(name = "Aplicacion", required = true)
	protected String aplicacion;

	/**
	 * Gets the value of the cadenabase64 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCADENABASE64() {
		return cadenabase64;
	}

	/**
	 * Sets the value of the cadenabase64 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCADENABASE64(String value) {
		this.cadenabase64 = value;
	}

	/**
	 * Gets the value of the folioexpediente property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFOLIOEXPEDIENTE() {
		return folioexpediente;
	}

	/**
	 * Sets the value of the folioexpediente property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFOLIOEXPEDIENTE(String value) {
		this.folioexpediente = value;
	}

	/**
	 * Gets the value of the tipoArchivo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTipoArchivo() {
		return tipoArchivo;
	}

	/**
	 * Sets the value of the tipoArchivo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTipoArchivo(String value) {
		this.tipoArchivo = value;
	}

	/**
	 * Gets the value of the extesion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExtesion() {
		return extesion;
	}

	/**
	 * Sets the value of the extesion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExtesion(String value) {
		this.extesion = value;
	}

	/**
	 * Gets the value of the aplicacion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAplicacion() {
		return aplicacion;
	}

	/**
	 * Sets the value of the aplicacion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAplicacion(String value) {
		this.aplicacion = value;
	}

}
