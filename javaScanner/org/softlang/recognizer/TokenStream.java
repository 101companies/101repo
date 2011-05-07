package org.softlang.recognizer;

import static org.softlang.recognizer.Token.ADDRESS;
import static org.softlang.recognizer.Token.CLOSE;
import static org.softlang.recognizer.Token.COMPANY;
import static org.softlang.recognizer.Token.DEPARTMENT;
import static org.softlang.recognizer.Token.EMPLOYEE;
import static org.softlang.recognizer.Token.FLOAT;
import static org.softlang.recognizer.Token.MANAGER;
import static org.softlang.recognizer.Token.NAME;
import static org.softlang.recognizer.Token.OPEN;
import static org.softlang.recognizer.Token.SALARY;
import static org.softlang.recognizer.Token.STRING;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//
// This could be an anonymous class.
//
class TokenStream implements Iterator<Token> {

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
	
	private Recognizer tokenizer;
	
	TokenStream(Recognizer tokenizer) {
		this.tokenizer = tokenizer;
	}
	
	public boolean hasNext() {
		return tokenizer.scanner.hasNext();
	}

	public Token next() {
		tokenizer.lexeme = tokenizer.scanner.next();
		if (keywords.containsKey(tokenizer.lexeme))
			return keywords.get(tokenizer.lexeme);
		else if (tokenizer.lexeme.matches("\"[^\"]*\""))
			return STRING;
		else if (tokenizer.lexeme.matches("\\d+(\\.\\d*)?"))
			return FLOAT;
		else 
			throw new RecognitionException("Tokenizer failed at " + tokenizer.lexeme);					
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
