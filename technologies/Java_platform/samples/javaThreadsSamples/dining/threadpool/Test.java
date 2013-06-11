package dining.threadpool;

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
		for(int i = 0; i < size; i++)
			exec.execute(new Philosopher(i, forks[i], forks[(i+1) % size]));

		// Wait for user interrupt
		System.out.println("Press 'Enter' to quit");

		// Wait for user interrupt
		System.in.read();
		
		// Terminate dinner
		exec.shutdownNow();
	}
}
