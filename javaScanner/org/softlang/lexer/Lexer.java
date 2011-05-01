package org.softlang.lexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import static org.softlang.lexer.Token.*;

public class Lexer implements Iterable<Token> {
	
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
	
	private Scanner scanner;
	private String lexeme;
	
	public Lexer(File f) throws FileNotFoundException {
		scanner = new Scanner(f);
	}

	public Iterator<Token> iterator() {
		return new Iterator<Token>() {
			public boolean hasNext() {
				return scanner.hasNext();
			}

			public Token next() {
				lexeme = scanner.next();
				if (keywords.containsKey(lexeme))
					return keywords.get(lexeme);
				else if (lexeme.matches("\"[^\"]*\""))
					return STRING;
				else if (lexeme.matches("\\d*(\\.\\d*)?"))
					return NUMBER;
				else 
					throw new RuntimeException(
							new IOException(
								"Lexer failed at " + lexeme));					
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
		
	public String getLexeme() {
		return lexeme;
	}
}
