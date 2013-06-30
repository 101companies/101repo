package sumwordlength.sequential;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
 * Compute the length of an array of words
 */
public class SumWordLength {

	// Sequential computation of the sum of the lengths of some given words
	private static int sumWordLength(String[] words) {
		int sum = 0;
		for (String w : words) {
			sum += w.length();
		}		
		return sum;
	}

	// Test input
	final static String[] words = {"let", "us", "sum", "up", "the", "length", "of", "all", "these", "words"};

	@Test
	public void testSumWordLength() {
	    assertEquals(sumWordLength(words), 34);
  	}
}