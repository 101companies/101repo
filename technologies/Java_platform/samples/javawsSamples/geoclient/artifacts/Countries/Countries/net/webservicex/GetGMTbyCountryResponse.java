
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
 *         &lt;element name="GetGMTbyCountryResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getGMTbyCountryResult"
})
@XmlRootElement(name = "GetGMTbyCountryResponse")
public class GetGMTbyCountryResponse {

    @XmlElement(name = "GetGMTbyCountryResult")
    protected String getGMTbyCountryResult;

    /**
     * Gets the value of the getGMTbyCountryResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetGMTbyCountryResult() {
        return getGMTbyCountryResult;
    }

    /**
     * Sets the value of the getGMTbyCountryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetGMTbyCountryResult(String value) {
        this.getGMTbyCountryResult = value;
    }

}
