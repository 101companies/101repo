package geflo.main;

import java.net.URL;

public abstract class MainTester {
	
	public final static String BASE_PATH;
	public final static String SCRIPT_INPUT_FILE;
	
	static {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		final URL url		= classLoader.getResource(".");
		BASE_PATH			= url.getPath()+"../data/";
		SCRIPT_INPUT_FILE	= BASE_PATH+"company.rb";
	}
	
	public static void main(String[] args) {		
		test("total");
		test("cut");
	}
	
	public static void test(String test) {
		GeFLoFragmentLocator.main(new String[]{
				SCRIPT_INPUT_FILE,
				BASE_PATH+test+".geflo",
				BASE_PATH+test+".line"
			});
	}
	
}
