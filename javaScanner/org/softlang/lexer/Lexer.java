package org.softlang.lexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Lexer implements Iterable<Token> {
	
	Scanner scanner;
	String lexeme;
	
	public Lexer(String s) throws FileNotFoundException {
		scanner = new Scanner(new File(s));
	}

	public String getLexeme() {
		return lexeme;
	}

	public Iterator<Token> iterator() {
		return new TokenStream(this);
	}
	
	// Stress test: lex until end-of-file
	public void lexall() {
		for (Token t : this) { 
			System.out.println(t + " : " + lexeme);
		}	
	}	
}
