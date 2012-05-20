package geflo.pattern;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public abstract class GeFLoRegistry {
	
	public static Logger logger;
	
	protected static Logger createLogger() {
		// Initialize logging
		StreamHandler handler = new StreamHandler(System.out, new SimpleFormatter());
		handler.setLevel(Level.ALL);
		Logger logger = Logger.getLogger(GeFLoRegistry.class.getName());
		logger.addHandler(handler);
		
		/*
		 * Change the level if you want to...
		 *	- disable logging to Level.OFF
		 *	- enable  logging to Level.ALL
		 */
		logger.setLevel(Level.ALL);
		
		return logger;
	}
	
	public static Logger getLogger() {
		if (logger == null) {
			logger = createLogger();
		}
		return logger;
	}
	
	public static void setLogger(Logger logger) {
		GeFLoRegistry.logger = logger;
	}
	
}