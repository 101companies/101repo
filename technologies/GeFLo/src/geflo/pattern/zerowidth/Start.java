package geflo.pattern.zerowidth;

import geflo.pattern.GeFLoMatcher;
import geflo.pattern.GeFLoPattern;

public class Start implements GeFLoPattern {
	
	public static final String JAVA_PATTERN = "^";
	
	public String toString() {
		return "^";
	}
	
	@Override
	public boolean owns(GeFLoPattern pattern) {
		return this == pattern;
	}
	
	@Override
	public String toJavaPattern() {
		return JAVA_PATTERN;
	}
	
	@Override
	public String toLineMatchingJavaPattern() {
		return toJavaPattern()+GeFLoMatcher.LINE_PATTERN;
	}
	
}
