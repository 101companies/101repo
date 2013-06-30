package banking.remote.server;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

import banking.remote.shared.Bank;
import banking.remote.shared.Customer;


/**
 * This class provides the functionality for manipulating Customer objects. It
 * needs to be present on the RMI server only. Its methods are documented in its
 * interface, Customer.java.
 */
public class CustomertImpl extends UnicastRemoteObject implements Customer {

	// As this may be passed via RMI, we need to provide a UID for serialization
	private static final long serialVersionUID = 1L;
	private Bank bank;
	private Integer customerNumber;
	private String customerName;

	
	/**
	 * Creates a new Customer object.
	 * 
	 * @param bank The Bank managing this customer
	 * @param customerNumber A system-wide unique reference number
	 * @param customerName This customer's name, free-form String
	 * @throws java.rmi.RemoteException if RMI encounters an error
	 */
	public CustomertImpl(Bank bank, Integer customerNumber, String customerName) throws java.rmi.RemoteException {
		this.bank = bank;
		this.customerNumber = customerNumber;
		this.customerName = customerName;
	}

	public Bank getBank() throws RemoteException {
		return bank;
	}

	public String getName() throws RemoteException {
		return customerName;
	}

	public Integer getCustomerNumber() throws RemoteException {
		return customerNumber;
	}
}
