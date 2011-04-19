package org.softlang.tests;

import java.io.IOException;

import org.softlang.company.Company;

import static org.softlang.operations.Cut.*;
import static org.softlang.operations.Total.*;
import static org.softlang.antlr.CompanyParser.*;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import static org.junit.Assert.*;

public class Basics {
	
	@Test
	public void testTotal() throws IOException, RecognitionException {
		Company c = parse("sample.Company");
	    double total = total(c);		
	    assertEquals(399747, total, 0);
	}
	
	@Test
	public void testCut() throws IOException, RecognitionException {
		Company c = parse("sample.Company");
		cut(c);
	    double total = total(c);		
	    assertEquals(199873.5, total, 0);
	}
}
