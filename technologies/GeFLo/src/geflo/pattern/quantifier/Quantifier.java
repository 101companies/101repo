package geflo.pattern.quantifier;

import geflo.pattern.GeFLoPattern;
import geflo.pattern.LineMatchingWrapper;
import geflo.pattern.Sequence;
import geflo.pattern.token.AnyToken;

public abstract class Quantifier
		implements GeFLoPattern, Cloneable {
	
	protected GeFLoPattern pattern;
	
	public Quantifier(final GeFLoPattern pattern) {
		this.pattern = pattern;
	}
	
	public void setPattern(GeFLoPattern pattern) {
		this.pattern = pattern;
	}
	
	public GeFLoPattern getPattern() {
		return pattern;
	}
	
	@Override
	public boolean owns(GeFLoPattern pattern) {
		return this == pattern || this.pattern.owns(pattern); 
	}
	
	public abstract char getSymbol();
	
	/**
	 * This method should be overridden, but called as
	 * fall-back option. E.g. ((^[abc])+)?
	 * 
	 * @return
	 */
	public boolean canMatchMultipleTokens() {
		if (pattern instanceof Quantifier) {
			return ((Quantifier) pattern).canMatchMultipleTokens();
		}
		return false;
	}
	
	public String toString() {
		if (pattern instanceof Sequence) {
			return "("+pattern+")"+getSymbol();
		}
		return pattern.toString()+getSymbol();
	}
	
	public boolean containsAnyToken() {
		if (pattern instanceof AnyToken) {
			return true;
		} else if (pattern instanceof Quantifier) {
			return ((Quantifier) pattern).containsAnyToken();
		} else if (pattern instanceof LineMatchingWrapper) {
			GeFLoPattern innerPattern = ((LineMatchingWrapper) pattern).getPattern();
			if (innerPattern instanceof AnyToken) {
				return true;
			} else if (pattern instanceof Quantifier) {
				return ((Quantifier) pattern).containsAnyToken();
			}
		}
			
		/* Do not check sequences recursively. They
		 * are not from interest in this context, because
		 * they handle line skips for their self.
		 */
		return false;
	}
	
	@Override
	public String toJavaPattern() {
		if (pattern instanceof Sequence) {
			// Add clauses if the pattern is a sequence
			return "(?:"+pattern.toJavaPattern()+")"+getSymbol();
		}
		
		if (pattern instanceof Quantifier) {
			/* Add clauses if the pattern is a quantifier,
			 * otherwise there are side-effects through extended
			 * semantics of adjacent quantifiers:
			 *    ?+, *+, ++ => Possessive quantifiers
			 *    ??, *?, +? => Reluctant quantifiers
			 */
			return "(?:"+pattern.toJavaPattern()+")"+getSymbol();
		}
		
		/* This had become unnecessary by introducing:
		 *  @see pattern.token.StarAnyToken
		 *  @see pattern.token.PlusAnyToken  
		 */
		//if (canMatchMultipleTokens() && containsAnyToken()) {
			/* Bypass the anti-whitespace handling in
			 * @see pattern.token.AnyToken#toJavaPattern()
			 * because the meaning changed for the actual context.
			 */
		//	return "."+getSymbol();
		//}
		
		return pattern.toJavaPattern()+getSymbol();
	}
	
	@Override
	public abstract Quantifier clone();
	
}
