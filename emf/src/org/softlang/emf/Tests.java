package org.softlang.emf;

import static org.junit.Assert.*;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import company.*;

public class Tests {

	public String cutCompany = "sampleCompanyCut.xml";

	public ResourceSet resourceSet = new ResourceSetImpl();

	public Company company;

	@Before
	public void setUp() throws IOException {
		company = SampleCompany.getSampleCompany();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMLResourceFactoryImpl());
	}

	@Test
	public void testCutAndTotal() {
		// total and cut
		double preCutTotal = Total.total(company);
		assertEquals(399747, preCutTotal, 0.0);
		System.out.println("Total salary = " + preCutTotal);
		System.out.println("Cutting...");
		Cut.cutCompany(company);
		double newTotal = Total.total(company);
		System.out.println("New total salary = " + newTotal);

		assertEquals(preCutTotal / 2, newTotal, 0.0);

	}

	@After
	public void serilize() throws IOException {
		// serialize
		Resource resource = resourceSet.createResource(URI
				.createFileURI(cutCompany));
		System.out.println(resource);
		resource.getContents().add(company);
		resource.save(null);
	}

}
