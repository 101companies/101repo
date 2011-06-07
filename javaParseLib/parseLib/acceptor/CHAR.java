package parseLib.acceptor;

import parseLib.util.Input;

/** 
 * An acceptor for a single character
 */
public class CHAR extends Acceptor {

	private char c1;
	private char c2;
	
	/**
	 * Construct parser for any character
	 */
	public CHAR() {
		c1 = 0;
		c2 = 255;
	}
	
	/**
	 * Construct acceptor for a specific character
	 */
	public CHAR(char c) {
		c1 = c;
		c2 = c;
	}
	
	/**
	 * Construct acceptor for an interval of characters
	 */
	public CHAR(char c1, char c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	public boolean accept(Input i) {
		char c = (char) i.read();
		return c != 0 && (c >= c1 && c <= c2);
	}
}
