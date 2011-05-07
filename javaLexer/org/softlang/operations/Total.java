package org.softlang.operations;

import static org.softlang.recognizer.Token.*;

import org.softlang.recognizer.Recognizer;
import org.softlang.recognizer.Token;

import java.io.FileNotFoundException;

public class Total {

	private double total = 0;
	
	public double getTotal() {
		return total;
	}
	
	public Total(String s) throws FileNotFoundException {
		Recognizer lexer = new Recognizer(s);
		Token previous = null;
		for (Token current : lexer) {
			if (current == FLOAT && previous == SALARY) 
				total += Double.parseDouble(lexer.getLexeme());
			if (current!=WS)
				previous = current;
		}
	}
	
}
