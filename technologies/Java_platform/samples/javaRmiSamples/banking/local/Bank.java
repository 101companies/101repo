package banking.local;

import java.util.Hashtable;

/**
 * This class implements some simple management functions for the banking system
 * demo. It holds on a simple database for clients and accounts and provides
 * methods for manipulating them.
 */
public class Bank {

	private Hashtable<Integer, Account> accounts;
	private Hashtable<Integer, Customer> customers;

	public Bank() {
		initialize();
	}

	public void initialize() {
		accounts = new Hashtable<Integer, Account>(20);
		customers = new Hashtable<Integer, Customer>(10);
	}

	/**
	 * Creates a new account in the bank.
	 * 
	 * @param accountNumber The account's reference number.
	 * @param customerNumber The account owner's number.
	 * @throws AccountNumberAlreadyInUseException if the desired account number is already in use 
	 */
	public void addAccount(Integer accountNumber, Integer customerNumber) throws AccountNumberAlreadyInUseException {
		if (accounts.containsKey(accountNumber)) {
			throw new AccountNumberAlreadyInUseException();
		} else if (customers.containsKey(customerNumber)) {
			Account a = new Account(this, accountNumber, customerNumber);
			accounts.put(accountNumber, a);
		}
	}
	
	/**
	 * Creates a new customer.
	 * 
	 * @param customerNumber The customer's reference number.
	 * @param name The customer's name.
	 * @throws CustomerNumberAlreadyInUseException if the desired customer number is already in use
	 */
	public void addCustomer(Integer customerNumber, String name) throws CustomerNumberAlreadyInUseException {
		if (customers.containsKey(customerNumber)) {
			throw new CustomerNumberAlreadyInUseException();
		} else {
			Customer c = new Customer(this, customerNumber, name);
			customers.put(customerNumber, c);
		}
	}

	/**
	 * Fetches an Account object from the database. 
	 * 
	 * @param accountNumber The desired account's reference number
	 * @return The account with the given number, null if there is no such number.
	 */
	public Account getAccount(Integer accountNumber) {
		Account account = accounts.get(accountNumber);
		return account;
	}

	/**
	 * Fetches a customer object from the database. 
	 * 
	 * @param customerNumber The desired customer's reference number
	 * @return The customer with the given number, null if there is no such number.
	 * @throws RemoteException if RMI encounters an error
	 */
	public Customer getCustomer(Integer customerNumber) {
		Customer customer = customers.get(customerNumber);
		return customer;
	}

}
