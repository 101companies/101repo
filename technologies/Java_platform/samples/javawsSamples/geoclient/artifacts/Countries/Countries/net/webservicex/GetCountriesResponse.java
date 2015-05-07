
package net.webservicex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetCountriesResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCountriesResult"
})
@XmlRootElement(name = "GetCountriesResponse")
public class GetCountriesResponse {

    @XmlElement(name = "GetCountriesResult")
    protected String getCountriesResult;

    /**
     * Gets the value of the getCountriesResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetCountriesResult() {
        return getCountriesResult;
    }

    /**
     * Sets the value of the getCountriesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetCountriesResult(String value) {
        this.getCountriesResult = value;
    }

}
