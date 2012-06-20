package atl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

/**
 * 
 * @author Hugo Bruneliere
 */
public class RunTransfoJava {

	public static void main(String[] args) {
		try {
			/*
			 * Initializations
			 */
			ILauncher transformationLauncher = new EMFVMLauncher();
			ModelFactory modelFactory = new EMFModelFactory();
			IInjector injector = new EMFInjector();
			IExtractor extractor = new EMFExtractor();
			
			/*
			 * Load metamodels
			 */
			IReferenceModel companyMetamodel = modelFactory.newReferenceModel();
			injector.inject(companyMetamodel, "Metamodels/Company.ecore");
			IReferenceModel totalMetamodel = modelFactory.newReferenceModel();
			injector.inject(totalMetamodel, "Metamodels/Total.ecore");
			
			/*
			 * Run "Cut" transformation
			 */
			IModel companyModel = modelFactory.newModel(companyMetamodel);
			injector.inject(companyModel,"Models/sampleCompany.xmi");
			
			transformationLauncher.initialize(new HashMap<String,Object>());
			transformationLauncher.addInOutModel(companyModel, "IN", "Company");
			IReferenceModel refiningTraceMetamodel = modelFactory.getBuiltInResource("RefiningTrace.ecore");
			IModel refiningTraceModel = modelFactory.newModel(refiningTraceMetamodel);
			transformationLauncher.addOutModel(refiningTraceModel, "refiningTrace", "RefiningTrace");
			transformationLauncher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), new HashMap<String,Object>(),
				new FileInputStream("Transformations/Cut.asm"));
			
			IModel companyModel_Cut = companyModel;
			extractor.extract(companyModel_Cut, "Models/Java/sampleCompany_Cut.xmi");
			
			/*
			 * Run "ComputeTotal" transformation
			 */
			IModel companyModel_Total = modelFactory.newModel(totalMetamodel);
			
			transformationLauncher.initialize(new HashMap<String,Object>());
			transformationLauncher.addInModel(companyModel_Cut, "IN", "Company");
			transformationLauncher.addOutModel(companyModel_Total, "OUT", "Total");
			transformationLauncher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), new HashMap<String,Object>(),
				new FileInputStream("Transformations/ComputeTotal.asm"));
			
			extractor.extract(companyModel_Total, "Models/Java/sampleCompany_Total.xmi");
			
			/*
			 * Unload all models and metamodels (EMF-specific)
			 */
			EMFModelFactory emfModelFactory = (EMFModelFactory) modelFactory;
			emfModelFactory.unload((EMFModel) companyModel_Cut);
			emfModelFactory.unload((EMFModel) companyModel_Total);
			emfModelFactory.unload((EMFReferenceModel) companyMetamodel);
			emfModelFactory.unload((EMFReferenceModel) totalMetamodel);
			
		} catch (ATLCoreException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
