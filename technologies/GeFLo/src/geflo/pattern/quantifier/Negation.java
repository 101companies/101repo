package geflo.pattern.quantifier;

import geflo.pattern.GeFLoMatcher;
import geflo.pattern.GeFLoPattern;
import geflo.pattern.Sequence;

public class Negation extends Quantifier {
	
	public Negation(GeFLoPattern pattern) {
		super(pattern);
	}
	
	@Override
	public char getSymbol() {
		return '^';
	}
	
	@Override
	public String toString() {
		return getSymbol()+"["+getPattern()+"]";
	}
	
	@Override
	public boolean canMatchMultipleTokens() {
		return false;
	}
	
	/**
	 * Get Java-Pattern
	 * @see pattern.GeFLoPattern#toJavaPattern
	 * 
	 * @param isLineMatching
	 * @return
	 */
	private String toJavaPattern(boolean isLineMatching) {
		final StringBuilder s = new StringBuilder();
		s.append("(?:");
		
		if (isLineMatching) {
			s.append(GeFLoMatcher.LINE_PATTERN);
		} else {
			s.append(GeFLoMatcher.OPT_SILENT_LINE_PATTERN);
		}
		
		s.append("(?!");
		s.append(getPattern().toJavaPattern());
		s.append(")[^");
		s.append(GeFLoMatcher.PRE_DELIMITER);
		s.append("]+");
		
		s.append(')');
		return s.toString();
	}
	
	@Override
	public String toJavaPattern() {
		return toJavaPattern(false);
	}
	
	@Override
	public String toLineMatchingJavaPattern() {
		if (getPattern() instanceof Sequence) {
			final Sequence originalSeq	= ((Sequence) getPattern()); 
			if (originalSeq.isEmpty()) {
				return "";
			}
			if (originalSeq.isUnary()) {
				return new Negation(originalSeq.getFirst()).toLineMatchingJavaPattern();
			}
			
			final Sequence outerSequence = new Sequence();
			final Sequence innerSequence = originalSeq.clone();
			
			final int lastIndex = innerSequence.getPatterns().size()-1;
			final GeFLoPattern lastElem = innerSequence.getPatterns().remove(lastIndex);
			
			outerSequence.add(new Negation(innerSequence));
			outerSequence.add(new Negation(lastElem));
			return "(?:"+outerSequence.toLineMatchingJavaPattern()+")";
		}
		
		return toJavaPattern(true);
	}
	
	@Override
	public Negation clone() {
		return new Negation(getPattern());
	}
	
}
