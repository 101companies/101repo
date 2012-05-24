package geflo.pattern;

import geflo.script.Script;
import geflo.script.Token;

import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeFLoMatcher {
	
	public static class MatchingLineBounds {
		public int start;
		public int end;
		
		protected MatchingLineBounds() {}
		
		public MatchingLineBounds(final int start, final int end) {
			this.start	= start;
			this.end	= end;
		}
		
		@Override
		public String toString() {
			return start+":"+end;
		}
		
		public String toJson() {
			return "{\"from\":"+start+",\"to\":"+end+"}";
		}
	}
	
	public static final Character	PRE_DELIMITER			= '%';
	public static final Character	POST_DELIMITER			= '§';
	public static final Character	PRE_DELIMITER_QUOTE		= '\uFEFF';	// ZERO WIDTH NO-BREAK SPACE
	public static final Character	POST_DELIMITER_QUOTE	= '\u200B';	// ZERO WIDTH SPACE
	
	public static final String		LINE_PATTERN			= PRE_DELIMITER+"(\\d+)"+POST_DELIMITER;
	public static final String		OPT_LINE_PATTERN		= "(?:"+LINE_PATTERN+")?";
	public static final String		SILENT_LINE_PATTERN		= "(?:"+PRE_DELIMITER+"\\d+"+POST_DELIMITER+")";
	public static final String		OPT_SILENT_LINE_PATTERN	= SILENT_LINE_PATTERN+"?";
	
	/**
	 * Quotes a string for being used in patterns
	 * 
	 * @param toQuote
	 * @return
	 */
	public static String quote(String toQuote) {
		String quoted = toQuote;
		for (Character specialChar : GeFLoPatternParser.SPECIAL_CHARS) {
			quoted = quoted.replace(
					Character.toString(specialChar),
					GeFLoPatternParser.ESCAPE+""+specialChar
				);
		}
		return quoted;
	}
	
	/**
	 * Quotes the pre- and post-delimiter in a token
	 * and also the special chars of replace strings
	 * for Java-Patterns.
	 * 
	 * @param unquoted token from Script or SpecificToken
	 * @return quoted token
	 */
	public static String quoteToken(String token) {
		token.replace(PRE_DELIMITER,	PRE_DELIMITER_QUOTE);
		token.replace(POST_DELIMITER,	POST_DELIMITER_QUOTE);
		token.replace("\\",				"\\\\");
		token.replace("$",				"\\$");
		return token;
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
			sb.append(quoteToken(token.getName()));
		}
		return sb.toString();
	}
	
	
	/**
	 * Uses the given pattern to find matchings in a input
	 * string and returns the matched line number bounds,
	 * or null if there was no matching.
	 * 
	 * @param pattern
	 * @param input
	 * @return
	 */
	public static MatchingLineBounds find(GeFLoPattern pattern, String input) {
		GeFLoRegistry.getLogger().log(Level.FINEST, "Prepared script: {0}", input);
		
		final String javaPattern = pattern.toJavaPattern();
		
		GeFLoRegistry.getLogger().log(Level.FINE, "Java pattern: {0}", javaPattern);
		
		final Pattern compiledPattern = Pattern.compile(javaPattern);
		final Matcher matcher = compiledPattern.matcher(input);
		if (!matcher.find()) {
			return null;
		}
		matcher.reset();
		
		final String matchingLines = matcher.replaceAll("$1:$2");
		String[] bounds = matchingLines.split(":");
		
		GeFLoRegistry.getLogger().log(Level.FINER, "Matching lines: {0}", matchingLines);
		
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
		final GeFLoPattern p = GeFLoPatternParser.parse(pattern);
		return find(p, scriptInput);
	}
	
	
	/**
	 * Alias which parses the pattern and prepares the
	 * script to an input string.
	 * 
	 * @param pattern
	 * @param script
	 * @return
	 */
	public static MatchingLineBounds find(String pattern, Script script) {
		final GeFLoPattern p = GeFLoPatternParser.parse(pattern);
		return find(p, prepareScript(script));
	}
	
	
	/**
	 * Alias which prepares the script to an input string.
	 * 
	 * @param pattern
	 * @param script
	 * @return
	 */
	public static MatchingLineBounds find(GeFLoPattern pattern, Script script) {
		return find(pattern, prepareScript(script));
	}
	
}
