package org.softlang.tests;

import org.softlang.company.*;
import org.softlang.features.Cut;
import org.softlang.features.Total;
import static org.softlang.features.Serialization.*;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class Operations {

	private static String sampleCompany = "sampleCompany.xml";
	private Company c;
	
	@Before
	public void initCompany() throws JAXBException {
		File sample = new File(sampleCompany);
		c = readCompany(sample);		
	}
		
	@Test
	public void testTotal() 
	throws 
		JAXBException,
		FileNotFoundException,
		XMLStreamException 
	{
		double total = Total.total(c);
	    assertEquals(399747, total, 0);
	}	    
	    
	@Test
	public void testCut() 
	throws 
		JAXBException,
		FileNotFoundException,
		XMLStreamException 
	{
	    Cut.cut(c);
		File tmp = new File("sampleCompany.tmp");
		writeCompany(tmp, c);		
		c = readCompany(tmp);		
	    Double total = Total.total(c);
	    assertEquals(399747 / 2.0d, total, 0);
	    tmp.delete();
	}
}
