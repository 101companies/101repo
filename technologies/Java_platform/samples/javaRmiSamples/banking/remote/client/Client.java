package banking.remote.client;

import java.rmi.Naming;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import banking.remote.shared.Account;
import banking.remote.shared.Bank;

/**
 * This is the RMI client of the "banking system" example program. It contains
 * some simple demo code that connects to and interacts with the BankSystemServer.
 */
public class Client {

	/**
	 * This field will hold on the server-side implementation of the Bank class.
	 * It's our "handle" for invoking methods that will be run on the server. 
	 * Note that it is a Bank object, not a BankImpl! The implementation resides 
	 * only on the server.
	 */
	private Bank bank;

	/**
	 * The constructor fetches the remote object from the server and interacts with it.
	 * 
	 * @param server
	 *            String representation of the RMI server's address. This may
	 *            both be an IP address like "192.168.23.42" or a machine's
	 *            name.
	 */
	public Client(String server) throws Exception {
		try {
			bank = (Bank) Naming.lookup("//" + server + "/Bank");
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

		// Here, we actually get passed an AccountImpl object from the
		// server. Note how we can use it locally.
		Account a = bank.getAccount(1001);
		a.deposit(10);

		if (a == null)
			System.out.println("Null");
		else {
			System.out.println(a.getBalance());
		}
	}
	
	/**
	 * In order to use this program, pass the address of the RMI server as its
	 * first argument on the command line (or via Eclipse's "Run dialog").
	 * The command line arguments are interpreted by this method, and if there
	 * are none, the server address defaults to the local host (127.0.0.1).
	 * 
	 * @param args
	 *            String representation of the RMI server's address. This may
	 *            both be an IP address like "192.168.23.42" or a machine's
	 *            name.
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
