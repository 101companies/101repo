package banking.remote.shared;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface declares the available methods for interacting with "the bank"
 * in our banking system example. It needs to be present on both client and
 * server. On the server side, these methods are implemented by BankImpl.java.
 */
public interface Bank extends Remote {

	/**
	 * Creates a new account in the bank.
	 * 
	 * @param accountNumber The account's reference number.
	 * @param customerNumber The account owner's number.
	 * @throws AccountNumberAlreadyInUseException if the desired account number is already in use 
	 * @throws RemoteException if RMI encounters an error
	 */
	public void addAccount(Integer accountNumber, Integer customerNumber) throws AccountNumberAlreadyInUseException, RemoteException;

	/**
	 * Creates a new customer.
	 * 
	 * @param customerNumber The customer's reference number.
	 * @param name The customer's name.
	 * @throws CustomerNumberAlreadyInUseException if the desired customer number is already in use
	 * @throws RemoteException if RMI encounters an error
	 */
	public void addCustomer(Integer customerNumber, String name) throws CustomerNumberAlreadyInUseException, RemoteException;

	/**
	 * Fetches an Account object from the database. 
	 * 
	 * @param accountNumber The desired account's reference number
	 * @return The account with the given number, null if there is no such number.
	 * @throws RemoteException if RMI encounters an error
	 */
	public Account getAccount(Integer accountNumber) throws RemoteException;
	
	/**
	 * Fetches a customer object from the database. 
	 * 
	 * @param customerNumber The desired customer's reference number
	 * @return The customer with the given number, null if there is no such number.
	 * @throws RemoteException if RMI encounters an error
	 */
	public Customer getCustomer(Integer customerNumber) throws RemoteException;

}
