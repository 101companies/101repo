package geflo.main;

import geflo.pattern.GeFLoMatcher;
import geflo.pattern.GeFLoMatcher.MatchingLineBounds;
import geflo.pattern.GeFLoRegistry;
import geflo.script.Script;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.logging.Level;

public class Main {
	
	public static final String ENCODING = "UTF-8";
	
	/**
	 * @param args
	 * 	[0] => .geflo-file to parse
	 * 	[1]	=> .summary.json-file to parse
	 * 
	 */
	public static void main(String[] args) {
		GeFLoRegistry.getLogger().setLevel(Level.OFF);
		try {
			final File gefloFile = new File(args[0]);
			final File inputFile = new File(args[1]);
			
			final String pattern	= readFile(gefloFile);
			final Script script		= Script.parseJSONFile(inputFile);
			
			final MatchingLineBounds bounds = GeFLoMatcher.find(pattern, script);
			if (bounds == null) {
				System.err.println("Found nothing!");
			}
			
			final String fileName = gefloFile.getName().replaceAll(".geflo$", "");
			final File baselineFile = new File(gefloFile.getParentFile(), fileName+".baseline");
			final Writer out = new OutputStreamWriter(new FileOutputStream(baselineFile), ENCODING);
			try {
		    	out.write(bounds.toJson());
		    } finally {
		    	out.close();
		    }
		} catch (IndexOutOfBoundsException e) {
			System.out.println("This writes a .baseline file with fragments ");
			System.out.println("Usage information: ");
			System.out.println(" '... $1 $2' where");
			System.out.println("	$1 is .geflo-file to parse");
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
	private static String readFile(final File file) throws IOException {
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
