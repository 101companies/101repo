package org.softlang.recognizer;

import static org.softlang.recognizer.Token.*;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Recognizer implements Iterator<Token> {

	Token token = null; // last token recognized
    boolean eof = false; // reached end of file
	private Reader reader = null; // input stream
	private int lookahead = 0; // lookahead, if any
	private int[] buffer = new int[128]; // lexeme buffer
	private int index = 0; // length of lexeme
	
	// Keywords to token mapping
	private static Map<String,Token> keywords;
	
	static {
		keywords = new HashMap <String,Token>();
		keywords.put("company",     COMPANY);
		keywords.put("department",  DEPARTMENT);
		keywords.put("manager",     MANAGER);		
		keywords.put("employee",    EMPLOYEE);
		keywords.put("name",        NAME);
		keywords.put("address",     ADDRESS);
		keywords.put("salary",      SALARY);
	}
	
	public Recognizer(String s) throws FileNotFoundException {
		this.reader = new BufferedReader(
						new FileReader(
							new File(s)));
	}
	
	// Extract lexeme from buffer
	public String getLexeme() {
		return new String(buffer,0,index);
	}

	// Reset state to begin new token
	private void reset() throws IOException {
		if (eof)
			throw new IllegalStateException();
		index = 0;
		token = null;
		if (lookahead==0)
			read();
	}

	//
	// Read one more char.
	// Add previous char, if any, to the buffer.
	//
	private void read() throws IOException {
		if (eof)
			throw new IllegalStateException();
		if (lookahead!=0) {
			buffer[index] = lookahead;
			index++;
			if (index==128) 
				throw new IllegalStateException();			
		}
		lookahead = reader.read();
	}
	
	// Recognize a token
	public void lex() throws IOException {
		reset();

		// Recognize whitespace
		if (Character.isWhitespace(lookahead)) {
			do {
				read();
			} while (Character.isWhitespace(lookahead));
			token = WS;
			return;
		}

		// Recognize end of file
		if (lookahead==-1) {
			eof = true;
			token = EOF;
			return;
		}
				
		// Recognize {
		if (lookahead=='{') {
			token = OPEN;
			read();
			return;
		}

		// Recognize }
		if (lookahead=='}') {
			token = CLOSE;
			read();
			return;
		}
			
		// Recognize identifier
		if (Character.isLetter(lookahead)) {
			do {
				read();
			} while (Character.isLetter(lookahead));
			String lexeme = getLexeme();
			if (keywords.containsKey(lexeme)) {
				token = keywords.get(lexeme);
				return;
			}
			else
				throw new RecognitionException("Unknown identifier " + lexeme);
		}
			
		// Recognize float
		if (Character.isDigit(lookahead)) {
			do {
				read();
			} while (Character.isDigit(lookahead));
			if (lookahead=='.') {
				read();
				while (Character.isDigit(lookahead))
					read();
			}
			token = FLOAT;
			return;
		}
			
		// Recognize string
		if (lookahead=='"') {
			do {
				read();
			} while (lookahead!='"');
			read();
			token = STRING;
			return;			
		}
		
		throw new RecognitionException("Recognizer giving up at " + lookahead);
		
	}

	public boolean hasNext() {
		if (token!=null)
			return true;
		if (eof)
			return false;
		try {
			lex();
		} catch (IOException e) {
			throw new RecognitionException(e);
		}
		return true;
	}
	
	public Token next() {
		if (hasNext()) {
			Token result = token;
			token = null;
			return result;
		}
		else
			throw new IllegalStateException();
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	// Stress test: lex until end-of-file
	public void lexall() {
		while (hasNext()) {
			Token t = next();
			System.out.println(t + " : " + getLexeme());
		}	
	}
}
