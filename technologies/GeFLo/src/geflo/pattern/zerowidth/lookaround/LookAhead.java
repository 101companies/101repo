package geflo.pattern.zerowidth.lookaround;

import geflo.pattern.GeFLoPattern;

public class LookAhead extends LookAround {
	
	public LookAhead(final GeFLoPattern pattern) {
		super(pattern);
	}
	
	public String toString() {
		return "> "+getPattern();
	}
	
	@Override
	public String getNegativePrefix() {
		return "!";
	}
	
	@Override
	public String getPositivePrefix() {
		return "=";
	}
	
}
