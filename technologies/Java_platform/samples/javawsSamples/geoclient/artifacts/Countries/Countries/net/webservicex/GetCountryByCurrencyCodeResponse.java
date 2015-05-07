
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
 *         &lt;element name="GetCountryByCurrencyCodeResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getCountryByCurrencyCodeResult"
})
@XmlRootElement(name = "GetCountryByCurrencyCodeResponse")
public class GetCountryByCurrencyCodeResponse {

    @XmlElement(name = "GetCountryByCurrencyCodeResult")
    protected String getCountryByCurrencyCodeResult;

    /**
     * Gets the value of the getCountryByCurrencyCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetCountryByCurrencyCodeResult() {
        return getCountryByCurrencyCodeResult;
    }

    /**
     * Sets the value of the getCountryByCurrencyCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetCountryByCurrencyCodeResult(String value) {
        this.getCountryByCurrencyCodeResult = value;
    }

}
