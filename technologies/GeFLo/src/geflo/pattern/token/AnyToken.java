package geflo.pattern.token;

import geflo.pattern.GeFLoMatcher;

public class AnyToken extends Token {
	
	@Override
	public String toString() {
		return ".";
	}
	
	@Override
	public String toJavaPattern() {
		return "(?:[^"+GeFLoMatcher.PRE_DELIMITER+"]+)";
	}
	
	@Override
	public String toLineMatchingJavaPattern() {
		return GeFLoMatcher.LINE_PATTERN+toJavaPattern();
	}
	
}
