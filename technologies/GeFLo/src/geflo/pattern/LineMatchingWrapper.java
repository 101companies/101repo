package geflo.pattern;


/**
 * This wrapper allows an easy way to "hack" recursive
 * calls of implementations of:
 * 	@see pattern.GeFLoPattern#toJavaPattern()
 * 
 * This could be used for nested patterns, so that
 * they return a line number matching pattern.
 * 
 */
public class LineMatchingWrapper implements GeFLoPattern {
	
	private final GeFLoPattern pattern;
	
	public LineMatchingWrapper(final GeFLoPattern pattern) {
		this.pattern = pattern;
	}
	
	public GeFLoPattern getPattern() {
		return pattern;
	}
	
	public boolean owns(GeFLoPattern pattern) {
		return this.pattern.owns(pattern);
	}
	
	public String toJavaPattern() {
		// That's all the secret!
		return toLineMatchingJavaPattern();
	}
	
	public String toLineMatchingJavaPattern() {
		return pattern.toLineMatchingJavaPattern();
	}
	
}
