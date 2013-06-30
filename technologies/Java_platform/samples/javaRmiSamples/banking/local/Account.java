package banking.local;

/**
 * This class provides the functionality for manipulating account objects.
 */
public class Account {

	private Bank bank;
	private Integer customerNumber;
	private long balance;
	private Integer accountNumber;

	/**
	 * Creates a new Account.
	 * 
	 * @param bank
	 *            Reference to the Bank object that shall manage this account.
	 * @param accountNumber
	 *            The system-wide unique number of this account.
	 * @param customerNumber
	 *            The system-wide unique number of this account's owner.
	 */
	public Account(
			Bank bank,
			Integer accountNumber,
			Integer customerNumber)	{

		this.bank = bank;
		this.customerNumber = customerNumber;
		this.balance = 0;
		this.accountNumber = accountNumber;
	}

	/**
	 * Each account is managed by one bank,
	 * which can be accessed with this method.
	 * 
	 * @return This account's bank
	 */
	public Bank getBank() {
		return bank;
	}

	public Integer getNumber() {
		return accountNumber;
	}
		
	/**
	 * Returns the reference number of this account's owner.
	 * 
	 * @return A customer reference number.
	 */
	public Integer getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * Returns the amount of money on this account.
	 * 
	 * @return This account's balance.
	 */
	public long getBalance() {
		return balance;
	}

	/**
	 * Makes a deposit on this account.
	 * 
	 * @param amount
	 *            The sum of money to deposit.
	 * @return The account's balance after the transaction.
	 * @throws AccountAccessException
	 *             if a negative amount is passed.
	 */
	public long deposit(long amount) throws AccountAccessException {
		if (amount < 0)
			throw new AccountAccessException();
		balance += amount;
		return balance;
	}

	/**
	 * Withdraws money from this account.
	 * 
	 * @param amount
	 *            The amount of money to withdraw.
	 * @return The balance remaining after the transaction.
	 * @throws AccountAccessException
	 *             if there is not enough money on the account (no credit is
	 *             given).
	 */
	public long withdraw(long amount) throws AccountAccessException {
		if (amount > balance || amount < 0)
			throw new AccountAccessException();
		balance = balance - amount;
		return amount;
	}
}
