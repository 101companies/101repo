package org.softlang.tests;

import static org.softlang.operations.Cut.*;
import static org.softlang.operations.Total.*;

import org.softlang.operations.DOMUtilities;
import org.w3c.dom.Document;
import org.junit.Test;
import static org.junit.Assert.*;

public class Operations {
		
	private static String sampleCompany = "sampleCompany.xml";
	
    @Test
	public void testTotal() throws Exception {
    	Document doc = DOMUtilities.loadDocument(sampleCompany);
    	double total = total(doc);
    	assertEquals(399747, total, 0);
 	}
	
    @Test
    public void testCut() throws Exception {
    	Document doc = DOMUtilities.loadDocument(sampleCompany);
    	cut(doc);
    	double total = total(doc);
    	assertEquals(199873.5, total, 0);
    }    
}
