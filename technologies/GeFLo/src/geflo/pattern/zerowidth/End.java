package geflo.pattern.zerowidth;

import geflo.pattern.GeFLoMatcher;

public class End extends ZeroWidth {
	
	public static final String JAVA_PATTERN = "$";
	
	public String toString() {
		return "$";
	}
	
	@Override
	public String toJavaPattern() {
		return JAVA_PATTERN;
	}
	
	@Override
	public String toLineMatchingJavaPattern() {
		return GeFLoMatcher.LINE_PATTERN+toJavaPattern();
	}
	
}
