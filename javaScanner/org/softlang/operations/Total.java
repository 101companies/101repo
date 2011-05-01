package org.softlang.operations;

import org.softlang.lexer.Token;
import static org.softlang.lexer.Token.*;
import org.softlang.lexer.Lexer;
import java.io.File;
import java.io.FileNotFoundException;

public class Total {

	private double total = 0;
	
	public double getTotal() {
		return total;
	}
	
	public Total(String s) throws FileNotFoundException {
		Lexer lexer = new Lexer(new File(s));
		Token previous = null;
		for (Token current : lexer) {
			if (current == NUMBER && previous == SALARY) 
				total += Double.parseDouble(lexer.getLexeme());
			previous = current;
		}
	}
	
}
