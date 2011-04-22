package org.softlang.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.junit.Test;
// import static org.junit.Assert.*;
import org.softlang.antlr.CompanyLexer;
import org.softlang.antlr.CompanyParser;
import org.softlang.antlr.CompanyParser.company_return;

public class Parsing {

	private static void parseCompany(String s) throws IOException, RecognitionException {
		FileInputStream stream = new FileInputStream("inputs" + File.separatorChar + s);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        CompanyLexer lexer = new CompanyLexer(antlr);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CompanyParser parser = new CompanyParser(tokens);
        
        company_return r = parser.company();
        if (parser.error) throw new RecognitionException();

        // Write out as string
        if ( r.getTree()!=null ) {
            System.out.println(((Tree)r.getTree()).toStringTree());
            ((CommonTree)r.getTree()).sanityCheckParentAndChildIndexes();
        }
        
        // Tree walk-based and indentation-aware output
        CommonTree tree = (CommonTree)r.getTree();
        printTree(tree, 0);
	}	
	
	@Test
	public void testPositive() throws IOException, RecognitionException {
		parseCompany("sample.Company");
    }       

	@Test(expected=RecognitionException.class)
	public void testNegative() throws IOException, RecognitionException {
		parseCompany("nonSample.Company");
    }       

	private static void printTree(CommonTree t, int indent) {
		if ( t != null ) {
			StringBuffer sb = new StringBuffer(indent);
			for ( int i = 0; i < indent; i++ )
				sb = sb.append("   ");
			for ( int i = 0; i < t.getChildCount(); i++ ) {
				System.out.println(sb.toString() + t.getChild(i).toString());
				printTree((CommonTree)t.getChild(i), indent+1);
			}
		}
	}		
}
