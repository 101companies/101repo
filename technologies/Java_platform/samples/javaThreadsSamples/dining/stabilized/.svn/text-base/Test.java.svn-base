package dining.stabilized;

import dining.simple.Fork;
import dining.simple.Philosopher;
import java.util.concurrent.*;

public class Test
{
	public static void main(String[] args) throws Exception {

		// Create 5 forks via a thread pool		
		int size = 5;    
		ExecutorService exec = Executors.newCachedThreadPool();
		Fork[] forks = new Fork[size];
		for(int i = 0; i < size; i++)
			forks[i] = new Fork();

		// Create 5 philosophers
		exec.execute(new Philosopher(0, forks[size-1], forks[0]));
		for(int i = 1; i < size; i++)
			exec.execute(new Philosopher(i, forks[i], forks[(i+1) % size]));

		// Wait for user interrupt
		System.out.println("Press 'Enter' to quit");
		System.in.read();

		// Terminate dinner		
		exec.shutdownNow();
	}
}
