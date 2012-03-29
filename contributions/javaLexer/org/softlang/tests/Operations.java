package org.softlang.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.softlang.operations.Total;
import org.softlang.operations.Cut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Operations {

	private static String sampleCompany =
		"inputs" + File.separator + "sample.Company";

	@Test
	public void testTotal() throws FileNotFoundException {
		Total total = new Total(sampleCompany);
    	assertEquals(399747, total.getTotal(), 0);
	}
	
	@Test
	public void testCut() throws IOException {
		new Cut(sampleCompany,"output.txt");
		Total total = new Total("output.txt");
    	assertEquals(399747 / 2.0d, total.getTotal(), 0);
	}	
}
