package geflo.main;

import geflo.pattern.GeFLoMatcher;
import geflo.pattern.GeFLoMatcher.MatchingLineBounds;
import geflo.pattern.GeFLoRegistry;
import geflo.script.Script;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.logging.Level;

public class GeFLoFragmentLocator {
	
	public static final boolean	DEBUG			= true;
	public static final String	ENCODING		= "UTF-8";
	public static final String	SUFFIX			= ".geflo";
	public static final String	TOKENIZER_NAME	= "getGeSHiTokens.php";
	public static final String	TOKENIZER_PATH;
	
	public static String phpPath = "php";
	
	static {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		final URL url		= classLoader.getResource(".");
		final String base	= url.getPath().replaceAll("^/([A-Z]:)", "\1")+"../";
		TOKENIZER_PATH = base+TOKENIZER_NAME;
	}
	
	/**
	 * @param args
	 * 	[0] => scriptInput	-	file name string
	 *  [1] => geFloInput	-	geflo pattern string or file name string with suffix '.geflo'
	 *  [2] => output		-	file name string
	 * 
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("GeFLo-fragment-locator uses a script and a GeFLo-pattern ");
			System.out.println("as inputs and matches the pattern against the tokens in the");
			System.out.println("script to write a line bounds file as output.");
			System.out.println();
			System.out.println("Usage information:");
			System.out.println("  scriptInput geFloInput output");
			System.out.println("    scriptInput	- path to a script file to match against");
			System.out.println("    geFloInput	- a geFlo pattern or a *.geflo file with a pattern");
			System.out.println("    output      - lines.json JSON-file which will be written");
			System.exit(1);
		}
		
		GeFLoRegistry.getLogger().setLevel(Level.OFF);
		try {
			// Get file arguments
			final File inputFile	= new File(args[0]);
			final File outputFile	= new File(args[2]);
			
			// Either it is a file with a pattern or a pattern string
			final String pattern;
			if (args[1].endsWith(SUFFIX)) {
				pattern	= readFile(new File(args[1]));
			} else {
				pattern	= args[1];
			}
			
			if (DEBUG) {
				System.out.println("Source file is       '"+inputFile+"'") ;
				System.out.println("Pattern to search is '"+pattern+"'") ;
				System.out.println("Output file is       '"+outputFile+"'") ;
			}
			
			/* Use an external process TOKENIZER to parse
			 * the script and get a JSON token array, which
			 * will be parsed with Script to an array of
			 * Token
			 */
			// final String cmd = phpPath+" "+TOKENIZER_PATH+" "+inputFile.getAbsolutePath();
			final String cmd = phpPath+" "+TOKENIZER_NAME+" "+inputFile.getAbsolutePath();

			if (DEBUG) {
				System.out.println("The following command will be executed to get the GeSHi tokens") ;
				System.out.println(cmd);
			}
			Process tokenizer = Runtime.getRuntime().exec(cmd);
			if (DEBUG) {
				System.out.println("Execution performed") ;
			}
			// Read output
			StringBuilder	stringBuilder = new StringBuilder();
			BufferedReader	input = null;
			try {
				input = new BufferedReader(new InputStreamReader(tokenizer.getInputStream()));
				String line;
				while ((line = input.readLine()) != null) {
					stringBuilder.append(line);
					stringBuilder.append('\n');
					if (DEBUG) {
						System.out.print("Line read: ") ;
						System.out.println(line);
					}
				}
			} finally {
				if (input != null) input.close();
			}
			if (DEBUG) {
				System.out.println("Output from command successfully read") ;
			}
			final String tokenizerOutput = stringBuilder.toString();
			stringBuilder = null;
			
			try {
				// Handle exit code
				if (tokenizer.exitValue() > 0) {
					throw new RuntimeException(tokenizerOutput);
				}
			} catch (IllegalThreadStateException e) {
				/* Maybe the process has not exited, so
				 * try another way to detect its state.
				 * Furthermore we should destroy the process
				 * to avoid zombies or worse things.
				 */
				tokenizer.destroy();
				if (!tokenizerOutput.startsWith("{")) {
					throw new RuntimeException(tokenizerOutput);
				}
			}
			
			// Parse token array
			final Script script	= Script.parseJSONString(tokenizerOutput);
			
			
			// Matches the pattern against the script
			if (DEBUG) {
				System.out.println("Launching GeFLoMatcher.find") ;
			}
			final MatchingLineBounds bounds = GeFLoMatcher.find(pattern, script);
			if (bounds == null) {
				System.err.println("Found nothing!");
			}
			if (DEBUG) {
				System.out.println("GeFloMatcher.find is done") ;
			}

			
			// Save the specified output file
			if (DEBUG) {
				System.out.println("Saving to the result to the file "+outputFile) ;
			}
			final Writer out = new OutputStreamWriter(new FileOutputStream(outputFile), ENCODING);
			try {
		    	out.write(bounds.toJson());
		    } finally {
		    	out.close();
		    }
			if (DEBUG) {
				System.out.println("Saved") ;
			}			
		} catch (IndexOutOfBoundsException e) {
			// added. There was nothing here 
			System.err.println("IndexOutOfBoundsException has be raised") ;
			System.err.println(e.getMessage());
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Read a file to string
	 * 
	 * @author erickson
	 * @link http://stackoverflow.com/a/326440
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String readFile(final File file) throws IOException {
		final FileInputStream stream = new FileInputStream(file);
		try {
			final FileChannel fc = stream.getChannel();
			final ByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			return Charset.forName(ENCODING).decode(bb).toString();
		} finally {
			stream.close();
		}
	}
	
}
