package pkg101;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.junit.Before;
import org.junit.Test;

public class Tests {

	public Document doc;

	@Before
	public void init() throws IOException, JDOMException {
		doc = (new SAXBuilder().build(new File("sampleCompany.xml")));
	}

	@Test
	public void testTotal() {
		double total = Total.total(doc);
		assertEquals(399747.0, total, 0.0);
	}

	@Test
	public void testCut() {
		double preCutSalary = Total.total(doc);
		Cut.cut(doc);
		double newSalary = Total.total(doc);
		assertEquals(preCutSalary/2, newSalary, 0.0);
	}
}
