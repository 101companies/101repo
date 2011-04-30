package org.softlang.tests;

import org.junit.Test;
import static org.junit.Assert.*;
import org.softlang.operations.Cut;
import org.softlang.operations.Total;
import static org.softlang.sax.SAXUtilities.*;

public class Operations {
		
    @Test
	public void testTotal() throws Exception {
		Total handler = new Total();
		parse(handler, "sampleCompany.xml");
	    assertEquals(399747, handler.getTotal(), 0);		
	}
	
    @Test
    public void testCut() throws Exception {
    	Cut handler1 = new Cut("output.xml");
    	parse(handler1, "sampleCompany.xml");
		Total handler2 = new Total();
		parse(handler2, "output.xml");
	    assertEquals(399747 / 2.0d, handler2.getTotal(), 0);		
    }    
}
