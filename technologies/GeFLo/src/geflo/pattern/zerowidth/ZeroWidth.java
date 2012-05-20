package geflo.pattern.zerowidth;

import geflo.pattern.GeFLoPattern;

public abstract class ZeroWidth implements GeFLoPattern {

	@Override
	public boolean owns(GeFLoPattern pattern) {
		return this == pattern;
	}

}