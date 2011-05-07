package org.softlang.operations;

import static org.softlang.recognizer.Token.*;

import org.softlang.recognizer.Token;
import org.softlang.recognizer.Recognizer;

import java.io.FileNotFoundException;

public class Total {
	
	public static double total(String s) throws FileNotFoundException {
		double total = 0;
		Recognizer recognizer = new Recognizer(s);
		Token current = null;
		Token previous = null;
		while (recognizer.hasNext()) {
			current = recognizer.next();
			if (current==FLOAT && previous==SALARY) 
				total += Double.parseDouble(recognizer.getLexeme());
			previous = current;
		}
		return total;
	}	
}
