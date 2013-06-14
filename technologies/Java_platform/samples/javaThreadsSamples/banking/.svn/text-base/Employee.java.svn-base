package banking;

public class Employee implements Runnable {

	private Account companyCreditCard;
	static private int maxid = 0;
	private int id = ++maxid;

	// Associate employee with a credit card (of the company)
	public Employee(Account cc) {
		companyCreditCard = cc;
	}

	public int getId() {
		return id;
	}
	
	//
	// Try to get as much beer as possible.
	// Use varying amount of money at times.
	//
	public void run() {
		int total = 0;
		int beer;
		while (!Thread.interrupted()) {
			beer = 1 + (int) (100 * Math.random());
			String prefix = "#" + getId() + ": ";
			if (companyCreditCard.withdraw(beer)) {
				System.out.println(prefix + "Got $" + beer);
				total += beer;
			} else {
				System.out.println(prefix + "Didn't get $" + beer + " (after spending $" + total + ")");
				return;
			}
		}
	}
}
