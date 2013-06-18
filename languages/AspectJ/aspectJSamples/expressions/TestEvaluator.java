package expressions;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestEvaluator {
		
	@Test
	public void testLit() {
		Lit x = new Lit();
		x.setInfo(42);
		assertEquals("evaluate a literal", 42, x.evaluate());
	}
	
	@Test
	public void testAdd() {
		Add x = new Add();
		Lit y = new Lit();
		y.setInfo(1);
		x.left = y;
		y = new Lit();
		y.setInfo(2);
		x.right = y;
		assertEquals("evaluate addition", 3, x.evaluate());
	}	
}
