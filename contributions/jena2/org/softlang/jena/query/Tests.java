package org.softlang.jena.query;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.softlang.company.CompanyModel;
import org.softlang.jena.query.Containment;
import org.softlang.jena.query.Total;

import com.hp.hpl.jena.rdf.model.Resource;

public class Tests {

	public final String filename =
		  ".." + File.separator
		+ "jena" + File.separator
		+ "sampleCompany.rdf";
	public CompanyModel sampleCompany = new CompanyModel();

	@Before
	public void setUp() throws FileNotFoundException {
		sampleCompany.getModel().read(new FileInputStream(filename), null);
	}

	@Test
	public void testTotal() throws SQLException {
		double preCutTotal = Total.total(sampleCompany);
		assertEquals(399747, preCutTotal, 0.0);
	}

	@Test
	public void testContainment() {
		assertTrue(Containment.checkContainment(sampleCompany));
		// add the manager of the research department also to the development
		// department (as employee)
		Resource craig = sampleCompany.getModel()
				.getResource(sampleCompany.NS_COMPANY + "craig");
		sampleCompany.getModel()
				.getResource(sampleCompany.NS_COMPANY + "development")
					.getProperty(sampleCompany.EMPLOYEES)
						.getBag()
							.add(craig);
		
		assertFalse(Containment.checkContainment(sampleCompany));
	}
}
