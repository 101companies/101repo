package org.softlang.operations;

import org.softlang.recognizer.Recognizer;
import org.softlang.recognizer.Token;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * For clarification, this is precise copy.
 */
public class Copy {
	
	@SuppressWarnings("unused")
	public Copy(String in, String out) throws IOException {
		Recognizer lexer = new Recognizer(in);
		Writer writer = new OutputStreamWriter(new FileOutputStream(out));
		String lexeme = null;
		for (Token current : lexer) {
			lexeme = lexer.getLexeme();
			writer.write(lexeme);
		}
		writer.close();
	}
}
