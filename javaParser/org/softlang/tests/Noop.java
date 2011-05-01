package org.softlang.tests;

import org.junit.Test;
import org.softlang.parser.Parser;
import org.softlang.parser.RecognitionException;
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
		Parser parser = new Parser();
		parser.parse(posSample);
	}

	@Test(expected=RecognitionException.class)
	public void testNeg() throws FileNotFoundException {
		Parser parser = new Parser();
		parser.parse(negSample);
	}
}
