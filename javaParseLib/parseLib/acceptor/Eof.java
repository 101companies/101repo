package parseLib.acceptor;

import parseLib.util.Input;

/** 
 * An acceptor that succeeds at the end of the file (input)
 */
public class Eof extends Acceptor {
	
	public Eof() {
	}
		
	public boolean accept(Input i) {
		return !i.ready();
	}
}
