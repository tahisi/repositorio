
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
 *         &lt;element name="addFileReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "addFileReturn" })
@XmlRootElement(name = "addFileResponse")
public class AddFileResponse {

	@XmlElement(required = true)
	protected String addFileReturn;

	/**
	 * Gets the value of the addFileReturn property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddFileReturn() {
		return addFileReturn;
	}

	/**
	 * Sets the value of the addFileReturn property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddFileReturn(String value) {
		this.addFileReturn = value;
	}

}