package org.softlang.antlr;

import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.runtime.*;
import org.junit.Test;
// import static org.junit.Assert.*;

public class Tests {
		
	private static String sampleCompany = "sample.Company";

	@Test
	public void testParse() throws IOException, RecognitionException {
		FileInputStream stream = new FileInputStream(sampleCompany);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        CompanyLexer lexer = new CompanyLexer(antlr);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CompanyParser parser = new CompanyParser(tokens);
        parser.company();		
	}
}
