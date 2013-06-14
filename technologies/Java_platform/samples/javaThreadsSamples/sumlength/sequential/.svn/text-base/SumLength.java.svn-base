package sumlength.sequential;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
 * Compute the sum of lengths of an array of strings
 */
public class SumLength {

	// Sequential computation of the sum of the lengths of an array of strings
	private static int sumLength(String[] a) {
		int sum = 0;
		for (String s : a) {
			sum += s.length();
		}		
		return sum;
	}

	// Test input
	final static String[] words = {"let", "us", "sum", "up", "the", "length", "of", "all", "these", "words"};

	@Test
	public void testSumLength() {
	    assertEquals(sumLength(words), 34);
  	}
}