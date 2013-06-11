package banking;

public class Account
{
	private int balance;

	// Initialize the account with some amount
	public Account (int amount) {
		balance = amount;
	}

	//
	// Withdraw some money
	//
	// Try
	// - w/ synchronized keyword
	// - w/o
	//
	public synchronized boolean withdraw (int amount) {
		
		int preview = balance - amount;
		
		// activate the next two lines of code to decrease thread safety
		try { Thread.sleep(100); }
		catch (InterruptedException e) { return false; }
		
		if (preview<0)
			return false;
		else {
			balance = preview;
			return true;
		}
	}

	// Return remaining balance of this account
	public int getBalance()	{
		return this.balance;
	}
}
