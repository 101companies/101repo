package org.softlang.testing;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import nu.xom.Builder;
import nu.xom.Element;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.junit.Before;
import org.junit.Test;
import org.softlang.Cut;
import org.softlang.Total;

public class Tests {

	public Element docRoot;

	@Before
	public void init() throws ValidityException, ParsingException, IOException {
		docRoot = new Builder().build(
				new File(".." + File.separator + "sax" + File.separator
						+ "sampleCompany.xml")).getRootElement();
	}

	@Test
	public void testTotal() {
		double total = Total.total(docRoot);
		assertEquals(399747.0, total, 0.0);
	}

	@Test
	public void testCut() {
		double preCutSalary = Total.total(docRoot);
		Cut.cut(docRoot);
		double newSalary = Total.total(docRoot);
		assertEquals(preCutSalary / 2, newSalary, 0.0);
	}

}
