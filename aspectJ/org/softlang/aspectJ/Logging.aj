package org.softlang.aspectJ;

/**
 * Logging for cut
 */
public aspect Logging {
	
	private void message(String prefix, Operations o) {
		System.out.println(
					"> "
				+ 	prefix 
				+ 	" Cut " 
				+ 	o.getClass().getSimpleName()
				+ 	" \"" 
				+ 	o.getName()
				+ 	"\". Total: " 
				+ 	o.total());
	}

	pointcut cut(Operations o):
		target(o) && call(void Operations.cut());
	
	void around(Operations o): cut(o) {
		message("BEGIN",o);
		proceed(o);
		message("END",o);
	}

}
