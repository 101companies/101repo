package main;

import main.script.Script;
import main.script.Token;
import pattern.GeFloPattern;
import pattern.Sequence;
import pattern.parser.GeFLoInputParser;
import pattern.quantifier.Negation;
import pattern.quantifier.Star;
import pattern.token.SpecificToken;

public abstract class RubyExampleFactory {
	
	public static GeFloPattern createPatternTotal() {
		//return GeFLoInputParser.parse("def total (def!)*");
		Sequence seq = new Sequence();
		seq.getPatterns().add(new SpecificToken("def"));
		seq.getPatterns().add(new SpecificToken("total"));
		seq.getPatterns().add(new Star(new Negation(new SpecificToken("def"))));
		return seq;
	}
	
	public static GeFloPattern createPatternCut() {
		return GeFLoInputParser.parse("def cut .* > end $");
	}
	
	public static Script createScript() {
		final Script s = new Script();
		s.add(new Token(1, 0, "class"));
		s.add(new Token(1, 1, "Company"));
		s.add(new Token(3, 0, "attr_accessor"));
		s.add(new Token(3, 1, ":name"));
		s.add(new Token(3, 2, ","));
		s.add(new Token(3, 3, ":topDepts"));
		s.add(new Token(5, 0, "def"));
		s.add(new Token(5, 1, "total"));
		s.add(new Token(6, 0, "ttl"));
		s.add(new Token(6, 1, "="));
		s.add(new Token(6, 2, "0.0"));
		s.add(new Token(7, 0, "topDepts"));
		s.add(new Token(7, 1, "."));
		s.add(new Token(7, 2, "each"));
		s.add(new Token(7, 3, "do"));
		s.add(new Token(7, 4, "|"));
		s.add(new Token(7, 5, "topDept"));
		s.add(new Token(7, 6, "|"));
		s.add(new Token(8, 0, "ttl"));
		s.add(new Token(8, 1, "+="));
		s.add(new Token(8, 2, "topDept"));
		s.add(new Token(8, 3, "."));
		s.add(new Token(8, 4, "total"));
		s.add(new Token(9, 0, "end"));
		s.add(new Token(10, 0, "ttl"));
		s.add(new Token(11, 0, "end"));
		s.add(new Token(13, 0, "def"));
		s.add(new Token(13, 1, "cut"));
		s.add(new Token(14, 0, "topDepts"));
		s.add(new Token(14, 1, "."));
		s.add(new Token(14, 2, "each"));
		s.add(new Token(14, 3, "do"));
		s.add(new Token(14, 4, "|"));
		s.add(new Token(14, 5, "topDept"));
		s.add(new Token(14, 6, "|"));
		s.add(new Token(15, 0, "topDept"));
		s.add(new Token(15, 1, "."));
		s.add(new Token(15, 2, "cut"));
		s.add(new Token(16, 0, "end"));
		s.add(new Token(17, 0, "end"));
		s.add(new Token(18, 0, "end"));
		return s;
	}

}
