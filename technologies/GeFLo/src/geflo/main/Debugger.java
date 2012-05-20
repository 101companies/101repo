package geflo.main;

import geflo.pattern.GeFLoMatcher;
import geflo.pattern.GeFLoMatcher.MatchingLineBounds;
import geflo.pattern.GeFLoPattern;
import geflo.pattern.GeFLoPatternParser;
import geflo.pattern.GeFLoRegistry;
import geflo.script.Script;

import java.util.logging.Level;

/**
 * This could be used to test new patterns
 * and to test the implementation on correctness
 * with enhanced console output.
 *
 */
public class Debugger {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Turn the logger off
		GeFLoRegistry.getLogger().setLevel(Level.OFF);
		
		final Script script	= ExampleFactory.createScript();
		final String input	= GeFLoMatcher.prepareScript(script);
		
		// Tests:
		//	"def total .* > def"	=> 5:11
		//	"def total ^[def]*"		=> 5:11
		//	"def cut .* > end$"		=> 13:17
		
		final GeFLoPattern pattern = GeFLoPatternParser.parse(
				"def total .* > def"
			);
		
		System.out.println(pattern.toJavaPattern());
		System.out.println(input);
		
		final MatchingLineBounds b = GeFLoMatcher.find(pattern, input);
		
		if (b == null) {
			System.err.println("No matching!");
		} else {
			System.out.println(b);
		}
	}

}
