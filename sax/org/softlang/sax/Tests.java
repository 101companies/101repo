package org.softlang.sax;

import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

    @Test
	public void testTrace() throws Exception {
		Trace handler = new Trace();
		SAXUtilities.parse(handler, "sampleCompany.xml");
	}
		
    @Test
	public void testTotal() throws Exception {
		Total handler = new Total();
		SAXUtilities.parse(handler, "sampleCompany.xml");
	    assertEquals(399747, handler.getTotal(), 0);		
	}
	
    @Test
    public void testCut() throws Exception {
    	Cut handler1 = new Cut("output.xml");
    	SAXUtilities.parse(handler1, "sampleCompany.xml");
		Total handler2 = new Total();
		SAXUtilities.parse(handler2, "output.xml");
	    assertEquals(199873.5, handler2.getTotal(), 0);		
    }    
    
    @Test
    public void testValidate() {
     	assertTrue(Validator.validate("sampleCompany.xml", "Company.xsd"));
     	assertTrue(Validator.validate("output.xml", "Company.xsd")); 	
    }    
}
