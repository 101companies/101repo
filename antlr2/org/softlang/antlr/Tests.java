package org.softlang.antlr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.junit.Test;
// import static org.junit.Assert.*;
import org.softlang.antlr.CompanyParser.company_return;

public class Tests {
		
	private static String sampleCompany =
		  ".." + File.separator
		+ "antlr" + File.separator
		+ "sample.Company";

	@Test
	public void testParse() throws IOException, RecognitionException {
		FileInputStream stream = new FileInputStream(sampleCompany);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        CompanyLexer lexer = new CompanyLexer(antlr);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CompanyParser parser = new CompanyParser(tokens);
        
        company_return r = parser.company();

        // Write out as string
        if ( r.tree!=null ) {
            System.out.println(((Tree)r.tree).toStringTree());
            ((CommonTree)r.tree).sanityCheckParentAndChildIndexes();
        }
        
        // Tree walk-based and indentation-aware output
        CommonTree tree = (CommonTree)r.getTree();
        printTree(tree, 0);
    }       
        	
	private void printTree(CommonTree t, int indent) {
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
