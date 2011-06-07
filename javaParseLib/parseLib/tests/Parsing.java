package parseLib.tests;

import parseLib.acceptor.*;
import parseLib.parser.*;
import parseLib.util.Input;
import org.junit.Test;
import static org.junit.Assert.*;

public class Parsing {

	private Input i1 = new Input("ab");
	private Input i2 = new Input("12");
		
	@Test
	public void test() {
		
		i1.reset();
		i2.reset();
		Parser<String> p1 = new MkString(new CHARS("ab"));
		assertEquals("ab", p1.parse(i1));
		assertEquals(null, p1.parse(i2));

		i1.reset();
		i2.reset();
		Parser<Integer> p2 = new MkInteger(new parseLib.acceptor.Plus(new CHAR('0','9')));
		assertEquals(null, p2.parse(i1));
		assertEquals(12, p2.parse(i2).intValue());
	}
}
