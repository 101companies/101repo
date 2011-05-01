package org.softlang.tests;

import org.junit.Test;
import org.softlang.parser.*;
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
	public void testAcceptPos() throws FileNotFoundException {
		Acceptor a = new Acceptor();
		a.accept(posSample);
	}

	@Test(expected=RecognitionException.class)
	public void testAcceptNeg() throws FileNotFoundException {
		Acceptor a = new Acceptor();
		a.accept(negSample);
	}
		
	@Test
	public void testParsePos() throws FileNotFoundException {
		Parser p = new Parser();
		p.parse(posSample);
	}

	@Test(expected=RecognitionException.class)
	public void testParseNeg() throws FileNotFoundException {
		Parser p = new Parser();
		p.parse(negSample);
	}
}
