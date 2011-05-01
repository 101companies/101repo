package org.softlang.tests;

import static org.softlang.parser.CompanyParser.*;

import java.io.IOException;
import org.antlr.runtime.*;
import org.junit.Test;

public class Parsing {
			
	@Test
	public void testPositive() throws IOException, RecognitionException {
		parse("sample.Company");
    }       

	@Test(expected=RecognitionException.class)
	public void testNegative() throws IOException, RecognitionException {
		parse("nonSample.Company");
    }       
	
}
