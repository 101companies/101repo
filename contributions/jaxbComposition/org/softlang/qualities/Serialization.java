package org.softlang.qualities;

import org.softlang.model.Company;

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

public class Serialization {
	
	private static JAXBContext jaxbContext;
	
	private static void initializeJaxbContext()
	throws JAXBException
	{
		if (jaxbContext==null)
			jaxbContext =
				JAXBContext.newInstance("org.softlang.model");
	}

	public static void serializeCompany(File output, Company c)
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
		
	public static Company deserializeCompany(File input)
	throws JAXBException 
	{
		initializeJaxbContext();
		Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
		return (Company) unMarshaller.unmarshal(input);		
	}

}
