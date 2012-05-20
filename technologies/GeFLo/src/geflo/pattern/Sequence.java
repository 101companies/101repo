package geflo.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sequence implements GeFLoPattern, Cloneable {
	
	private List<GeFLoPattern> patterns = new ArrayList<GeFLoPattern>();;
	
	public Sequence() {
		patterns = new ArrayList<GeFLoPattern>();
	}
	
	public Sequence(GeFLoPattern... patterns) {
		this.patterns.addAll(Arrays.asList(patterns));
	}

	public List<GeFLoPattern> getPatterns() {
		return patterns;
	}
	
	public void add(GeFLoPattern p) {
		if (p instanceof Sequence) {
			patterns.addAll(((Sequence) p).getPatterns());
		} else {
			patterns.add(p);
		}
	}
	
	public boolean isEmpty() {
		return patterns.isEmpty();
	}
	
	public boolean isUnary() {
		return patterns.isEmpty() || patterns.size() == 1;
	}
	
	public GeFLoPattern getFirst() {
		if (patterns.isEmpty()) return null;
		return patterns.get(0);
	}
	
	public GeFLoPattern getLast() {
		if (patterns.isEmpty()) return null;
		return patterns.get(patterns.size()-1);
	}
	
	@Override
	public boolean owns(GeFLoPattern p) {
		if (this == p) {
			return true;
		}
		for (GeFLoPattern pattern : patterns) {
			if (pattern.owns(p)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		if (patterns.isEmpty()) return "";
		StringBuilder s = new StringBuilder();
		for (GeFLoPattern pattern : patterns) {
			s.append(pattern);
			s.append(' ');
		}
		return s.deleteCharAt(s.length()-1).toString();
	}
	
	public String toJavaPattern(boolean isLineMatching) {
		if (patterns.size() == 0)	return "";
		if (patterns.size() == 1)	return patterns.get(0).toJavaPattern();
		flatten();
		
		final StringBuilder s = new StringBuilder();
		int i=0;
		for (GeFLoPattern pattern : patterns) {
			i++;
			if (!isLineMatching || i<patterns.size()) { 
				s.append(GeFLoMatcher.OPT_SILENT_LINE_PATTERN);
				s.append(pattern.toJavaPattern());
			} else {
				s.append(pattern.toLineMatchingJavaPattern());
			}
		}
		return s.toString();
	}
	
	/**
	 * Flatten a sequence, so that there are no direct
	 * subsequences. This method works in place and
	 * recursively.
	 * 
	 * @return {@link pattern.Sequence#getPatterns()}
	 */
	public ArrayList<GeFLoPattern> flatten() {
		final ArrayList<GeFLoPattern> flat = new ArrayList<GeFLoPattern>();
		for (GeFLoPattern pattern : patterns) {
			if (pattern instanceof Sequence) {
				flat.addAll(((Sequence) pattern).flatten());
			} else {
				flat.add(pattern);
			}
		}
		patterns = flat;
		return flat;
	}

	@Override
	public String toJavaPattern() {
		return toJavaPattern(false);
	}
	
	@Override
	public String toLineMatchingJavaPattern() {
		return toJavaPattern(true);
	}
	
	/**
	 * Flat clone
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Sequence clone() {
		Sequence clone = new Sequence();
		clone.getPatterns().addAll(getPatterns());
		return clone;
	}
	
}