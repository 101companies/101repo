package org.softlang.tests;

import org.softlang.behavior.Cut;
import org.softlang.behavior.Total;
import org.softlang.model.*;
import static org.softlang.qualities.Serialization.*;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class Behavior {

	private static String sampleCompany = "sampleCompany.xml";
	private Company c;
	
	@Before
	public void initCompany() throws JAXBException {
		File sample = new File(sampleCompany);
		c = deserializeCompany(sample);		
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
		serializeCompany(tmp, c);		
		c = deserializeCompany(tmp);		
	    Double total = Total.total(c);
	    assertEquals(399747 / 2.0d, total, 0);
	    tmp.delete();
	}
}
