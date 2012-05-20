package geflo.main;

import java.net.URL;

public abstract class MainTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		final URL url		= classLoader.getResource(".");
		final String base	= url.getPath()+"../data/";
		final String input	= base+"company.rb.summary.json";
		
		Main.main(new String[]{ base+"total.geflo",	input });
		Main.main(new String[]{ base+"cut.geflo",	input });
	}

}
