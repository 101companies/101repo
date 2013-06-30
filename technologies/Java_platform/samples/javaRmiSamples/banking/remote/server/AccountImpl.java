package banking.remote.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import banking.remote.shared.Account;
import banking.remote.shared.AccountAccessException;
import banking.remote.shared.Bank;

/**
 * This class provides the functionality for manipulating account objects. It
 * needs to be present on the RMI server only. Its methods are documented in its
 * interface, Account.java.
 */
public class AccountImpl extends UnicastRemoteObject implements Account {

	// As this may be passed via RMI, we need to provide a UID for serialization
	private static final long serialVersionUID = 1L;
	private Bank bank;
	private Integer customerNumber;
	private long balance;
	private Integer accountNumber;

	/**
	 * Creates a new Account.
	 * 
	 * @param bank
	 *            Reference to the Bank object that shall manage this
	 *            account.
	 * @param accountNumber
	 *            The system-wide unique number of this account.
	 * @param customerNumber
	 *            The system-wide unique number of this account's owner.
	 * @throws RemoteException
	 *             RMI problems will be signaled.
	 */
	public AccountImpl(
			Bank bank,
			Integer accountNumber,
			Integer customerNumber)	throws RemoteException	{

		this.bank = bank;
		this.customerNumber = customerNumber;
		this.balance = 0;
		this.accountNumber = accountNumber;
	}

	public long deposit(long amount) throws AccountAccessException {
		if (amount < 0)
			throw new AccountAccessException();
		balance += amount;
		return balance;
	}

	public long withdraw(long amount) throws AccountAccessException {
		if (amount > balance || amount < 0)
			throw new AccountAccessException();
		balance = balance - amount;
		return amount;
	}

	public Bank getBank() {
		return bank;
	}

	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public long getBalance() {
		return balance;
	}

	public Integer getNumber() {
		return accountNumber;
	}
}
