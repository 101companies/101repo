package parseLib.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Parse strings; maintain position.
 * We could also use a random-access file.
 */
public class Input {
	
	private String str;
	private int pos;

	/**
	 * Construct new input from a string and start at position 0
	 */
	public Input(String str) {
		this.str = str;
		reset();
	}

	/**
	 * Construct new input from a file and start at position 0
	 */
	public Input(FileReader fr)
			throws IOException 
	{
		this.str = readWithStringBuffer(fr);
		reset();
	}	
	
	/**
	 * Test for "end-of-file"
	 */
	public boolean ready() {
		return pos < str.length();
	}
	
	/**
	 * Return current position
	 */
	public int getPos() {
		return pos;
	}

	/**
	 * Delegate substring to encapsulated string
	 */
	public String substring(int beginIndex, int endIndex) {
		return str.substring(beginIndex, endIndex);
	}
	
	/**
	 * Set current position
	 */
	public void setPos(int pos) {
		this.pos = pos;
	}
		
	/**
	 * Read the next character
	 */
	public char read() {
		if (ready())
			return str.charAt(pos++);
		else
			return 0;
	}
	
	/**
	 * Reset position to the beginning
	 */
	public void reset() {
		pos = 0;
	}
	
	/** 
	 * Delegate toString to encapsulated string
	 */
	public String toString() {
		return str;
	}

	/**
	 * Read in an entire file and return it as a single string
	 */
	private static String readWithStringBuffer(Reader fr)
			throws IOException 
	{

		BufferedReader br = new BufferedReader(fr);
		String line;
		StringBuffer result = new StringBuffer();
		while ((line = br.readLine()) != null) {
			result.append(line);
			result.append("\n");
		}
		return result.toString();
	}
		
}
