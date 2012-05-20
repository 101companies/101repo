package geflo.pattern.quantifier;

import geflo.pattern.GeFLoPattern;
import geflo.pattern.LineMatchingWrapper;

public class QuestionMark extends Quantifier {
	
	public QuestionMark(GeFLoPattern pattern) {
		super(pattern);
	}
	
	@Override
	public char getSymbol() {
		return '?';
	}
	
	@Override
	public String toLineMatchingJavaPattern() {
		return new QuestionMark(new LineMatchingWrapper(getPattern())).toJavaPattern();
	}
	
	@Override
	public QuestionMark clone() {
		return new QuestionMark(getPattern());
	}
	
}
