package org.softlang.recognizer;

import static org.softlang.recognizer.Token.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Recognizer implements Iterator<Token> {
	
	Scanner scanner;
	String lexeme;

	private static Map<String,Token> keywords;
	
	static {
		keywords = new HashMap <String,Token>();
		keywords.put("company", 	COMPANY);
		keywords.put("department", 	DEPARTMENT);
		keywords.put("manager", 	MANAGER);		
		keywords.put("employee", 	EMPLOYEE);
		keywords.put("name", 	    NAME);
		keywords.put("address", 	ADDRESS);
		keywords.put("salary", 		SALARY);
		keywords.put("{", 			OPEN);
		keywords.put("}", 			CLOSE);		
	}
		
	public Recognizer(String s) throws FileNotFoundException {
		scanner = new Scanner(new File(s));
	}

	public String getLexeme() {
		return lexeme;
	}

	public static Token classify(String s) {
		if (keywords.containsKey(s))
			return keywords.get(s);
		else if (s.matches("\"[^\"]*\""))
			return STRING;
		else if (s.matches("\\d+(\\.\\d*)?"))
			return FLOAT;
		else 
			throw new RecognitionException("Tokenizer failed at " + s);					
	}
	
	public boolean hasNext() {
		return scanner.hasNext();
	}
	
	public Token next() {
		lexeme = scanner.next();
		return classify(lexeme);
	}
		
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	// Stress test: lex until end-of-file
	public void lexall() {
		while (hasNext()) {
			Token t = next();
			System.out.println(t + " : " + lexeme);
		}	
	}
}
