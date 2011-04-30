package org.softlang.tests;

import org.junit.Test;
import static org.softlang.sax.SAXUtilities.*;
import org.softlang.sax.Tracer;

public class Trace {

    @Test
	public void testTrace() throws Exception {
		Tracer handler = new Tracer();
		parse(handler, "sampleCompany.xml");
	}
}
