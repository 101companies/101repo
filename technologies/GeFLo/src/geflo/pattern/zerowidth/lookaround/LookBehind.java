package geflo.pattern.zerowidth.lookaround;

import geflo.pattern.GeFLoPattern;

public class LookBehind extends LookAround {
	
	public LookBehind(final GeFLoPattern pattern) {
		super(pattern);
	}
	
	public String toString() {
		return getPattern()+" <";
	}
	
	@Override
	public String getNegativePrefix() {
		return "<!";
	}
	
	@Override
	public String getPositivePrefix() {
		return "<=";
	}
	
}
