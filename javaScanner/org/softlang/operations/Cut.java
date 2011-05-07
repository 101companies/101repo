package org.softlang.operations;

import static org.softlang.recognizer.Token.*;

import org.softlang.recognizer.Token;
import org.softlang.recognizer.Recognizer;

import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class Cut {

	private Recognizer tokenizer;
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
		tokenizer = new Recognizer(in);
		writer = new OutputStreamWriter(new FileOutputStream(out));
		Token previous = null; // test on NUMBER to follow SALARY
		String lexeme = null;
		for (Token current : tokenizer) {
			
			lexeme = tokenizer.getLexeme();

			// Cut salary in half
			if (current==FLOAT && previous==SALARY)
				lexeme = Double.toString(
							(Double.parseDouble(tokenizer.getLexeme())
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
