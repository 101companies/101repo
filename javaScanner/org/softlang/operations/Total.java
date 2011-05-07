package org.softlang.operations;

import static org.softlang.recognizer.Token.*;

import org.softlang.recognizer.Token;
import org.softlang.recognizer.Recognizer;

import java.io.FileNotFoundException;

public class Total {
	
	public static double total(String s) throws FileNotFoundException {
		double total = 0;
		Recognizer tokenizer = new Recognizer(s);
		Token previous = null;
		for (Token current : tokenizer) {
			if (current==FLOAT && previous==SALARY) 
				total += Double.parseDouble(tokenizer.getLexeme());
			previous = current;
		}
		return total;
	}	
}
