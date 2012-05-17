package main.script;

public class Token {
	
	private String	name;
	private int		lineNumber;
	private int		lineOffset;
	
	public Token(int lineNumber, int lineOffset, String name) {
		this.name = name;
		this.lineNumber = lineNumber;
		this.lineOffset = lineOffset;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	public int getLineOffset() {
		return lineOffset;
	}
	
}
