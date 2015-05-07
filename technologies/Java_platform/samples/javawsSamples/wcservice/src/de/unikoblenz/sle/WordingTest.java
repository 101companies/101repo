package de.unikoblenz.sle;

/**
 * This is a just a test to run this locally without any server.
 */
public class WordingTest {
	public static final void main(String[] args) {
		Wording wording = new Wording();
		int count_01 = wording.count("How much is this ?");
		System.out.println(count_01 + " == 4");
		int count_02 = wording.count("Do you think this is a word -- 123 ?");
		System.out.println(count_02 + " == 8");
		int count_03 = wording.count("To be or not to be?");
		System.out.println(count_03 + " == 6");
	}
}
