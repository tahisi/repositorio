//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//

package syc.bbva.firmadig.ws.cliente;

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
 *         &lt;element name="arg_0_1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="arg_1_1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="arg_2_1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "arg01", "arg11", "arg21" })
@XmlRootElement(name = "envioArchivosBytes")
public class EnvioArchivosBytes {

	@XmlElement(name = "arg_0_1", required = true, nillable = true)
	protected String arg01;
	@XmlElement(name = "arg_1_1", required = true, nillable = true)
	protected String arg11;
	@XmlElement(name = "arg_2_1", required = true, nillable = true)
	protected String arg21;

	/**
	 * Gets the value of the arg01 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getArg01() {
		return arg01;
	}

	/**
	 * Sets the value of the arg01 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setArg01(String value) {
		this.arg01 = value;
	}

	/**
	 * Gets the value of the arg11 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getArg11() {
		return arg11;
	}

	/**
	 * Sets the value of the arg11 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setArg11(String value) {
		this.arg11 = value;
	}

	/**
	 * Gets the value of the arg21 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getArg21() {
		return arg21;
	}

	/**
	 * Sets the value of the arg21 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setArg21(String value) {
		this.arg21 = value;
	}

}
