package parseLib.tests;

import parseLib.acceptor.*;
import parseLib.util.Input;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test parseLib.
 */
public class Acceptance {

	private Input i1 = new Input("ab");
	private Input i2 = new Input("ba");
	private Acceptor a;	

	@Test
	public void test() {
		
		a = new CHAR('a');
		i1.reset();
		i2.reset();
	    assertEquals(true, a.accept(i1));
	    assertEquals(true, i1.ready());
	    assertEquals(false, a.accept(i2));
	    assertEquals(true, i2.ready());

		a = new CHARS("ba");
		i1.reset();
		i2.reset();
	    assertEquals(false, a.accept(i1));
	    assertEquals(true, i1.ready());
	    assertEquals(true, a.accept(i2));
	    assertEquals(false, i2.ready());

	    a = new Choice(new CHAR('x'), new CHAR('a'));
		i1.reset();
		i2.reset();
	    assertEquals(true, a.accept(i1));
	    assertEquals(true, i1.ready());
	    assertEquals(false, a.accept(i2));
	    assertEquals(true, i2.ready());

	    a = new Sequence(new CHAR('a'), new CHAR('b'));
		i1.reset();
		i2.reset();
	    assertEquals(true, a.accept(i1));
	    assertEquals(false, i1.ready());
	    assertEquals(false, a.accept(i2));
	    assertEquals(true, i2.ready());

	    a = new Sequence(new CHAR('b'), new Optional(new CHAR('x')));
		i1.reset();
		i2.reset();
	    assertEquals(false, a.accept(i1));
	    assertEquals(true, i1.ready());
	    assertEquals(true, a.accept(i2));
	    assertEquals(true, i2.ready());

	    a = new Sequence(new Plus(new CHAR('b')), new Star(new CHAR('x')));
		i1.reset();
		i2.reset();
	    assertEquals(false, a.accept(i1));
	    assertEquals(true, i1.ready());
	    assertEquals(true, a.accept(i2));
	    assertEquals(true, i2.ready());
	}
}
