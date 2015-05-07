
package net.webservicex;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.webservicex package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _String_QNAME = new QName("http://www.webserviceX.NET", "string");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.webservicex
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetISOCountryCodeByCountyName }
     * 
     */
    public GetISOCountryCodeByCountyName createGetISOCountryCodeByCountyName() {
        return new GetISOCountryCodeByCountyName();
    }

    /**
     * Create an instance of {@link GetCurrencyCodeByCurrencyNameResponse }
     * 
     */
    public GetCurrencyCodeByCurrencyNameResponse createGetCurrencyCodeByCurrencyNameResponse() {
        return new GetCurrencyCodeByCurrencyNameResponse();
    }

    /**
     * Create an instance of {@link GetCountryByCountryCodeResponse }
     * 
     */
    public GetCountryByCountryCodeResponse createGetCountryByCountryCodeResponse() {
        return new GetCountryByCountryCodeResponse();
    }

    /**
     * Create an instance of {@link GetISOCountryCodeByCountyNameResponse }
     * 
     */
    public GetISOCountryCodeByCountyNameResponse createGetISOCountryCodeByCountyNameResponse() {
        return new GetISOCountryCodeByCountyNameResponse();
    }

    /**
     * Create an instance of {@link GetCurrencyByCountryResponse }
     * 
     */
    public GetCurrencyByCountryResponse createGetCurrencyByCountryResponse() {
        return new GetCurrencyByCountryResponse();
    }

    /**
     * Create an instance of {@link GetCountriesResponse }
     * 
     */
    public GetCountriesResponse createGetCountriesResponse() {
        return new GetCountriesResponse();
    }

    /**
     * Create an instance of {@link GetCountryByCurrencyCode }
     * 
     */
    public GetCountryByCurrencyCode createGetCountryByCurrencyCode() {
        return new GetCountryByCurrencyCode();
    }

    /**
     * Create an instance of {@link GetGMTbyCountry }
     * 
     */
    public GetGMTbyCountry createGetGMTbyCountry() {
        return new GetGMTbyCountry();
    }

    /**
     * Create an instance of {@link GetGMTbyCountryResponse }
     * 
     */
    public GetGMTbyCountryResponse createGetGMTbyCountryResponse() {
        return new GetGMTbyCountryResponse();
    }

    /**
     * Create an instance of {@link GetCountryByCurrencyCodeResponse }
     * 
     */
    public GetCountryByCurrencyCodeResponse createGetCountryByCurrencyCodeResponse() {
        return new GetCountryByCurrencyCodeResponse();
    }

    /**
     * Create an instance of {@link GetCurrencyCodeByCurrencyName }
     * 
     */
    public GetCurrencyCodeByCurrencyName createGetCurrencyCodeByCurrencyName() {
        return new GetCurrencyCodeByCurrencyName();
    }

    /**
     * Create an instance of {@link GetCountryByCountryCode }
     * 
     */
    public GetCountryByCountryCode createGetCountryByCountryCode() {
        return new GetCountryByCountryCode();
    }

    /**
     * Create an instance of {@link GetISD }
     * 
     */
    public GetISD createGetISD() {
        return new GetISD();
    }

    /**
     * Create an instance of {@link GetCurrenciesResponse }
     * 
     */
    public GetCurrenciesResponse createGetCurrenciesResponse() {
        return new GetCurrenciesResponse();
    }

    /**
     * Create an instance of {@link GetCurrencyByCountry }
     * 
     */
    public GetCurrencyByCountry createGetCurrencyByCountry() {
        return new GetCurrencyByCountry();
    }

    /**
     * Create an instance of {@link GetCurrencyCode }
     * 
     */
    public GetCurrencyCode createGetCurrencyCode() {
        return new GetCurrencyCode();
    }

    /**
     * Create an instance of {@link GetCountries }
     * 
     */
    public GetCountries createGetCountries() {
        return new GetCountries();
    }

    /**
     * Create an instance of {@link GetCurrencies }
     * 
     */
    public GetCurrencies createGetCurrencies() {
        return new GetCurrencies();
    }

    /**
     * Create an instance of {@link GetCurrencyCodeResponse }
     * 
     */
    public GetCurrencyCodeResponse createGetCurrencyCodeResponse() {
        return new GetCurrencyCodeResponse();
    }

    /**
     * Create an instance of {@link GetISDResponse }
     * 
     */
    public GetISDResponse createGetISDResponse() {
        return new GetISDResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.webserviceX.NET", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

}
