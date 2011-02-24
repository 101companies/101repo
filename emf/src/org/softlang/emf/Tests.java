package org.softlang.emf;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import company.Company;
import company.CompanyPackage;

public class Tests {

	public String XMIYEAR2008 = "samples" + File.separatorChar
			+ "sampleCompany2008.xmi";

	public String XMLYEAR2009 = "samples" + File.separatorChar
			+ "sampleCompany2009.xml";

	public ResourceSet resourceSet = new ResourceSetImpl();

	public Company company;

	@Before
	public void setUp() throws IOException {
		resourceSet.getPackageRegistry().put(CompanyPackage.eNS_URI,
				CompanyPackage.eINSTANCE);

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("xml", new XMLResourceFactoryImpl());

		// deserialize
		Resource input = resourceSet.createResource(URI
				.createFileURI(XMIYEAR2008));
		input.load(null);
		company = (Company) input.getContents().get(0);

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
				.createFileURI(XMLYEAR2009));
		resource.getContents().add(company);
		resource.save(null);
	}

}
