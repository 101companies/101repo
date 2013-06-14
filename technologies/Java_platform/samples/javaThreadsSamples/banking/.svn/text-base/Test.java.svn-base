package banking;

import java.util.concurrent.*;

public class Test {
	public static void main(String[] args) throws Exception {

		// One credit card for everyone
		Account creditCard = new Account(200);
	
		// Three employees
		int size = 3;
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < size; i++)
			exec.execute(new Employee(creditCard));

		// Surely money is gone after a few secs
		exec.awaitTermination(3, TimeUnit.SECONDS);
		exec.shutdownNow();

		// Perhaps some small money is left?
		System.out.println("Money left: " + creditCard.getBalance());
	}
}
