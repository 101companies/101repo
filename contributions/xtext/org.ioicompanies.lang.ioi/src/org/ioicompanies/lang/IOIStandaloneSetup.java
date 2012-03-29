
package org.ioicompanies.lang;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class IOIStandaloneSetup extends IOIStandaloneSetupGenerated{

	public static void doSetup() {
		new IOIStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

