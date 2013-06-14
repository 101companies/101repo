package slowstringreverser;

public class SlowStringReverser {
	StringBuffer orgString;

	StringBuffer reversedString;

	SlowStringReverser(String orgStr) {
		orgString = new StringBuffer(orgStr);
	}

	SlowStringReverser() {
	}

	public String reverseString(String str) {
		orgString = new StringBuffer(str);
		reversedString = new StringBuffer();
		for (int i = (orgString.length() - 1); i >= 0; i--) {

			reversedString.append(orgString.charAt(i));
			System.out.println("Reversing one character per second: "
					+ reversedString);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
			}
		}
		return reversedString.toString();
	}
}
