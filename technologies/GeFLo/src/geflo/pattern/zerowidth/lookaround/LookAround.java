package geflo.pattern.zerowidth.lookaround;

import geflo.pattern.GeFLoPattern;
import geflo.pattern.LineMatchingNotSupportedException;
import geflo.pattern.quantifier.Negation;
import geflo.pattern.zerowidth.ZeroWidth;

public abstract class LookAround extends ZeroWidth {
	
	protected GeFLoPattern pattern;
	
	public LookAround(final GeFLoPattern pattern) {
		this.pattern = pattern;
	}
	
	public GeFLoPattern getPattern() {
		return pattern;
	}
	
	@Override
	public boolean owns(GeFLoPattern pattern) {
		return this == pattern || this.pattern.owns(pattern);
	}
	
	@Override
	public String toJavaPattern() {
		if (getPattern() instanceof Negation) {
			final GeFLoPattern innerPattern = ((Negation) getPattern()).getPattern();
			return "(?"+getNegativePrefix()
				+innerPattern.toJavaPattern()+")";
		}
		return "(?"+getPositivePrefix()
			+getPattern().toJavaPattern()+")";
	}
	
	@Override
	public String toLineMatchingJavaPattern() {
		throw new LineMatchingNotSupportedException();
	}
	
	public abstract String getNegativePrefix();
	public abstract String getPositivePrefix();
}
