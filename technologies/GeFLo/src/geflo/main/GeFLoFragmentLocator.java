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
	
    public static final String ENCODING = "UTF-8";
	public static final String TOKENIZER_NAME = "getGeSHiTokens.php";
       	public static String phpPath = "php";
		
	/**
	 * @param args
	 * 	[0] => scriptInput	-	file name string
	 *  [1] => geFloInput	-	geflo pattern string or file name string with suffix '.geflo'
	 *  [2] => output		-	file name string
	 * 
	 */
    public static void main(String[] args) throws IOException, InterruptedException {
		if (args.length != 4) {
			System.exit(1);
		}
		
		GeFLoRegistry.getLogger().setLevel(Level.OFF);

		// Process arguments
		final String TOKENIZER_PATH = args[0];
		final File inputFile	= new File(args[1]);
		final String pattern = readFile(new File(args[2]));
		final File outputFile	= new File(args[3]);
						
		// Run PHP script to get tokens
		final String cmd = phpPath+" "+TOKENIZER_PATH+File.separator+TOKENIZER_NAME+" "+inputFile.getAbsolutePath()+" "+outputFile.getAbsolutePath();
		System.out.println(cmd);
		Process tokenizer = Runtime.getRuntime().exec(cmd);
		tokenizer.waitFor();
		if (tokenizer.exitValue()!=0) {
		    throw new RuntimeException("Tokenizer failed");
		}

		// Read in tokens
		final String tokenizerOutput = readFile(outputFile);
		
		// Sanity check output
		if (!tokenizerOutput.startsWith("[")) {
		    throw new RuntimeException("Token array expected; "+tokenizerOutput+" found");
		}
		// Parse token array
		final Script tokens	= Script.parseJSONString(tokenizerOutput);

		// Matches the pattern against the script
		final MatchingLineBounds bounds = GeFLoMatcher.find(pattern, tokens);
		if (bounds == null) {
			System.exit(1);
		}
			
		// Save the specified output file
		final Writer out = new OutputStreamWriter(new FileOutputStream(outputFile), ENCODING);
		out.write(bounds.toJson());
		out.close();
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
