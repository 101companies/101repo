package geflo.pattern.token;

import geflo.pattern.Sequence;
import geflo.pattern.quantifier.QuestionMark;

public class StarAnyToken extends Token {
	
	@Override
	public String toString() {
		return ".*";
	}
	
	@Override
	public String toJavaPattern() {
		return "(?:.*)";
	}
	
	@Override
	public String toLineMatchingJavaPattern() {
		return new Sequence(
				new StarAnyToken(),
				new QuestionMark(new AnyToken())
			).toLineMatchingJavaPattern();
	}
	
}
