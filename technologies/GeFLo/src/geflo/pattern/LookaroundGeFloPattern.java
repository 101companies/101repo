package geflo.pattern;

import geflo.pattern.zerowidth.End;
import geflo.pattern.zerowidth.Start;
import geflo.pattern.zerowidth.lookaround.LookAhead;
import geflo.pattern.zerowidth.lookaround.LookBehind;

public class LookaroundGeFloPattern implements GeFLoPattern {
	
	private Start			start;
	private LookAhead		lookAhead;
	private GeFLoPattern	pattern;
	private LookBehind		lookBehind;
	private End				end;
	
	public static LookaroundGeFloPattern create(GeFLoPattern p) {
		return new LookaroundGeFloPattern(p);
	}
	
	public static LookaroundGeFloPattern create(LookAhead la, GeFLoPattern p) {
		return new LookaroundGeFloPattern(p).setLookAhead(la);
	}
	
	public static LookaroundGeFloPattern create(GeFLoPattern p, LookBehind lb) {
		return new LookaroundGeFloPattern(p).setLookBehind(lb);
	}
	
	public static LookaroundGeFloPattern create(LookAhead la, GeFLoPattern p, LookBehind lb) {
		return new LookaroundGeFloPattern(p)
			.setLookAhead(la)
			.setLookBehind(lb);
	}
	
	public LookaroundGeFloPattern(GeFLoPattern pattern) {
		this.pattern = pattern;
	}
	
	public LookaroundGeFloPattern() {
	}
	
	public Start getStart() {
		return start;
	}
	
	public GeFLoPattern setStart(Start start) {
		this.start = start;
		return this;
	}
	
	public LookBehind getLookBehind() {
		return lookBehind;
	}
	
	public LookaroundGeFloPattern setLookBehind(LookBehind lookBehind) {
		this.lookBehind = lookBehind;
		return this;
	}
	
	public GeFLoPattern getPattern() {
		return pattern;
	}
	
	public LookaroundGeFloPattern setPattern(GeFLoPattern pattern) {
		this.pattern = pattern;
		return this;
	}
	
	public LookAhead getLookAhead() {
		return lookAhead;
	}
	
	public LookaroundGeFloPattern setLookAhead(LookAhead lookAhead) {
		this.lookAhead = lookAhead;
		return this;
	}
	
	public End getEnd() {
		return end;
	}
	
	public GeFLoPattern setEnd(End end) {
		this.end = end;
		return this;
	}
	
	@Override
	public boolean owns(GeFLoPattern pattern) {
		if (lookAhead != null && lookAhead.owns(pattern)) {
			return true;
		}
		
		if (!this.pattern.owns(pattern)) {
			return true;
		}
		
		if (lookBehind != null && lookBehind.owns(pattern)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		if (start != null) {
			s.append(start);
		}
		if (lookBehind != null) {
			s.append(lookAhead);
		}
		s.append(pattern);
		if (lookAhead != null) {
			s.append(lookAhead);
		}
		if (end != null) {
			s.append(end);
		}
		
		return s.toString();
	}
	
	@Override
	public String toJavaPattern() {
		StringBuilder s = new StringBuilder();
		
		if (start != null) {
			s.append(start.toJavaPattern());
		} else {
			s.append(Start.JAVA_PATTERN);
			s.append(".*?");
		}
		
		if (lookBehind != null) {
			s.append(GeFLoMatcher.OPT_SILENT_LINE_PATTERN);
			s.append(lookBehind.getPattern().toJavaPattern());
		}
		
		// Append first matcher
		s.append(GeFLoMatcher.LINE_PATTERN);
		
		if (lookAhead != null) {
			s.append(pattern.toLineMatchingJavaPattern());
			s.append(GeFLoMatcher.SILENT_LINE_PATTERN);
			s.append(lookAhead.getPattern().toJavaPattern());
		} else {
			s.append(pattern.toLineMatchingJavaPattern());
		}
		
		if (end != null) {
			s.append(end.toJavaPattern());
		} else {
			s.append(".*");
			s.append(End.JAVA_PATTERN);
		}
		
		return s.toString();
	}
	
	@Override
	public String toLineMatchingJavaPattern() {
		return toJavaPattern();
	}
	
}
