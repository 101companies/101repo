package sumwordlength.distributed;

import java.net.UnknownHostException; // for disambiguation
import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;
import java.io.IOException;

/*
 * The server's main program
 */
public class Server {

	/*
	 * Construct a server object and run the server until a key is pressed.
	 */
	public static void main(String args[]) {

		// Make sure there is a registry
		try {
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}

		// Create remote object for compute server
		Compute obj = null;
		try {
			obj = new ComputeImpl();
		} catch (RemoteException remoteException) {
			System.err.println("Failure during object export to RMI: "
					+ remoteException);
		}
		
		// Determine the hostname
		String hostname = null;
		try {
			InetAddress addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
		} catch (UnknownHostException unknownHostException) {
			System.err.println("Failure during host name resolution: "
					+ unknownHostException);
		}
		
		// Bind remote object via naming service
		try {
			Naming.rebind("//" + hostname + "/OurLovelyComputeServer", obj);
		} catch (RemoteException remoteException) {
			System.err.println("Failure during name registration: "
					+ remoteException);
		} catch (MalformedURLException malformedException) {
			System.err.println("Failure during name registration: "
					+ malformedException);
		}

		// Enter input loop for server termination
		System.out.println("Server started.");
		System.out.println("Enter <CR> to end.");
		try {
			System.in.read(); // Wait for Enter ...
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

		// Clean up registry and done!
		try {
			Naming.unbind("//" + hostname + "/OurLovelyComputeServer");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}
