package org.softlang.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.softlang.operations.Total.*;
import org.softlang.operations.Cut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Operations {

	private static String sampleCompany =
		"inputs" + File.separator + "sample.Company";
	
	@Test
	public void testTotal() throws FileNotFoundException {
		double total = total(sampleCompany);
    	assertEquals(399747, total, 0);
	}
	
	@Test
	public void testCut() throws IOException {
		Cut cut = new Cut();
		cut.cut(sampleCompany,"output.txt");
		double total = total("output.txt");
    	assertEquals(399747 / 2.0d, total, 0);
	}	
}
