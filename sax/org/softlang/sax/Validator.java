package org.softlang.sax;

import java.io.File;
import java.text.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * A SAX-based handler that print XSD-based validation errors
 */
public class Validator extends DefaultHandler {
	
	private boolean error = false;
	
	private static MessageFormat message = new MessageFormat("({0}: {1}, {2}): {3}");

	private void print(SAXParseException x) {
		error = true;
		String msg = message.format(new Object[] { 
				x.getSystemId(),
				new Integer(x.getLineNumber()),
				new Integer(x.getColumnNumber()),
				x.getMessage() });
		System.out.println(msg);
	}

	public void warning(SAXParseException x) {
		print(x);
	}

	public void error(SAXParseException x) {
		print(x);
	}

	public void fatalError(SAXParseException x) throws SAXParseException {
		print(x);
		throw x;
	}
	
	// Required constants
	private static final String SCHEMA_LANGUAGE =
		"http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	private static final String XML_SCHEMA =
		"http://www.w3.org/2001/XMLSchema";
	private static final String SCHEMA_SOURCE =
		"http://java.sun.com/xml/jaxp/properties/schemaSource";

	public static void printFailure(String xmlFile) {
		System.out.println("Validation failed for " + xmlFile);
	}
	
	public static void printSuccess(String xmlFile) {
		System.out.println("Validation succeeded for " + xmlFile);
	}
	
	public static boolean validate(String xmlFile, String xsdFile) {
		
		try {

			// Create a parser factory
			SAXParserFactory sf = SAXParserFactory.newInstance();
			sf.setNamespaceAware(true);
			sf.setValidating(true);
	
			// Create parser and let it do XSD-based validation
			SAXParser sp = sf.newSAXParser();
			sp.setProperty(SCHEMA_LANGUAGE, XML_SCHEMA);
			sp.setProperty(SCHEMA_SOURCE, xsdFile);

			// Validate by parsing
			Validator v = new Validator();
			sp.parse(new File(xmlFile), v);

			// Done
			if (v.error) {
				printFailure(xmlFile);
				return false;
			} else {
				printSuccess(xmlFile);
				return true;				
			}
 			
		} 
		catch (ParserConfigurationException e) {
			printFailure(xmlFile);
		}
		catch (SAXException e) {
			printFailure(xmlFile);
		}
		catch (Exception e) {
			printFailure(xmlFile);
		}
		return false;
	}
}
