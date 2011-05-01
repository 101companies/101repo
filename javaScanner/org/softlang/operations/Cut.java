package org.softlang.operations;

import org.softlang.lexer.Token;
import static org.softlang.lexer.Token.*;
import org.softlang.lexer.Lexer;

import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class Cut {

	private static void indent(Writer w, int d) throws IOException {
		w.write("\n");
		for(int i=0; i<d; i++) 
			w.write(" ");
	}	
	
	public Cut(String in, String out) throws IOException {
		Lexer lexer = new Lexer(new File(in));
		Writer writer = new OutputStreamWriter(new FileOutputStream(out));
		Token previous = null; // test on NUMBER to follow SALARY
		String lexeme = null;
		int indent = 0;
		for (Token current : lexer) {
			
			lexeme = lexer.getLexeme();

			// Cut salary in half
			if (current == NUMBER && previous == SALARY)
				lexeme = Double.toString(
							(Double.parseDouble(lexer.getLexeme())
								/ 2.0d));

			// Adjust indentation
			if (current==OPEN) indent += 3;
			if (current==CLOSE) indent -= 3;

			// Line break at times
			if (	current==CLOSE
				||	current==SALARY
				||	(current!=CLOSE && previous==CLOSE))
				indent(writer,indent);				

			// Copy possibly modified lexeme
			writer.write(lexeme + " ");

			// Line break after {
			if (current==OPEN)
				indent(writer,indent);

			previous = current;
		}
		writer.close();
	}
}
