package geflo.pattern.token;

import geflo.pattern.Sequence;

public class PlusAnyToken extends Token {
	
	@Override
	public String toString() {
		return ".+";
	}
	
	@Override
	public String toJavaPattern() {
		return new Sequence(
				new AnyToken(),
				new StarAnyToken()
			).toJavaPattern();
	}
	
	@Override
	public String toLineMatchingJavaPattern() {
		final StringBuilder s = new StringBuilder();
		s.append("(?:");
		s.append(new AnyToken().toLineMatchingJavaPattern());
		s.append(new StarAnyToken().toJavaPattern());
		s.append(")");
		return s.toString();
	}
	
}
