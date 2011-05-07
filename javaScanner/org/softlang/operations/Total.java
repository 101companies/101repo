package org.softlang.operations;

import static org.softlang.tokenizer.Token.*;

import org.softlang.tokenizer.Token;
import org.softlang.tokenizer.Tokenizer;

import java.io.FileNotFoundException;

public class Total {
	
	public static double total(String s) throws FileNotFoundException {
		double total = 0;
		Tokenizer tokenizer = new Tokenizer(s);
		Token previous = null;
		for (Token current : tokenizer) {
			if (current==NUMBER && previous==SALARY) 
				total += Double.parseDouble(tokenizer.getLexeme());
			previous = current;
		}
		return total;
	}	
}
