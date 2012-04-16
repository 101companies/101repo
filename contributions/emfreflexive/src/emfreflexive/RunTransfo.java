package emfreflexive;

import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * 
 * @author Hugo Bruneliere
 */
public class RunTransfo {

	public static void main(String[] args) {
		try {
			
			/*
			 * Prepare resource set
			 */
			XMIResourceFactoryImpl xmiFactory = new XMIResourceFactoryImpl();
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().
						getExtensionToFactoryMap().
						put("ecore", new EcoreResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().
						getExtensionToFactoryMap().
						put("xmi", xmiFactory);
			
			/*
			 * Load metamodels
			 */
			Resource companyMetamodel = resourceSet.createResource(URI.createFileURI("Metamodels/Company.ecore"));
			companyMetamodel.load(null);
			EPackage.Registry.INSTANCE.put("http://www.company.com", companyMetamodel.getContents().get(0));
			
			Resource totalMetamodel = resourceSet.createResource(URI.createFileURI("Metamodels/Total.ecore"));
			totalMetamodel.load(null);
			EPackage.Registry.INSTANCE.put("http://www.total.com", totalMetamodel.getContents().get(0));
			
			/*
			 * Load input model
			 */
			Resource companySampleModel = resourceSet.createResource(URI.createFileURI("Models/sampleCompany.xmi"));
			companySampleModel.load(null);
			
			TreeIterator<EObject> iterator;
			
			/*
			 * Perform "Cut" operation
			 */
			iterator = companySampleModel.getAllContents();
			while(iterator.hasNext()) {
				EObject currentModelElement = iterator.next();
				if( currentModelElement.eClass().getName().equals("Employee") ) {
					EStructuralFeature salaryAttribute = currentModelElement.eClass().getEStructuralFeature("salary");
					double currentSalary = (Double) currentModelElement.eGet(salaryAttribute);
					currentModelElement.eSet(salaryAttribute, currentSalary/2);
				}
			}
			companySampleModel.save(new FileOutputStream("Models/sampleCompany_Cut.xmi"), null);
			
			/*
			 * Perform "Total" operation
			 */
			double totalSalary = 0;
			iterator = companySampleModel.getAllContents();
			while(iterator.hasNext()) {
				EObject currentModelElement = iterator.next();
				if( currentModelElement.eClass().getName().equals("Employee") ) {
					double currentSalary = (Double) currentModelElement.eGet(currentModelElement.eClass().getEStructuralFeature("salary"));
					totalSalary = totalSalary + currentSalary;
				}
			}
			
			EPackage totalPackage = (EPackage) totalMetamodel.getContents().get(0);
			EClass totalWrapperClass = (EClass) totalPackage.getEClassifier("TotalWrapper");
			
			EObject totalWrapperObject = totalPackage.getEFactoryInstance().create(totalWrapperClass);
			totalWrapperObject.eSet(totalWrapperClass.getEStructuralFeature("total"), totalSalary);
			
			Resource totalSampleModel = resourceSet.createResource(URI.createFileURI("Models/sampleTotal.xmi"));		
			totalSampleModel.getContents().add(totalWrapperObject);
			totalSampleModel.save(null);
			
			/*
			 * Unload models and metamodels
			 */
			companySampleModel.unload();
			companyMetamodel.unload();
			EPackage.Registry.INSTANCE.remove("http://www.company.com");
			totalSampleModel.unload();
			totalMetamodel.unload();
			EPackage.Registry.INSTANCE.remove("http://www.total.com");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
