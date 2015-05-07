package de.unikoblenz.sle;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService (name="Wording")
public class Wording {
	
	private static final String PATTERN_WORD = ".*[a-zA-Z0-9]+.*";
	
	@WebMethod
	public int count(String text) {
		String[] parts = text.split(" ");
		long count = 0;
		for (String part : parts) {
			if (part.matches(PATTERN_WORD)) {
				count++;
			}
		}
		return (int)count;
	}
}
