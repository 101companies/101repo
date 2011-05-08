package org.softlang.recognizer;

import static org.softlang.recognizer.Token.*;

import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 * An acceptor only.
 * See class Parser for an elaboration that allows for injection of semantic actions.
 */
public class Acceptor {

	private Lexer lexer;
	private Token lookahead;
	
	// Parse a file
	public void accept(String s)	throws FileNotFoundException {
		lexer = new Lexer(s);
		company();
		match(EOF);
	}
	
	//
	// Match expected with actual tokem.
	// Consume the token if successful.
	// Throw exception if not successful.
	//
	private String match(Token token) {
		if (test(token)) {
			lookahead = null;
			return lexer.getLexeme();
		}
		else
			throw new RecognitionException("Expected: " + token + "; Found: " + lookahead);
	}

	// Test actual token
	private boolean test(Token token) {
		if (lookahead==null)
			lookahead = lexer.next();
		return (lookahead==token);
	}
	
	// Parse companies
	private final void company() {
		match(COMPANY);
		match(STRING);
		match(OPEN);
		while (test(DEPARTMENT))
			department();
		match(CLOSE);
	}
	
	// Parse departments
	private final void department() {
		match(DEPARTMENT);
		match(STRING);
		match(OPEN);
		match(MANAGER);
		employee();
		while (test(EMPLOYEE)) {
			match(EMPLOYEE);
			employee();
		}
		while (test(DEPARTMENT))
			department();
		match(CLOSE);
	}
		
	// Parse employees
	private final void employee() {
		match(STRING);
		match(OPEN);
		match(ADDRESS);
		match(STRING); 
		match(SALARY);
		match(FLOAT); 
		match(CLOSE);
	}
}
