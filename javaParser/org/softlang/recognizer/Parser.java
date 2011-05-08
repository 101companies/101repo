package org.softlang.recognizer;

import static org.softlang.recognizer.Token.*;

import java.io.FileNotFoundException;
import java.util.Iterator;

public class Parser {

	private Lexer lexer;
	private Token lookahead;
	
	// Parse a file
	public void parse(String s)	throws FileNotFoundException {
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
		String name = match(STRING);
		match(OPEN);
		openCompany(name);
		while (test(DEPARTMENT))
			department();
		match(CLOSE);
		closeCompany(name);
	}
	
	// Parse departments
	private final void department() {
		match(DEPARTMENT);
		String name = match(STRING);
		match(OPEN);
		openDept(name);
		match(MANAGER);
		employee(true);
		while (test(EMPLOYEE)) {
			match(EMPLOYEE);
			employee(false);
		}
		while (test(DEPARTMENT))
			department();
		match(CLOSE);
		closeDept(name);		
	}
		
	// Parse employees
	private final void employee(boolean isManager) {
		String name = match(STRING);
		match(OPEN);
		match(ADDRESS);
		String address = match(STRING); 
		match(SALARY);
		Double salary = Double.parseDouble(match(FLOAT)); 
		match(CLOSE);
		handleEmployee(isManager,name,address,salary);
	}
	
	// Handlers
	protected void openCompany(String name) { }
	protected void closeCompany(String name) { }
	protected void openDept(String name) { }
	protected void closeDept(String name) { }
	protected void handleEmployee(boolean isManager, String name, String address, Double salary) { }
}
