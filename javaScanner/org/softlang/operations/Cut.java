package org.softlang.operations;

import static org.softlang.tokenizer.Token.*;

import org.softlang.tokenizer.Token;
import org.softlang.tokenizer.Tokenizer;

import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class Cut {

	private Tokenizer lexer;
	private Writer writer;
	int indent = 0;
	
	// Local write that swallows checked exception, too
	private void write(String s) {
		try {
			writer.write(s);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}		
	}

	// Convenient macros for pretty printing
	private void space() { write(" "); }
	private void nl() { write("\n"); }
	private void right() { indent += 3; }
	private void left() { indent -= 3; }
	private void indent() { for(int i=0; i<indent; i++) space(); }		
		
	public Cut() { };
	
	public void cut(String in, String out) throws IOException {
		lexer = new Tokenizer(in);
		writer = new OutputStreamWriter(new FileOutputStream(out));
		Token previous = null; // test on NUMBER to follow SALARY
		String lexeme = null;
		for (Token current : lexer) {
			
			lexeme = lexer.getLexeme();

			// Cut salary in half
			if (current==NUMBER && previous==SALARY)
				lexeme = Double.toString(
							(Double.parseDouble(lexer.getLexeme())
								/ 2.0d));

			// Adjust indentation
			if (current==OPEN) right();
			if (current==CLOSE) left();

			// Add linebreaks
			if (current==DEPARTMENT
			||  current==MANAGER
			||  current==EMPLOYEE
			||  current==ADDRESS
			||  current==SALARY
			||  current==CLOSE) {
				nl();
				indent();
			}
			
			// Copy possibly modified lexeme
			write(lexeme + " ");

			previous = current;
		}
		writer.close();
	}
}
