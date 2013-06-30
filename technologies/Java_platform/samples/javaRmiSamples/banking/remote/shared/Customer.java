package banking.remote.shared;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface declares the available methods for manipulating customer data in
 * our banking system example. It needs to be present on both client and server.
 * On the server side, these methods are implemented by CustomerImpl.java.
 */
public interface Customer extends Remote {

	/**
	 * Returns the Bank object that manages this customer.
	 * 
	 * @return A Bank object.
	 * @throws RemoteException
	 *             if RMI encounters an error.
	 */
	public Bank getBank() throws RemoteException;

	/**
	 * Fetches this customer's reference number from the database.
	 * 
	 * @return This customer's number
	 * @throws RemoteException
	 *             if RMI encounters an error.
	 */
	public Integer getCustomerNumber() throws RemoteException;

	/**
	 * Fetches this customer's name from the database.
	 * 
	 * @return This customer's name.
	 * @throws RemoteException
	 *             if RMI encounters an error.
	 */
	public String getName() throws RemoteException;
}
