package org.softlang.operations;

import static org.softlang.recognizer.Token.*;

import org.softlang.recognizer.Lexer;
import org.softlang.recognizer.Token;

import java.io.FileNotFoundException;

public class Total {

	private double total = 0;
	
	public double getTotal() {
		return total;
	}
	
	public Total(String s) throws FileNotFoundException {
		Lexer lexer = new Lexer(s);
		Token previous = null;
		for (Token current : lexer) {
			if (current == NUMBER && previous == SALARY) 
				total += Double.parseDouble(lexer.getLexeme());
			if (current!=WS)
				previous = current;
		}
	}
	
}
