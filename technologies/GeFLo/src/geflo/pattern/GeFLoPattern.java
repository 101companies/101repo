package geflo.pattern;


public interface GeFLoPattern {
	
	/**
	 * Checks if this pattern or any sub pattern
	 * equals to the first argument.
	 * 
	 * @param pattern
	 * @return
	 */
	public boolean owns(GeFLoPattern pattern);
	
	/**
	 * Get the pattern as a regular expression compatible
	 * to the Java-Pattern implementation.
	 * 
	 * @return
	 */
	public String toJavaPattern();
	
	/**
	 * This method does nearly the same like:
	 * 	@see{GeFLoPattern.toJavaPattern()}
	 * But as difference the last sub pattern will be
	 * prepared as line number matcher. This causes
	 * that the Java-Pattern will be prefixed by a
	 * line number matching pattern.
	 * 
	 * @throws LineMatchingNotSupportedException
	 * @return
	 */
	public String toLineMatchingJavaPattern();
	
}
