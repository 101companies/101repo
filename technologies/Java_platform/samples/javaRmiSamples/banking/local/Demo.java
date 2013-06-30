package banking.local;

/**
 * This class contains some simple demo code that interacts with a bank.
 */
public class Demo {

	public static void main(String[] args) throws Exception {
		Bank bank = new Bank();
		bank.addCustomer(4711, "Alice");
		bank.addCustomer(2342, "Bob");
		bank.addAccount(1000, 4711);
		bank.addAccount(1001, 4711);
		bank.addAccount(1002, 2342);

		Account a = bank.getAccount(1001);
		a.deposit(10);
		System.out.println(a.getBalance());
	}
}
