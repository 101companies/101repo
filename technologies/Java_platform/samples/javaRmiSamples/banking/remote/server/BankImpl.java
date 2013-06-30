package banking.remote.server;

import java.util.Hashtable;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

import banking.remote.shared.Account;
import banking.remote.shared.AccountNumberAlreadyInUseException;
import banking.remote.shared.Bank;
import banking.remote.shared.Customer;
import banking.remote.shared.CustomerNumberAlreadyInUseException;

/**
 * This class implements some simple management functions for the banking system
 * demo. It holds on a simple database for clients and accounts and provides
 * methods for manipulating them. It needs to be present on the RMI server only.
 * Its methods are documented in its interface, Bank.java.
 */
public class BankImpl extends UnicastRemoteObject implements Bank {

	// As this may be passed via RMI, we need to provide a UID for serialization
	private static final long serialVersionUID = 1L;
	private Hashtable<Integer, AccountImpl> accounts;
	private Hashtable<Integer, CustomertImpl> customers;

	public BankImpl() throws RemoteException {
		initialize();
	}

	public void initialize() throws RemoteException {
		accounts = new Hashtable<Integer, AccountImpl>(20);
		customers = new Hashtable<Integer, CustomertImpl>(10);
	}

	public void addAccount(Integer accountNumber, Integer customerNumber) throws RemoteException,
			AccountNumberAlreadyInUseException {
		if (accounts.containsKey(accountNumber)) {
			throw new AccountNumberAlreadyInUseException();
		} else if (customers.containsKey(customerNumber)) {
			AccountImpl a = new AccountImpl(this, accountNumber, customerNumber);
			accounts.put(accountNumber, a);
		}
	}

	public void addCustomer(Integer customerNumber, String name) throws RemoteException, CustomerNumberAlreadyInUseException {
		if (customers.containsKey(customerNumber)) {
			throw new CustomerNumberAlreadyInUseException();
		} else {
			CustomertImpl c = new CustomertImpl(this, customerNumber, name);
			customers.put(customerNumber, c);
		}
	}

	public Account getAccount(Integer accountNumber) throws RemoteException {
		AccountImpl account = accounts.get(accountNumber);
		return account;
	}

	public Customer getCustomer(Integer customerNumber) throws RemoteException {
		CustomertImpl customer = customers.get(customerNumber);
		return customer;
	}

}
