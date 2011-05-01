package org.softlang.operations;

import org.softlang.lexer.Token;
import static org.softlang.lexer.Token.*;
import org.softlang.lexer.Lexer;
import java.io.FileNotFoundException;

public class Total {
	
	public static double total(String s) throws FileNotFoundException {
		double total = 0;
		Lexer lexer = new Lexer(s);
		Token previous = null;
		for (Token current : lexer) {
			if (current==NUMBER && previous==SALARY) 
				total += Double.parseDouble(lexer.getLexeme());
			previous = current;
		}
		return total;
	}	
}
