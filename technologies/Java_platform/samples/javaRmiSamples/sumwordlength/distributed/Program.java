package sumwordlength.distributed;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;
import java.util.concurrent.*;
import concurrent.Semaphore; // We use a customized version for logging.

/*
 * Compute the length of an array of words
 */
public class Program {
	
	/*
	 * Test input
	 */
	private final static String words[] = {"let", "us", "sum", "up", "the", "length", "of", "all", "these", "words"};

	/*
	 * Our handle on the compute server
	 */
	private static Compute obj = null;	

	/*
	 * A semaphore that limits the number of remote invocations
	 */
	private static Semaphore sem = new Semaphore(3);		
	
	/*
	 * A distributed implementation using a thread pool
	 */
	private static int SumOfLengths() throws Exception {

		/* 
		 * We will a thread pool to compute the length of words. 
		 */
		ExecutorService pool = Executors.newFixedThreadPool(5);
	  	  
		/* 
		 * Create one Callable per word in the input array.
		 * Submit each Callable to the thread pool.
		 * Each submission returns a Future.
		 * The result of the call can be retrieved later from the Future.
		 * Hence, we store all Futures until somewhat later.
		 * So the idea is that the threads will progress in the meantime.
		 */
		Set<Future<Integer>> set = new HashSet<Future<Integer>>();
		for (final String word: words) {
			Callable<Integer> callable = new Callable<Integer>() {
		    	public Integer call() throws
		    		RemoteException,
		    		InterruptedException 
		    	{
					sem. acquire();
					int len = obj.length(word);
					sem.release();
					return Integer.valueOf(len);
		    	}	
			};
			Future<Integer> future = pool.submit(callable);
			set.add(future);
		}
		
		/*  
		 * Go over Futures to sum up the results.
		 * The get method will block until the result is available.
		 */
		int sum = 0;
		for (Future<Integer> future : set) {
			sum += future.get();
		}
		
		// Done with this thread pool
		pool.shutdown();

		return sum;
	}
		
	/*
	 * Test the computation
	 */
	public static void main(String args[]) throws Exception {
		
		// Look for server on localhost
		InetAddress addr = InetAddress.getLocalHost();
		String hostname = addr.getHostName();			
		
		// Bind to server
		try {
			obj = (Compute) Naming.lookup("//" + hostname + "/OurLovelyComputeServer");
		} catch (MalformedURLException malformedException) {
			System.err.println("Bad URL: " + malformedException);
		} catch (NotBoundException notBoundException) {
			System.err.println("Not Bound: " + notBoundException);
		} catch (RemoteException remoteException) {
			System.err.println("Remote Exception: " + remoteException);
		}

		// Compute ... 
		System.out.printf("The sum of lengths is %s.%n", SumOfLengths());
  	}
}
