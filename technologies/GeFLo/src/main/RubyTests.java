package main;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RubyTests {
	
	private String scriptInput;
	
	@Before
	public void tearUp() {
		scriptInput = GeFLoPattern.prepareScript(
				RubyExampleFactory.createScript()
			);
	}
	
	@Test
	public void totalTest() {
		assertEquals(GeFLoPattern.find("def total .* > def", scriptInput).toString(), "5:13");
	}
	
	@Test
	public void total2Test() {
		assertEquals(GeFLoPattern.find("def total ^[def]*", scriptInput).toString(), "5:13");
	}
	
	@Test
	public void cutTest() {
		assertEquals(GeFLoPattern.find("def cut .* > end$", scriptInput).toString(), "13:18");
	}
	
}
