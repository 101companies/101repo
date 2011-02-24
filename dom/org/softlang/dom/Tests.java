package org.softlang.dom;

import org.w3c.dom.Document;
import java.io.File;
import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {
		
	private static String sampleCompany =
		  ".." + File.separator
		+ "sax" + File.separator
		+ "sampleCompany.xml";
	
    @Test
	public void testTotal() throws Exception {
    	Document doc = DOMUtilities.loadDocument(sampleCompany);
    	double total = Total.total(doc);
    	assertEquals(399747, total, 0);
 	}
	
    @Test
    public void testCut() throws Exception {
    	Document doc = DOMUtilities.loadDocument(sampleCompany);
    	Cut.cut(doc);
    	double total = Total.total(doc);
    	assertEquals(199873.5, total, 0);
    }    
}
