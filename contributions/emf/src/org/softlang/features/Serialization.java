package org.softlang.features;

import java.io.IOException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import company.Company;
import company.CompanyPackage;

public class Serialization {

	private static ResourceSet resourceSet;
	
	/*
	 * construct a resource set for .xmi and .xml files
	 */
	private static ResourceSet getResourceSet() {
		if (resourceSet==null) {

			// Register package for model
			// http://eclipsedriven.blogspot.com/2010/12/fixing-emfecorexmi-resource-loading.html
			EPackage.
				Registry.
				INSTANCE.
				put(CompanyPackage.eNS_URI, CompanyPackage.eINSTANCE);
			
			// Construct resource set
			resourceSet = new ResourceSetImpl();
	
			// Handle .xmi
			resourceSet.
				getResourceFactoryRegistry().
				getExtensionToFactoryMap().
				put("xmi", new XMIResourceFactoryImpl());
			
			// Handle .xml
			resourceSet.
				getResourceFactoryRegistry().
				getExtensionToFactoryMap().
				put("xml", new XMLResourceFactoryImpl());
		}
		return resourceSet;
	}
	
	/**
	 * Save a company EObject both in .xmi and .xml file
	 */
	public static void saveCompany(Company c, String s) throws IOException {
		
		ResourceSet resourceSet = getResourceSet();

		// Use XMI resource
		Resource xmiResource = resourceSet.createResource(URI.createFileURI(s + ".xmi"));
		xmiResource.getContents().add(c);
		xmiResource.save(null);

		// Use XML resource instead
		Resource xmlResource = resourceSet.createResource(URI.createFileURI(s + ".xml"));
		xmlResource.getContents().add(c);
		xmlResource.save(null);
	}
	
	/**
	 * Load a company EObject from an .xmi
	 */
	public static Company loadCompany(String s) throws IOException {
		
		ResourceSet resourceSet = getResourceSet();

		// Use XMI resource
		Resource xmiResource = resourceSet.createResource(URI.createFileURI(s + ".xmi"));
		xmiResource.load(null);
		return (Company)xmiResource.getContents().get(0);
	}	
}
