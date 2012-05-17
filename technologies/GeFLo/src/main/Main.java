package main;

import main.GeFLoPattern.MatchingLineBounds;
import main.script.Script;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Script script = RubyExampleFactory.createScript();
		
		// Tests:
		//	"def total .* > def"	=> 5:13
		//	"def total ^[def]*"		=> 5:13
		//	"def cut .* > end$"		=> 13:18
		
		final MatchingLineBounds b = GeFLoPattern.find(
				"def cut .* > end$",
				script
			);
		
		if (b == null) {
			System.err.println("No matching!");
		} else {
			System.out.println(b);
		}
	}

}
