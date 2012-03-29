package org.softlang.features;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.softlang.company.Company;

public class Serialization {
	
	private static JAXBContext jaxbContext;
	
	public static void initializeJaxbContext()
	throws JAXBException
	{
		if (jaxbContext==null)
			jaxbContext =
				JAXBContext.newInstance("org.softlang.company");
	}
		
	public static Company readCompany(File input)
	throws JAXBException 
	{
		initializeJaxbContext();
		Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
		return (Company) unMarshaller.unmarshal(input);		
	}

	public static void writeCompany(File output, Company c)
	throws 	JAXBException,
			FileNotFoundException,
			XMLStreamException 
	{
		initializeJaxbContext();
	    OutputStream os = new FileOutputStream(output);
		Marshaller marshaller = jaxbContext.createMarshaller();
	    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = outputFactory.createXMLStreamWriter(os);
		marshaller.marshal(c, writer); // TODO: need a stream writer that does indentation		
	}
}
