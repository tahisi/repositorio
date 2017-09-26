package mx.bbva.bancomer.hsm.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import mx.bbva.bancomer.hsm.bean.UserBean;

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
 *         &lt;element name="nombreLlave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flujoEntrada" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="usuario" type="{http://bean.hsm.bancomer.bbva.mx}UserBean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "nombreLlave", "flujoEntrada", "usuario" })
@XmlRootElement(name = "descifrarArchivoXML")
public class DescifrarArchivoXML {

	@XmlElement(required = true)
	protected String nombreLlave;
	@XmlElement(required = true)
	protected byte[] flujoEntrada;
	@XmlElement(required = true)
	protected UserBean usuario;

	/**
	 * Gets the value of the nombreLlave property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNombreLlave() {
		return nombreLlave;
	}

	/**
	 * Sets the value of the nombreLlave property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNombreLlave(String value) {
		this.nombreLlave = value;
	}

	/**
	 * Gets the value of the flujoEntrada property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getFlujoEntrada() {
		return flujoEntrada;
	}

	/**
	 * Sets the value of the flujoEntrada property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setFlujoEntrada(byte[] value) {
		this.flujoEntrada = ((byte[]) value);
	}

	/**
	 * Gets the value of the usuario property.
	 * 
	 * @return possible object is {@link UserBean }
	 * 
	 */
	public UserBean getUsuario() {
		return usuario;
	}

	/**
	 * Sets the value of the usuario property.
	 * 
	 * @param value
	 *            allowed object is {@link UserBean }
	 * 
	 */
	public void setUsuario(UserBean value) {
		this.usuario = value;
	}

}
