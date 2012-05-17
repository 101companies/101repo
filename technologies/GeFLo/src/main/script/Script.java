package main.script;

import java.util.ArrayList;
import java.util.List;

import pattern.Cursor;

public class Script {
	
	private List<Token> tokens = new ArrayList<Token>();
	
	public Token get(int i) {
		return tokens.get(i);
	}
	
	public int size() {
		return tokens.size();
	}
	
	public void add(Token keyword) {
		tokens.add(keyword);
	}
	
	public Cursor createCursor() {
		return new Cursor(this);
	}
	
	public List<Token> getTokens() {
		return tokens;
	}
	
}
