package org.softlang.xpath;

import java.io.File;

import org.junit.Test;
import org.w3c.dom.Document;

import static org.junit.Assert.*;

public class Tests {

	private static String sampleCompany =
		  ".." + File.separator
		+ "sax" + File.separator
		+ "sampleCompany.xml";

    @Test
	public void testTotal() throws Exception {
    	Document doc = DOMUtilities.loadDocument(sampleCompany);
    	double total = Total.aggregate(doc);
    	assertEquals(399747, total, 0);
 	}
	
    @Test
    public void testCut() throws Exception {
    	Document doc = DOMUtilities.loadDocument(sampleCompany);
    	Cut.transform(doc);
    	double total = Total.aggregate(doc);
    	assertEquals(199873.5, total, 0);
    }    

    @Test
    public void testCutManagers() throws Exception {
    	Document doc = DOMUtilities.loadDocument(sampleCompany);
    	CutManagers.transform(doc);
    	double total = Total.aggregate(doc);
    	assertEquals(207835.0, total, 0);
	}
}
