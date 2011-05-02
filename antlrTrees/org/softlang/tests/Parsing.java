package org.softlang.tests;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;
import static org.softlang.company.CompanyParser.*;

public class Parsing {

	private static String posSample =
		"inputs" + File.separator + "sample.Company";
	private static String negSample =
		"inputs" + File.separator + "nonSample.Company";
				
	@Test
	public void testPositive() throws RecognitionException, IOException {
		CommonTree t = (CommonTree)parse(posSample).getTree();
		printTree(t);
    }       

	@Test(expected=RecognitionException.class)
	public void testNegative() throws IOException, RecognitionException {
		parse(negSample);
    }       

	private static void printTree(CommonTree t) {
		printTree(t, 0);			
	}
	
	private static void indent(int indent) {
		for (int i=0; i<indent; i++)
			System.out.print("   ");
	}
	
	private static void printTree(CommonTree t, int indent) {		
		if ( t != null ) {
			indent(indent);
			System.out.println(t.toString());
			for (int i = 0; i < t.getChildCount(); i++ ) {
				printTree((CommonTree)t.getChild(i), indent+1);
			}
		}
	}		
}
