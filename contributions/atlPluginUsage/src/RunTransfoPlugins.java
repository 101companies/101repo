

import java.io.IOException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.m2m.atl.core.ATLCoreException;

import ATL_ComputeTotalPlugin.files.ComputeTotal;
import ATL_CutPlugin.files.Cut;

/**
 * 
 * @author Hugo Bruneliere
 */
public class RunTransfoPlugins {

	public static void main(String[] args) {
		try {
			
			/*
			 * Run "Cut" transformation
			 */
			Cut runner1 = new Cut();
			runner1.loadModels("Models/sampleCompany.xmi");
			runner1.doCut(new NullProgressMonitor());
			runner1.saveModels("Models/Plugins/sampleCompany_Cut.xmi");
			
			/*
			 * Run "ComputeTotal" transformation
			 */
			ComputeTotal runner2 = new ComputeTotal();
			runner2.loadModels("Models/Plugins/sampleCompany_Cut.xmi");
			runner2.doComputeTotal(new NullProgressMonitor());
			runner2.saveModels("Models/Plugins/sampleCompany_Total.xmi");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ATLCoreException e) {
			e.printStackTrace();
		}
	}

}
