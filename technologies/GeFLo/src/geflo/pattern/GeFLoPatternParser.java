package geflo.pattern;

import geflo.pattern.quantifier.Negation;
import geflo.pattern.quantifier.Plus;
import geflo.pattern.quantifier.Quantifier;
import geflo.pattern.quantifier.QuestionMark;
import geflo.pattern.quantifier.Star;
import geflo.pattern.token.AnyToken;
import geflo.pattern.token.PlusAnyToken;
import geflo.pattern.token.SpecificToken;
import geflo.pattern.token.StarAnyToken;
import geflo.pattern.zerowidth.End;
import geflo.pattern.zerowidth.Start;
import geflo.pattern.zerowidth.lookaround.LookAhead;
import geflo.pattern.zerowidth.lookaround.LookBehind;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GeFLoPatternParser {
	
	
	public class ParserException extends RuntimeException {
		
		private static final long serialVersionUID = -2502230291956638825L;
		
		public ParserException(String msg) {
			super(msg);
		}
		
	}
	
	
	public class UnexpectedTokenException extends ParserException {
		
		private static final long serialVersionUID = -612634152044402352L;
		
		public UnexpectedTokenException(final String found, final String expected) {
			super(
					"Found unexpected token while parsing: '"+found
					+"'! Expected: '"+expected+"'"
				);
		}
		
		public UnexpectedTokenException(final char token, final String expected) {
			this(Character.toString(token), expected);
		}
		
	}
	
	
	public final static char ESCAPE				= '\\';
	public final static char NEGATION_PRE		= '^';
	public final static char NEGATION_START		= '[';
	public final static char NEGATION_END		= ']';
	public final static char OPEN_SUB			= '(';
	public final static char CLOSE_SUB			= ')';
	public final static char PLUS				= '+';
	public final static char STAR				= '*';
	public final static char QUESTION_MARK		= '?';
	public final static char DOT				= '.';
	public final static char LOOKBEHIND			= '<';
	public final static char LOOKAHEAD			= '>';
	public final static char START				= '^';
	public final static char END				= '$';
	
	public static final List<Character> SPECIAL_CHARS = Arrays.asList(
		ESCAPE,							// Escape char
		LOOKBEHIND, LOOKAHEAD,			// Look-around delimiters
		START, END,						// Start and end
		NEGATION_START, NEGATION_END,	// Negation delimiters
		QUESTION_MARK, PLUS, STAR,		// Quantifiers
		' ', '\t', '\r', '\n'			// Whitespace
	);
	
	
	
	private char[]					chars			= null;
	private int						position		= 0;
	private LookaroundGeFloPattern	pattern			= null;
	private Stack<GeFLoPattern>		subPatterns		= new Stack<GeFLoPattern>();
	private String					tokenString		= "";
	
	
	/**
	 * Instantiates a parser with the given pattern string
	 * and parses the pattern to an abstract syntax tree.
	 * 
	 * @param pattern
	 * @return
	 */
	public static LookaroundGeFloPattern parse(String pattern) {
		return new GeFLoPatternParser(pattern).parse();
	}
	
	/**
	 * Create an instance of this parser class
	 * for a specified token
	 * 
	 * @param pattern
	 */
	public GeFLoPatternParser(String pattern) {
		chars = pattern.toCharArray();
	}
	
	/**
	 * Parses the pattern, which was given in the constructor
	 * 
	 * @throws IllegalStateException	if called more than once
	 * @return
	 */
	public LookaroundGeFloPattern parse() {
		if (position > 0) {
			throw new IllegalStateException("Parse could be only called once!");
		}
		
		// Parse the complete string and push everything on the stack
		subPatterns.push(parseSubPatternUntil(null));
		
		// Instantiate structured super pattern class
		pattern = new LookaroundGeFloPattern();
		 
		for (int i=0; i<subPatterns.size(); i++) {
			final GeFLoPattern subPattern = subPatterns.get(i);
			
			if (subPattern instanceof Start) {
				if (i > 0) {
					throw new ParserException("Found token START, but not" +
							" at first position of the pattern!");
				}
				pattern.setStart((Start) subPattern);
				continue;
			}
			
			if (subPattern instanceof LookBehind) {
				pattern.setLookBehind((LookBehind) subPattern);
				continue;
			}
			
			if (subPattern instanceof LookAhead) {
				pattern.setLookAhead((LookAhead) subPattern);
				continue;
			}
			
			if (subPattern instanceof End) {
				if (i < subPatterns.size()-1) {
					throw new ParserException("Found token END, but not" +
							" at the end of the pattern!");
				}
				pattern.setEnd((End) subPattern);
				continue;
			}
			
			if (pattern.getPattern() != null) {
				if (pattern.getPattern() instanceof Sequence) {
					((Sequence) pattern.getPattern()).add(subPattern);
				} else {
					pattern.setPattern(new Sequence(
							pattern.getPattern(),
							subPattern
						));
				}
			} else {
				pattern.setPattern(subPattern);
			}
		}
		
		return pattern;
	}
	
	
	/**
	 * Go to the next character of the pattern. 
	 * 
	 * @return
	 */
	private Character nextChar() {
		if (position >= chars.length) {
			return null;
		}
		return chars[position++];
	}
	
	
	/**
	 * Checks if a next char exists and if
	 * it equals to the given char.
	 * NOTE: There is no increment because this
	 * method is always called after nextChar,
	 * which do a post increment!
	 * 
	 * @param compare
	 * @return
	 */
	private boolean isNext(char compare) {
		if (position < chars.length) {
			return chars[position] == compare;
		}
		return false;
	}
	
	
	/**
	 * Parse a sub pattern until a given end mark,
	 * or if the argument is null then until the
	 * string end.
	 * 
	 * @param end
	 * @return
	 */
	private GeFLoPattern parseSubPatternUntil(Character end) {
		Character actual;
		while ((actual = nextChar()) != null) {
			if (actual == end) break;
			parseChar(actual);
		}
		
		if (end != null) {
			expect(end, actual);
		}
		
		parseChar(null);
		return subPatterns.pop();
	}
	
	
	/**
	 * Parse a given character.
	 * If the first argument is null a non-empty tokenString
	 * will be handled as finished.
	 * 
	 * @param c
	 */
	private void parseChar(final Character c) {
		if (!tokenString.isEmpty()
				&& (c == null
				|| (c != ESCAPE
				&& !Character.isWhitespace(c)
				&& SPECIAL_CHARS.contains(c)))) {
			/* The parsing "context" will change in this step,
			 * because the actual char is a metasymbol and not
			 * the escape char or a whitespace. (Whenever we
			 * hit the escape char, we are inside of a token!
			 * If the actual char is a whitespace this would
			 * be handled below.) So the token string must be
			 * saved on the stack as sub pattern.
			 */
			final SpecificToken token = new SpecificToken(tokenString);
			tokenString = "";
			if (subPatterns.isEmpty() || subPatterns.peek() instanceof Sequence) {
				getOrCreateSequence().add(token);
			} else {
				subPatterns.add(token);
			}
		}
		
		if (c == null) return;
		
		switch (c) {
			
			// Context
			
			//case NEGATION_PRE:
			case START:
				if (position == 1 && !isNext(NEGATION_START)) {
					subPatterns.push(new Start());
				} else {
					expect(NEGATION_START);
					initNewSequenceContext();
					subPatterns.push(new Negation(parseSubPatternUntil(NEGATION_END)));
				}
				break;
			
			case END:
				subPatterns.push(new End());
				break;
			
			case LOOKBEHIND:
				if (subPatterns.isEmpty()) {
					throw new UnexpectedTokenException(LOOKBEHIND, "pattern");
				}
				subPatterns.push(new LookBehind(subPatterns.pop()));
				break;
			
			case LOOKAHEAD:
				if (subPatterns.isEmpty()) {
					throw new UnexpectedTokenException(LOOKBEHIND, "pattern");
				}
				
				initNewSequenceContext();
				final GeFLoPattern pattern = parseSubPatternUntil(null);
				if (pattern instanceof End) {
					subPatterns.push(new LookAhead(subPatterns.pop()));
					subPatterns.push(pattern);
				} else {
					subPatterns.push(new LookAhead(pattern));
				}
				break;
			
			case OPEN_SUB:
				subPatterns.push(parseSubPatternUntil(CLOSE_SUB));
				break;
			
			
			// Quantifiers
			
			case PLUS:
				subPatterns.push(new Plus(subPatterns.pop()));
				break;
			
			case STAR:
				subPatterns.push(new Star(subPatterns.pop()));
				break;
			
			case QUESTION_MARK:
				subPatterns.push(new QuestionMark(subPatterns.pop()));
				break;
			
			
			// Whitespaces
			
			case ' ':
			case '\t':
			case '\n':
			case '\r':
				if (!tokenString.isEmpty()) {
					getOrCreateSequence().add(new SpecificToken(tokenString));
					tokenString = "";
				} else {
					if ((subPatterns.peek() instanceof Quantifier)
						||	(subPatterns.peek() instanceof SpecificToken)) {
						GeFLoPattern last = subPatterns.pop();
						getOrCreateSequence().add(last);
					}
				}
				break;
			
			
			// Any token
			
			case DOT:
				if (isNext(STAR)) {
					nextChar();
					subPatterns.push(new StarAnyToken());
				} else if (isNext(PLUS)) {
					nextChar();
					subPatterns.push(new PlusAnyToken());
				} else {
					subPatterns.push(new AnyToken());
				}
				break;
			
			
			// Char sequences and specific tokens
			
			case ESCAPE:
				escaped();
				break;
			
			default:
				tokenString += c;
				break;
			
		}
	}
	

	/**
	 * Initializes a new sequential context for
	 * sub-patterns, which are started by a leading
	 * metasymbol.
	 * 
	 */
	private void initNewSequenceContext() {
		if (subPatterns.isEmpty()
				|| subPatterns.peek() instanceof Sequence) {
			subPatterns.push(new Sequence());
		}
	}
	
	
	/**
	 * Get a sequence from top of the subPatterns stack
	 * or if there is no sequence then push a new sequence
	 * to the stack.
	 * 
	 * @return
	 */
	private Sequence getOrCreateSequence() {
		if (!subPatterns.isEmpty()
				&& subPatterns.peek() instanceof Sequence) {
			// If there exists already a sequence return it
			return ((Sequence) subPatterns.peek());
		}
		
		// ... otherwise create a new
		Sequence seq = new Sequence();
		subPatterns.add(seq);
		return seq;
	}
	
	
	/**
	 * Throws an exception if the next char
	 * does not equal to the given expected
	 * character.
	 * 
	 * @param expected
	 */
	private void expect(final char expected) {
		expect(expected, nextChar());
	}
	
	
	/**
	 * Throws an exception if the given character
	 * does not equal to the given expected
	 * character.
	 * If the first argument is null then this method
	 * expects that the given character is null, which
	 * will be handled as expecting the end of the
	 * parsed pattern.
	 * 
	 * @param expected
	 * @param compareTo
	 */
	private void expect(final char expected, final Character compareTo) {
		if (compareTo == null) {
			throw new UnexpectedTokenException("end of pattern", Character.toString(expected));
		}
		if (compareTo != expected) {
			throw new UnexpectedTokenException(compareTo, Character.toString(expected));
		}
	}
	
	
	/**
	 * Awaits the next character to be an metasymbol,
	 * which will be handled as escaped. This means
	 * that the character will appended to the
	 * tokenString.
	 * 
	 */
	private void escaped() {
		final Character c = nextChar();
		if (c == null) {
			throw new UnexpectedTokenException("end of pattern", "metasymbol");
		}
		if (!SPECIAL_CHARS.contains(c)) {
			throw new UnexpectedTokenException(c, "metasymbol");
		}
		tokenString += c;
	}
	
}
