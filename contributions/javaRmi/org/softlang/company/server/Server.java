package org.softlang.company.server;

import org.softlang.company.shared.*;

import static org.softlang.company.server.Factory.*;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.io.IOException;

/**
 * This class implements the 101system through RMI. 
 * In essence, it binds a sample company in the registry.
 * The server is stopped by pressing <CR> on the console.
 */
public class Server {

	private String hostname = null;

	// In a realistic implementation, company would be persisted by the server.
	private static Company mkSampleCompany() throws RemoteException {
		// Create company
		Company sampleCompany = mkCompany();
		sampleCompany.setName("meganalysis");
		
		// Create all employees
		Employee craig = mkEmployee();
		craig.setName("Craig");
		craig.setAddress("Redmond");
		craig.setSalary(123456);
		Employee erik = mkEmployee();
		erik.setName("Erik");
		erik.setAddress("Utrecht");
		erik.setSalary(12345);
		Employee ralf = mkEmployee();
		ralf.setName("Ralf");
		ralf.setAddress("Koblenz");
		ralf.setSalary(1234);		
		Employee ray = mkEmployee();
		ray.setName("Ray");
		ray.setAddress("Redmond");
		ray.setSalary(234567);
		Employee klaus = mkEmployee();
		klaus.setName("Klaus");
		klaus.setAddress("Boston");
		klaus.setSalary(23456);
		Employee karl = mkEmployee();
		karl.setName("Karl");
		karl.setAddress("Riga");
		karl.setSalary(2345);
		Employee joe = mkEmployee();
		joe.setName("Joe");
		joe.setAddress("Wifi City");
		joe.setSalary(2344);								

		// Create research department
		Department research = mkDepartment();
		research.setManager(craig);
		research.setName("Research");
		research.getEmployees().add(erik);
		research.getEmployees().add(ralf);
		sampleCompany.getDepts().add(research);

		// Create development department
		Department development = mkDepartment();
		development.setManager(ray);
		development.setName("Development");
		sampleCompany.getDepts().add(development);

		// Create sub-department dev1
		Department dev1 = mkDepartment();
		development.getSubdepts().add(dev1);
		dev1.setName("Dev1");
		dev1.setManager(klaus);

		// Create sub-department dev11
		Department dev11 = mkDepartment();
		dev1.getSubdepts().add(dev11);
		dev11.setName("Dev1.1");
		dev11.setManager(karl);
		dev11.getEmployees().add(joe);
		
		return sampleCompany;
	}
	
	/**
	 * Register the sample company for remote invocation.
	 */
	public Server() {

		try {
			InetAddress addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
		} catch (UnknownHostException unknownHostException) {
			System.err.println("Failure during host name resolution: " + unknownHostException);
		}

		try {
			Naming.rebind("//" + hostname + "/meganalysis", mkSampleCompany());
		} catch (RemoteException remoteException) {
			System.err.println("Failure during name registration: " + remoteException);
		} catch (MalformedURLException malformedException) {
			System.err.println("Failure during name registration: " + malformedException);
		}

	}

	/**
	 * Start the Server and wait for user termination by keyboard.
	 * 
	 * @param args
	 *            This program does not accept command line parameters.
	 */
	public static void main(String args[]) {

		// Override the default security manager
		System.setSecurityManager(new SecurityManager());
		
		try {
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}

		Server server = new Server();

		System.out.println("Server started.");
		System.out.println("Enter <CR> to end.");

		try {
			System.in.read(); // Wait for Enter ...
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

		try {
			Naming.unbind("//" + server.hostname + "/meganalysis");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}
