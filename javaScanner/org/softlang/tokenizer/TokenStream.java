package org.softlang.tokenizer;

import static org.softlang.tokenizer.Token.ADDRESS;
import static org.softlang.tokenizer.Token.CLOSE;
import static org.softlang.tokenizer.Token.COMPANY;
import static org.softlang.tokenizer.Token.DEPARTMENT;
import static org.softlang.tokenizer.Token.EMPLOYEE;
import static org.softlang.tokenizer.Token.MANAGER;
import static org.softlang.tokenizer.Token.NAME;
import static org.softlang.tokenizer.Token.NUMBER;
import static org.softlang.tokenizer.Token.OPEN;
import static org.softlang.tokenizer.Token.SALARY;
import static org.softlang.tokenizer.Token.STRING;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//
// We do not use an anonymous class for simplicity.
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
	
	private Tokenizer lexer;
	
	TokenStream(Tokenizer lexer) {
		this.lexer = lexer;
	}
	
	public boolean hasNext() {
		return lexer.scanner.hasNext();
	}

	public Token next() {
		lexer.lexeme = lexer.scanner.next();
		if (keywords.containsKey(lexer.lexeme))
			return keywords.get(lexer.lexeme);
		else if (lexer.lexeme.matches("\"[^\"]*\""))
			return STRING;
		else if (lexer.lexeme.matches("\\d+(\\.\\d*)?"))
			return NUMBER;
		else 
			throw new RecognitionException("Lexer failed at " + lexer.lexeme);					
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
