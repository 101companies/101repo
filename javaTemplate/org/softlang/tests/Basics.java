package org.softlang.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.softlang.company.Company;
import org.softlang.features.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Basics {
	
	private Company sampleCompany;
	
	/**
	 * Read (say, deserialize) a company
	 */
	public static Company readCompany(String filename) {

		Object o = null;

		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fis);
			o = in.readObject();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (Company) o;
	}	
		
	@Before
	public void loadSampleCompany() {
		sampleCompany = readCompany("sampleCompany.ser");
	}
	
	@Test
	public void testTotal() {
		Total total = new Total();
	    assertEquals(399747, total.reduce(sampleCompany), 0);
	}
	
	@Test
	public void testCut() {
		Total total = new Total();
		Cut cut = new Cut();
		double before = total.reduce(sampleCompany);
		cut.walk(sampleCompany);
		double after = total.reduce(sampleCompany);
		assertEquals(before / 2.0d, after, 0);
	}
}
