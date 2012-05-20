package geflo.pattern.quantifier;

import geflo.pattern.GeFLoPattern;
import geflo.pattern.LineMatchingWrapper;

public class Plus extends Quantifier {
	
	public Plus(GeFLoPattern pattern) {
		super(pattern);
	}
	
	@Override
	public char getSymbol() {
		return '+';
	}
	
	@Override
	public boolean owns(GeFLoPattern pattern) {
		return this == pattern || getPattern() == pattern;
	}
	
	@Override
	public boolean canMatchMultipleTokens() {
		return true;
	}
	
	@Override
	public String toLineMatchingJavaPattern() {
		return new Plus(new LineMatchingWrapper(getPattern())).toJavaPattern();
	}

	@Override
	public Plus clone() {
		return new Plus(getPattern());
	}
	
}
