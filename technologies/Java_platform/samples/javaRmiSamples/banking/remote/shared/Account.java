package banking.remote.shared;
import java.rmi.Remote;
import java.rmi.RemoteException;

import banking.remote.shared.Bank;


/**
 * This interface declares the available methods for accounts in our banking
 * system example. It needs to be present on both client and server. On the
 * server side, these methods are implemented by AccountImpl.java.
 */
public interface Account extends Remote {

	/**
	 * Each account is managed by one bank, which can be accessed with this method.
	 * 
	 * @return This account's bank
	 * @throws RemoteException
	 *             if RMI encounters an error.
	 */
	public Bank getBank() throws RemoteException;

	/**
	 * Returns the reference number of this account's owner.
	 * 
	 * @return A customer reference number.
	 * @throws RemoteException
	 *             if RMI encounters an error.
	 */
	public Integer getCustomerNumber() throws RemoteException;

	/**
	 * Returns the amount of money on this account.
	 * 
	 * @return This account's balance.
	 * @throws RemoteException
	 *             if RMI encounters an error.
	 */
	public long getBalance() throws RemoteException;

	/**
	 * Makes a deposit on this account.
	 * 
	 * @param amount
	 *            The sum of money to deposit.
	 * @return The account's balance after the transaction.
	 * @throws AccountAccessException
	 *             if a negative amount is passed.
	 * @throws RemoteException
	 *             if RMI encounters an error.
	 */
	public long deposit(long amount) throws AccountAccessException, RemoteException;

	/**
	 * Withdraws money from this account.
	 * 
	 * @param amount
	 *            The amount of money to withdraw.
	 * @return The balance remaining after the transaction.
	 * @throws AccountAccessException
	 *             if there is not enough money on the account (no credit is
	 *             given).
	 * @throws RemoteException
	 *             if RMI encounters an error.
	 */
	public long withdraw(long amount) throws AccountAccessException, RemoteException;
}
