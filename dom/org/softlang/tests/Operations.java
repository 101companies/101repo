package org.softlang.tests;

import org.softlang.dom.Cut;
import org.softlang.dom.DOMUtilities;
import org.softlang.dom.Total;
import org.w3c.dom.Document;
import org.junit.Test;

import static org.junit.Assert.*;

public class Operations {
		
	private static String sampleCompany = "sampleCompany.xml";
	
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
