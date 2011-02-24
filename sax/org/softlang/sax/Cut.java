package org.softlang.sax;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Cut extends DefaultHandler {

	private static String ns = "http://www.softlang.org/company.xsd";
	private static XMLOutputFactory factory = XMLOutputFactory.newInstance();
	private XMLStreamWriter writer;
	private boolean isSalary = false;
	private String lastNamespace = null;
	
	public Cut(String file)
	 	throws FileNotFoundException, XMLStreamException {
	   	writer = factory.createXMLStreamWriter(new FileOutputStream(file));		
	}
	
	@Override
	public void startDocument() throws SAXException {
		try {
			writer.writeStartDocument();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void endDocument() throws SAXException {
		try {
			writer.writeEndDocument();
			writer.close();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void startElement(String uri, String name, String qName,
			Attributes atts) {

		try {
			isSalary = (uri.equals(ns) && name.equals("salary"));
			writer.writeStartElement(name);
			if (!(uri.equals(lastNamespace))) {
				lastNamespace = uri;
				writer.setDefaultNamespace(uri);				
				writer.writeDefaultNamespace(uri);
			}
			for (int i = 0; i < atts.getLength(); i++) {
				writer.writeAttribute(atts.getLocalName(i), atts.getValue(i));
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void endElement(String uri, String name, String qName) {
		isSalary = false;
		try {
			writer.writeEndElement();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		try {
			if (isSalary) {
				String str = String.valueOf(ch, start, length);
				double salary = Double.parseDouble(str);
				writer.writeCharacters(String.valueOf(salary / 2));
			} else {
				writer.writeCharacters(String.valueOf(ch, start, length));
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}