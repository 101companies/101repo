package geflo.pattern.token;

import geflo.pattern.GeFLoPattern;

public abstract class Token implements GeFLoPattern {
	
	@Override
	public boolean owns(GeFLoPattern pattern) {
		return this == pattern;
	}

}
