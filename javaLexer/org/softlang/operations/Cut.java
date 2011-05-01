package org.softlang.operations;

import org.softlang.lexer.Token;
import static org.softlang.lexer.Token.*;
import org.softlang.lexer.Lexer;

import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class Cut {
	
	public Cut(String in, String out) throws IOException {
		Lexer lexer = new Lexer(in);
		Writer writer = new OutputStreamWriter(new FileOutputStream(out));
		Token previous = null; // test on NUMBER to follow SALARY
		String lexeme = null;
		for (Token current : lexer) {
			
			lexeme = lexer.getLexeme();

			// Cut salary in half
			if (current == NUMBER && previous == SALARY)
				lexeme = Double.toString(
							(Double.parseDouble(lexer.getLexeme())
								/ 2.0d));

			// Copy possibly modified lexeme
			writer.write(lexeme);

			if (current!=WS)
				previous = current;
		}
		writer.close();
	}
}
