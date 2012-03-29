package org.softlang.tests;

import static org.softlang.parser.CompanyParser.*;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.*;
import org.junit.Test;

public class Parsing {

	private static String posSample =
		"inputs" + File.separator + "sample.Company";
	private static String negSample =
		"inputs" + File.separator + "nonSample.Company";
		
	@Test
	public void testPositive() throws IOException, RecognitionException {
		parse(posSample);
    }       

	@Test(expected=RecognitionException.class)
	public void testNegative() throws IOException, RecognitionException {
		parse(negSample);
    }       
	
}
