package org.softlang.client;

import static org.junit.Assert.assertEquals;
import org.softlang.shared.company.*;
import java.rmi.Naming;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * This is the RMI client of the 101companies System. 
 */
public class Client {

	// This field holds on a proxy to the remote company.
	private Company sampleCompany;

	//
	public Client(String server) throws Exception {
		try {
			sampleCompany = (Company) Naming.lookup("//" + server + "/meganalysis");
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
	 */
	private void demo() throws Exception {

		// Test total and cut
		double before = sampleCompany.total();		
	    System.out.println("Total before cut = " + before);
		sampleCompany.cut();
	    double after = sampleCompany.total();		
	    System.out.println("Total after cut = " + after);
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
		new Client(hostname);
	}
}
