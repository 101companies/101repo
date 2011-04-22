package org.softlang.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.runtime.*;
import org.junit.Test;
import org.softlang.antlr.Company;

public class Lexing {
		
	private static void tokenizeCompany(String s) throws IOException {
		FileInputStream stream = new FileInputStream("inputs" + File.separatorChar + s);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        Company lexer = new Company(antlr);
        Token token;
        try {
        	while ((token = lexer.nextToken())!=Token.EOF_TOKEN)
        		System.out.println(token.toString());    
        } 
        catch (RuntimeException rt) {
            rt.printStackTrace();
            throw rt;        	
        }
	}
	
	@Test
	public void testPositive() throws IOException, RecognitionException {
		tokenizeCompany("sample.Company");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void tesNegative() throws IOException, RecognitionException {
		tokenizeCompany("nonSample.Company");
	}	
}
