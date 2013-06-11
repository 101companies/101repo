package slowstringreverser;

import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

public class Test {

	ExecutorService executor = Executors.newFixedThreadPool(1);

	SlowStringReverser reverser = new SlowStringReverser();

	void doReverse(final String target) throws InterruptedException {

		FutureTask<String> future = new FutureTask<String>(
				new Callable<String>() {
					public String call() {
						return reverser.reverseString(target);
					}
				});
		executor.execute(future);

		while (!future.isDone()) {
			System.out.println("Task not yet completed.");
			try {
				System.out.println("Will check after 1/2 sec.");
				Thread.sleep(500);
			} catch (InterruptedException ie) {
			}
		}
		try {
			System.out.println("Here is the result..." + future.get());
		} catch (ExecutionException ex) {
		}
		executor.shutdown();
		return;
	}

	public static void main(String args[]) {
		Test msr = new Test();
		try {
			msr.doReverse("foobar");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
