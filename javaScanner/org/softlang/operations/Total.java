package org.softlang.operations;

import static org.softlang.tokenizer.Token.*;

import org.softlang.tokenizer.Token;
import org.softlang.tokenizer.Tokenizer;

import java.io.FileNotFoundException;

public class Total {
	
	public static double total(String s) throws FileNotFoundException {
		double total = 0;
		Tokenizer lexer = new Tokenizer(s);
		Token previous = null;
		for (Token current : lexer) {
			if (current==NUMBER && previous==SALARY) 
				total += Double.parseDouble(lexer.getLexeme());
			previous = current;
		}
		return total;
	}	
}
