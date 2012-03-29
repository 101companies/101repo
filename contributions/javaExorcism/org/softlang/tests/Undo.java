package org.softlang.tests;

import org.softlang.company.Company;
import org.softlang.company.factory.*;
import org.softlang.features.TotalReducer;
import org.softlang.command.CutCompany;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class Undo {

	private void testUndo(Factory f) {
		Company sampleCompany = Basics.createSampleCompany(f);
		TotalReducer total = new TotalReducer();
		double before = total.reduce(sampleCompany);
	    assertEquals(399747, before, 0);
	    CutCompany cut = new CutCompany(sampleCompany);
	    assertEquals(before, total.reduce(sampleCompany), 0);
	    cut.execute();
	    assertEquals(before / 2.0, total.reduce(sampleCompany), 0);
	    cut.undo();
	    assertEquals(before, total.reduce(sampleCompany), 0);
	}
	
	@Test
	public void testUndoPojo() {
		testUndo(new PojoFactory());
	}
	
	@Test
	public void testUndoBean() {
		testUndo(new BeanFactory());
	}	
}
