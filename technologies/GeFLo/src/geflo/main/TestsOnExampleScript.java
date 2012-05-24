package geflo.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import geflo.pattern.GeFLoMatcher;
import geflo.pattern.GeFLoMatcher.MatchingLineBounds;
import geflo.pattern.GeFLoRegistry;

import java.util.logging.Level;

import org.junit.Before;
import org.junit.Test;

public class TestsOnExampleScript {
	
	private String scriptInput;
	
	@Before
	public void prepare() {
		// Turn the logger off
                GeFLoRegistry.getLogger().setLevel(Level.OFF);
		
		scriptInput = GeFLoMatcher.prepareScript(
				ExampleFactory.createScript()
			);
	}
	
	/**
	 * Checks if an pattern matches by two assertions
	 * 
	 * @param boundsString	matching line bounds, which are expected
	 * @param pattern
	 */
	protected void assertPatternMatches(final String boundsString, final String pattern) {
		final MatchingLineBounds bounds = GeFLoMatcher.find(pattern, scriptInput);
		try {
			if (boundsString != null) assertNotNull(bounds);
			assertEquals(boundsString, bounds.toString());
		} catch(AssertionError e) {
			throw new AssertionError(
					"Expected: "
					+((boundsString == null) ? "no matchings" : boundsString)
					+", but found: "
					+((bounds == null) ? "nothing" : bounds.toString())
				);
		}
	}
	
	/**
	 * Provided example for total
	 */
	@Test
	public void totalTest() {
		assertPatternMatches("5:11",	"def total ^[def]*");
	}
	
	/**
	 * Alternative example for total
	 */
	@Test
	public void totalLookaheadTest() {
		assertPatternMatches("5:11",	"def total .* > def");
	}
	
	/**
	 * Provided example for cut
	 */
	@Test
	public void cutTest() {
		assertPatternMatches("13:17",	"def cut .* > end$");
	}
	
	/**
	 * Example for cut with use off sequences
	 */
	@Test
	public void cutSeqTest() {
		assertPatternMatches("13:17",	"def cut .* cut end end > end");
	}
	
	/**
	 * Example for look-arounds with sequences
	 */
	@Test
	public void seqLookaroundTest() {
		assertPatternMatches("3:11",	"class Company < .* def total .* > def cut");
	}
	
	/**
	 * Example for negated sequences
	 */
	@Test
	public void negatedSeqTest() {
		assertPatternMatches("5:11",	"def total ^[def cut]*");
	}
	
	/**
	 * Different patterns, which all should match the complete script
	 */
	@Test
	public void completeTest() {
		assertPatternMatches("1:18",	"^.*$");
		assertPatternMatches("1:18",	"^.* $");
		assertPatternMatches("1:18",	"^ .* $");
		assertPatternMatches("1:18",	"^.*");
		assertPatternMatches("1:18",	"^ .*");
		assertPatternMatches("1:18",	".*$");
		assertPatternMatches("1:18",	".* $");
	}
	
}
