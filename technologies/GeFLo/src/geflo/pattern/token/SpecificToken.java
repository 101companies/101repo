package geflo.pattern.token;

import geflo.pattern.GeFLoMatcher;

import java.util.regex.Pattern;

public class SpecificToken extends Token {
	
	private String name;
	
	public SpecificToken(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return GeFLoMatcher.quote(name);
	}
	
	@Override
	public String toJavaPattern() {
		return Pattern.quote(name);
	}
	
	@Override
	public String toLineMatchingJavaPattern() {
		return GeFLoMatcher.LINE_PATTERN+toJavaPattern();
	}
	
}
