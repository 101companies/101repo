package geflo.pattern.quantifier;

import geflo.pattern.GeFLoPattern;
import geflo.pattern.LineMatchingWrapper;

public class Star extends Quantifier {
	
	public Star(GeFLoPattern pattern) {
		super(pattern);
	}
	
	@Override
	public char getSymbol() {
		return '*';
	}
	
	@Override
	public boolean canMatchMultipleTokens() {
		return true;
	}
	
	@Override
	public String toLineMatchingJavaPattern() {
		return new Star(new LineMatchingWrapper(getPattern())).toJavaPattern();
	}
	
	@Override
	public Star clone() {
		return new Star(getPattern());
	}
	
}
