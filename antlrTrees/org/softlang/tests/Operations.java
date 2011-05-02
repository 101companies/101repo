package org.softlang.tests;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.softlang.company.CompanyParser.*;
import org.softlang.company.Total;
import org.softlang.company.Cut;

public class Operations {

	private static String sampleCompany =
		"inputs" + File.separator + "sample.Company";
				
	@Test
	public void testTotal() throws RecognitionException, IOException {
		CommonTree t = (CommonTree)parse(sampleCompany).getTree();
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		Total total = new Total(nodes);
		total.company();
	    assertEquals(399747, total.total, 0);
    }
	
	@Test
	public void testCut() throws RecognitionException, IOException {
		CommonTree t1 = (CommonTree)parse(sampleCompany).getTree();
		CommonTreeNodeStream nodes1 = new CommonTreeNodeStream(t1);
		Cut cut = new Cut(nodes1);
		CommonTree t2 = (CommonTree)cut.downup(t1);
		CommonTreeNodeStream nodes2 = new CommonTreeNodeStream(t2);
		Total total = new Total(nodes2);
		total.company();
	    assertEquals(399747 / 2.0d, total.total, 0);
    }       
	
}
