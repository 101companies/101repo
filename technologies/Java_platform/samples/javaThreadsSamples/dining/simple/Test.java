package dining.simple;

public class Test
{
	public static void main(String[] args) throws Exception {
		
		// Create 5 forks as threads
		int size = 5;    
		Thread [] table = new Thread[size];
		Fork[] forks = new Fork[size];
		for(int i = 0; i < size; i++)
			forks[i] = new Fork();

		// Create 5 philosophers
		for(int i = 0; i < size; i++)
		{
			table[i]=new Thread(new Philosopher(i, forks[i], forks[(i+1) % size]));
			table[i].start();
		}
		
		// Wait for user interrupt
		System.out.println("Press 'Enter' to quit");
		System.in.read();

		// Terminate dinner
		for(int i = 0; i < size; i++)
			table[i].interrupt();
	}
}
