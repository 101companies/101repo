package org.softlang.company.client;

import static org.junit.Assert.assertEquals;

import org.softlang.company.shared.*;

import java.rmi.Naming;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * This is an RMI client for the 101companies System. 
 */
public class Demo {

	// This field holds on a proxy to the remote company.
	private Company sampleCompany;

	// Construct a client connected to a specified server
	public Demo(String server) throws Exception {
		try {
			sampleCompany = (Company) Naming.lookup("//" + server + "/meganalysis");
		    System.out.println("Client connected with server \"" + server + "\".");			
		} catch (MalformedURLException malformedException) {
			System.err.println("Bad URL: " + malformedException);
		} catch (NotBoundException notBoundException) {
			System.err.println("Not Bound: " + notBoundException);
		} catch (RemoteException remoteException) {
			System.err.println("Remote Exception: " + remoteException);
		}
		
		demo();
	}

	/**
	 * Executes some demo code on the remote object.
	 * Use assertions for testing.
	 */
	public void demo() throws Exception {

		// Test total and cut
		double before = sampleCompany.total();		
	    System.out.println("Remote total before local cut = " + before);
	    Cut.cut(sampleCompany);
	    double after = sampleCompany.total();		
	    System.out.println("Remote total after local cut = " + after);
	    assertEquals(before / 2.0d, after, 0);
	    System.out.println("Testing done.");
	}
	
	/**
	 * Assume the server to be running on the local host, by default -- if no
	 * command-line argument is provided, and use the argument as the server 
	 * otherwise -- assuming the format of an IP address or a machine name.
	 */
	public static void main(String[] args) throws Exception {
		String hostname;
		if (args.length >= 1)
			hostname = args[0];
		else {
			InetAddress addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();			
		}
		new Demo(hostname);
	}
}
