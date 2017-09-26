package mx.bbva.bancomer.hsm.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ResponseBean complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cifrado" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="descifrado" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="respuesta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseBean", propOrder = { "cifrado", "descifrado", "respuesta" })

@SuppressWarnings("serial")
public class ResponseBean  implements java.io.Serializable {
    
    	//private static final long serialVersionUID = 8993632574646955028L;
    	
	@XmlElement(required = true, nillable = true)
	protected byte[] cifrado;
	@XmlElement(required = true, nillable = true)
	protected byte[] descifrado;
	@XmlElement(required = true, nillable = true)
	protected String respuesta;

	/**
	 * Gets the value of the cifrado property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getCifrado() {
		return cifrado;
	}

	/**
	 * Sets the value of the cifrado property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setCifrado(byte[] value) {
		this.cifrado = ((byte[]) value);
	}

	/**
	 * Gets the value of the descifrado property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getDescifrado() {
		return descifrado;
	}

	/**
	 * Sets the value of the descifrado property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setDescifrado(byte[] value) {
		this.descifrado = ((byte[]) value);
	}

	/**
	 * Gets the value of the respuesta property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRespuesta() {
		return respuesta;
	}

	/**
	 * Sets the value of the respuesta property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRespuesta(String value) {
		this.respuesta = value;
	}

}
