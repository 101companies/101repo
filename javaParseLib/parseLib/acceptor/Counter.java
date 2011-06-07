package parseLib.acceptor;

import parseLib.util.Input;

/**
 * An acceptor is enhanced by counting.
 * This is useful if you want to count occurrences of certain patterns.
 */
public class Counter extends Acceptor {

	private Acceptor a;
	
	private static int count = 0;
	
	public Counter(Acceptor a) {
		this.a = a;
	}
	
	public int getCount() {
		return count;
	}
		
	public boolean accept(Input i) {
		boolean status = a.accept(i);
		if (status) count++;
		return status;
	}

}
