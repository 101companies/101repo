package banking.remote.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.io.IOException;

import banking.remote.shared.*;

/**
 * This class implements an RMI server for the banking system demo. 
 * In essence, it binds a bank implementation to the registry.
 * The server is stopped by pressing <CR> on the console.
 * This code works on Java 5 and above.
 */
public class Server {

	private Bank bank = getBank();
	private String hostname = null;

	/**
	 * In a realistic implementation, the bank would be persistent.
	 * That is, we would create objects in an OR mapping-based manner.
	 * This mock-up populates the bank object from scratch.
	 */
	static Bank getBank() {
		Bank bank = null;
		try {
			bank = new BankImpl();
			bank.addCustomer(4711, "Alice");
			bank.addCustomer(2342, "Bob");
			bank.addAccount(1000, 4711);
			bank.addAccount(1001, 4711);
			bank.addAccount(1002, 2342);
		} catch (AccountNumberAlreadyInUseException e) {
			// ...
		} catch (CustomerNumberAlreadyInUseException e) {
			// ...
		} catch (RemoteException e) {
			// ...
		}
		return bank;
	}
	
	/**
	 * Create a BankImpl object and register it for remote invocation.
	 */
	public Server() {

		try {
			InetAddress addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
		} catch (UnknownHostException unknownHostException) {
			System.err.println("Failure during host name resolution: " + unknownHostException);
		}

		try {
			Naming.rebind("//" + hostname + "/Bank", bank);
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
			Naming.unbind("//" + server.hostname + "/Bank");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}
