package org.softlang.tests;

import org.junit.Test;
import org.softlang.tokenizer.RecognitionException;
import org.softlang.tokenizer.Tokenizer;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Try to consume all input with the lexer.
 * There is a positive and a negative test case.
 */
public class Noop {

	private static String posSample =
		"inputs" + File.separator + "sample.Company";
	private static String negSample =
		"inputs" + File.separator + "nonSample.Company";
	
	@Test
	public void testPos() throws FileNotFoundException {
		Tokenizer lexer = new Tokenizer(posSample);
		lexer.lexall();
	}

	@Test(expected=RecognitionException.class)
	public void testNeg() throws FileNotFoundException {
		Tokenizer lexer = new Tokenizer(negSample);
		lexer.lexall();
	}
}
