package accounts;

public class Demo {

	public static void main(String[] args) {
		Account anAccount = new Account();
		anAccount.deposit(500);
		anAccount.withdraw(100);
		anAccount.withdraw(700); // Violates precondition
		System.out.println(anAccount.getBalance());
	}

}
