package sumlength.parallel;
/* 
 * Inspired by the following blog post:
 * http://blogs.sun.com/CoreJavaTechTips/entry/get_netbeans_6
 * 
 * This is a good example for using functors (see Callable).
 * At the same time, it peeks at the use of threads, thread pools, and futures.
 * So to say, this is a "hello world" of parallel computing.
 * 
 */

import java.util.*;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * Compute the sum of lengths of an array of strings
 */
public class SumLength {

	/*
	 * Parallel computation of the sum of the lengths of an array of strings
	 */
	private static int sumLength(String[] a)
		throws
			InterruptedException,
			ExecutionException 
	{

		/*
		 * We use a thread pool.
		 */
		ExecutorService pool = Executors.newFixedThreadPool(5);
	  	  
		/* 
		 * Create one Callable per string in the input array.
		 * Submit each Callable to the thread pool.
		 * Each submission returns a Future.
		 * The result of the call can be retrieved later from the Future.
		 * Hence, we store all Futures until somewhat later.
		 * So the idea is that the threads will progress in the meantime.
		 */
		Set<Future<Integer>> set = new HashSet<Future<Integer>>();
		for (final String s: a) {
			Callable<Integer> callable = new Callable<Integer>() {
		    	public Integer call() {
		    		return Integer.valueOf(s.length());
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

	// Test input
	final static String[] words = {"let", "us", "sum", "up", "the", "length", "of", "all", "these", "words"};

	@Test
	public void testSumLength() throws InterruptedException, ExecutionException {
	    assertEquals(sumLength(words), 34);
  	}
}
