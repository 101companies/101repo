package parseLib.acceptor;

import parseLib.util.Input;

/**
 * The base class for all acceptor/parser combinators
 */
public abstract class Acceptor {

	/** 
	 * The essential method of a parser combinator 
	 */	
	public abstract boolean accept(Input i);

	//
	//
	// The following methods provide convenience of acceptor combination.
	//
	//

	public static Acceptor optional(Acceptor a) {
		return new Optional(a);
	}
		
	public static Acceptor star(Acceptor a) {
		return new Star(a);
	}

	public static Acceptor plus(Acceptor a) {
		return new Plus(a);
	}

	public static Acceptor not(Acceptor a) {
		return new Not(a);
	}

	public static Acceptor sequence(Acceptor... a) {
		return new Sequence(a);
	}

	public static Acceptor CHAR() {
		return new CHAR();
	}	

	public static Acceptor CHAR(char c) {
		return new CHAR(c);
	}
	
	public static Acceptor CHAR(char c1, char c2) {
		return new CHAR(c1, c2);
	}		

	public static Acceptor CHARS(String s) {
		return new CHARS(s);
	}		

	public static Acceptor CHARS(String[] ss) {
		return new CHARS(ss);
	}		
		
	public static Acceptor eof() {
		return new Eof();
	}
	
	//
	//
	// The following methods provide reusable lexer abstractions.
	//
	//
	
	public static final Acceptor any =
		new CHAR();
	
	public static final Acceptor upper =
		new CHAR('A','Z');
	
	public static final Acceptor lower =
		new CHAR('a','z');

	public static final Acceptor letter =
		new Choice(upper, lower);

	public static final Acceptor digit =
		new CHAR('0','9');
	
	public static final Acceptor space = 
		new CHAR(' ');

	public static final Acceptor newline = 
		new CHAR('\n');	

	public static final Acceptor tab = 
		new CHAR('\t');		
	
	public static final Acceptor whitespace =
		new Star(
				new Choice(
						space,
						newline,
						tab));	
	
	public static final Acceptor special = 
		new Sequence(
				new Not(
					new Choice(
							letter,
							digit,
							whitespace)),
			any);
}
