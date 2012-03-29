package org.softlang.tests;

import org.junit.Test;
import static org.softlang.operations.Total.*;
import static org.softlang.operations.Cut.*;
import org.w3c.dom.Document;
import org.softlang.dom.DOMUtilities;

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
    public void testCutAllEmployees() throws Exception {
    	Document doc = DOMUtilities.loadDocument(sampleCompany);
    	cutAllEmployees(doc);
    	double total = total(doc);
    	assertEquals(199873.5, total, 0);
    }    

    @Test
    public void testCutManagersOnly() throws Exception {
    	Document doc = DOMUtilities.loadDocument(sampleCompany);
    	cutManagersOnly(doc);
    	double total = total(doc);
    	assertEquals(207835.0, total, 0);
	}
}
