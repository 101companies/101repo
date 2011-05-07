package org.softlang.recognizer;

import java.util.Iterator;
import java.io.IOException;

public class TokenStream implements Iterator<Token> {

	private Recognizer lexer;
	
	public TokenStream(Recognizer lexer) {
		this.lexer = lexer;
	}
	
	public boolean hasNext() {
		if (lexer.token!=null)
			return true;
		if (lexer.eof)
			return false;
		try {
			lexer.lex();
		} catch (IOException e) {
			throw new RecognitionException(e);
		}
		return true;
	}
	public Token next() {
		if (hasNext()) {
			Token result = lexer.token;
			lexer.token = null;
			return result;
		}
		else
			throw new IllegalStateException();
	}
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
