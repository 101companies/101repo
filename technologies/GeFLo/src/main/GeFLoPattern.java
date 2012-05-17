package main;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.script.Script;
import main.script.Token;


public class GeFLoPattern {
	
	public static final Logger logger;
	static {
		// Initialize logging
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new SimpleFormatter());
		handler.setLevel(Level.ALL);
		logger = Logger.getLogger(GeFLoPattern.class.getName());
		logger.addHandler(handler);
		
		/*
		 * Change the level if you want to...
		 *	- disable logging to Level.OFF
		 *	- enable  logging to Level.ALL
		 */
		logger.setLevel(Level.ALL);
	}
	
	public class MatchingLineBounds {
		public int start;
		public int end;
		
		public MatchingLineBounds() {}
		
		public MatchingLineBounds(final int start, final int end) {
			this.start	= start;
			this.end	= end;
		}
		
		@Override
		public String toString() {
			return start+":"+end;
		}
	}
	
	// Symbol, which is used to quote special chars
	private static final Character ESCAPE_CHAR		= '\\';
	
	// All special chars, which could be quoted
	private static final Character[] SPECIAL_CHARS	= new Character[] {
		ESCAPE_CHAR,			// Escape char
		'<', '>',				// Look-around delimiters
		'^', '$',				// Start and end
		'[', ']',				// Negation delimiters
		'?', '+', '*',			// Quantifiers
		' ', '\t', '\r', '\n'	// Whitespace
	};
	
	// Escape symbol in Java-Pattern compatible form
	private static final String		ESCAPE			= Pattern.quote(Character.toString(ESCAPE_CHAR));
	
	/**
	 * This pattern is used to match a symbol, which is not escaped,
	 * because there is no odd number of escape symbols in front of it.
	 * 
	 * NOTE:
	 * 	Look-around expressions in Java could not be dynamically quantified,
	 * 	therefore a sub-pattern has the quantifier {0,100}.
	 */
	private static final String		NOT_ESCAPED		= "(?<=(?<!"+ESCAPE+")(?:"+ESCAPE+ESCAPE+"){0,100})";
	
	private static final String		START			= "("+NOT_ESCAPED+"\\^)";
	private static final String		END				= "(\\s*"+NOT_ESCAPED+"\\$)";
	
	private static final String		NEGATION		= NOT_ESCAPED+"\\^\\[(.*?)"+NOT_ESCAPED+"\\]";
	
	private static final Character	PRE_DELIMITER	= '%';
	private static final Character	POST_DELIMITER	= '§';
	
	private static final String		LINE_PATTERN	= PRE_DELIMITER+"(\\\\d+)"+POST_DELIMITER;
	
	private static final String		MASK			= "\u000B"; //= zero-width whitespace
	
	
	private String	originalPattern;
	private String	pattern;
	private String	masked;
	
	private int		numberOfDelimiters;		
	private Pattern compiledPattern;
	
	/**
	 * Create, prepare and compile a new pattern,
	 * which could be matched against Scripts
	 * 
	 * @param gefloPattern
	 */
	private GeFLoPattern(final String originalPattern) {
		this.originalPattern = originalPattern;
		translate();
		
		logger.fine(pattern);
		
		compiledPattern = Pattern.compile(pattern);
		
		// Count the delimiters
		final char[] inputChars = pattern.toCharArray();
		for (char c : inputChars) {
			if (POST_DELIMITER.equals(c)) {
				numberOfDelimiters++;
			}
		}
		
	}
	
	/**
	 * Get the underlying java pattern
	 * 
	 * @return
	 */
	public String getJavaPattern() {
		return pattern;
	}
	
	/**
	 * Prints this pattern
	 * 
	 */
	@Override
	public String toString() {
		return originalPattern;
	}
	
	/**
	 * Replaces all matches with a given replacement.
	 * This method is internal used to translate a GeFLo
	 * pattern to Java-compatible pattern.
	 * 
	 * @param regex
	 * @param replacement
	 */
	private void replace(String regex, String replacement) {
		this.pattern = this.pattern.replaceAll(regex, replacement);
	}
	
	/**
	 * This method is used to mask a escaped strings or characters,
	 * so that they don't need changes in RegEx, where the
	 * not escaped string has a special meaning.
	 * 
	 * This could be extended to mask multiple chars at one time,
	 * by generating unicode chars in an character area, which
	 * definitively will not be used in code.
	 * 
	 * @param toMask
	 */
	private void mask(String toMask) {
		this.masked = toMask;
		this.pattern = this.pattern.replaceAll(NOT_ESCAPED+"\\\\"+toMask, MASK);
	}
	
	/**
	 * Remove the mask from a previous masked sign, so it
	 * will replace by the not escaped form
	 * 
	 */
	private void unmask() {
		this.pattern = this.pattern.replace(MASK, masked);
	}
	
	/**
	 * Quotes a string for being used in patterns
	 * 
	 * @param toQuote
	 * @return
	 */
	public static String quote(String toQuote) {
		String quoted = toQuote;
		for (Character specialChar : SPECIAL_CHARS) {
			quoted = quoted.replace(
					Character.toString(specialChar),
					ESCAPE_CHAR+""+specialChar
				);
		}
		return quoted;
	}
	
	/**
	 * Translates the GeFLo pattern stored in
	 * <code>this.originalPattern</code> into a
	 * Java-compatible pattern, which will be stored
	 * in <code>this.pattern</code>.
	 * 
	 */
	private void translate() {
		this.pattern = this.originalPattern;
		
		/* LOOK-BEHIND *******************************************************/
		
		// Mask escaped look-behind delimiter
		mask("<");
		
		// Replace look-behind patterns
		replace("^"+START+"?"+NEGATION+"(\\s*)<",	"$1(?<!$2)$3");
		replace("^"+START+"?([^<]*)(\\s*)<",		"$1(?<=$2)$3");
		
		// Unmask escaped look-behind delimiters
		unmask();
		
		
		
		/* LOOK-AHEAD ********************************************************/
		
		// Mask escaped look-ahead delimiter
		mask(">");
		
		// Replace look-ahead patterns
		replace(">(\\s*)"+NEGATION+END+"?$",		"$1(?!$2)$3");
		replace(">(\\s*)(.*?)"+END+"?$",			"$1$2$3");
		// "$1(?=$2)$3"
		
		// Unmask escaped look-ahead delimiters
		unmask();
		
		
		
		/* ANY TOKEN *********************************************************/
		
		// Enforce single dots to any token matcher
		replace("(\\s)\\.(\\s)",					"$1[^"+PRE_DELIMITER+"]$3");
		
		
		
		/* NEGATION **********************************************************/
		
		// Wrap negations with clauses if they are quantified
		replace(NEGATION+"([\\+\\?\\*])",			"(?:^[$1])$2");
		
		// Replace negations
		replace(NEGATION,							"((?!$1)[^"+PRE_DELIMITER+"]+)"+LINE_PATTERN);
		// (?<!$1)(?:.*)
		// (?:(?<!$1)[^"+PRE_DELIMITER+"]*)
		
		
		
		/* LINE NUMBER MATCHING **********************************************/
		
		// Replace whitespaces by line-number matching format
		replace(NOT_ESCAPED+"\\s+",					LINE_PATTERN);
		
		// Add a prefix with line-number matching format
		replace("^"+START+"([^"+PRE_DELIMITER+"])",	"^"+LINE_PATTERN+"$1");
		replace("^(?!"+START+")",					"^.*"+LINE_PATTERN+"$1");
		
		// Add a suffix to match the complete input, if necessary
		replace("([^\\$])$",						"$1[^"+PRE_DELIMITER+"]*"+LINE_PATTERN+".*\\$");
		// "$1.*\\$"
	}
	
	/**
	 * Prepares a script to be matched, by joining it token by token
	 * delimited by line numbers, which have a prefix and a suffix.
	 * 
	 * @param script
	 * @return
	 */
	public static String prepareScript(Script script) {
		StringBuilder sb = new StringBuilder();
		for (Token token : script.getTokens()) {
			sb.append(PRE_DELIMITER);
			sb.append(token.getLineNumber());
			sb.append(POST_DELIMITER);
			sb.append(token.getName());
		}
		return sb.toString();
	}
	
	/**
	 * Alias which prepares the script to an input string.
	 * 
	 * @param script
	 */
	public MatchingLineBounds find(Script script) {
		final String input = prepareScript(script);
		logger.finer(input);
		
		return find(input);
	}
	
	/**
	 * Uses this pattern to find matchings in a input
	 * string and returns the matched line number bounds,
	 * or null if there was no matching.
	 * 
	 * @param input
	 * @return
	 */
	public MatchingLineBounds find(String input) {
		final Matcher matcher = compiledPattern.matcher(input);
		if (!matcher.find()) {
			return null;
		}
		matcher.reset();
		
		final String matchingLines = matcher.replaceAll("$1:$"+numberOfDelimiters);
		String[] bounds = matchingLines.split(":");
		
		final MatchingLineBounds result = new MatchingLineBounds();
		try {
			result.start	= Integer.parseInt(bounds[0]);
			result.end		= Integer.parseInt(bounds[1]);
		} catch (NumberFormatException e) {
			return null;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
		
		return result;
	}
	
	/**
	 * Uses a GeFLoPattern to find matchings in a script
	 * and returns the matched line number bounds.
	 * 
	 * @param pattern
	 * @param script
	 * @return
	 */
	public static MatchingLineBounds find(String pattern, String scriptInput) {
		final GeFLoPattern m = new GeFLoPattern(pattern);
		return m.find(scriptInput);
	}
	
	/**
	 * Alias which prepares the script to an input string
	 * 
	 * @param pattern
	 * @param script
	 * @return
	 */
	public static MatchingLineBounds find(String pattern, Script script) {
		final GeFLoPattern m = new GeFLoPattern(pattern);
		return m.find(script);
	}
}
