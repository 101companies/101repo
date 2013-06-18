package expressions;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestPrettyPrinter {
		
	@Test
	public void testLit() {
		Lit x = new Lit();
		x.setInfo(42);
		assertEquals("pretty print a literal", "42", x.prettyPrint());
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
		assertEquals("pretty print addition", "1 + 2", x.prettyPrint());
	}	
}
