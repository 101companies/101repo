package org.softlang.parser;

import parseLib.acceptor.*;
import static parseLib.acceptor.Acceptor.*;

/**
 * A combinator-based lexer for companies
 */
public class CompanyLexer {

	/**
	 * Use common form of whitespace
	 */
	private static final Acceptor WS = whitespace;

	/**
	 * Macro for pre-composing token expressions with optional whitespace
	 */
	private static Acceptor WS(Acceptor a) {
		return sequence(
					optional(WS),
					a
				);
	}
	
	/**
	 * Double-quoted strings
	 */
	public static final Acceptor STRING =
		WS(sequence(
				CHAR('"'),
				star(sequence(not(CHAR('"')),any)),
				CHAR('"')));

	/**
	 * Floating point numbers
	 */
	public static final Acceptor FLOAT =
		WS(sequence(
				plus(digit),
				optional(
					sequence(
						CHAR('.'),
						star(digit)))));
	
	/**
	 * Keywords and special symbols
	 */
	public static final Acceptor SPECIAL(String s) {
		return WS(CHARS(s));
	}	
	
	/**
	 * End of file
	 */
	public static final Acceptor EOF =
		WS(eof());
}
