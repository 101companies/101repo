package packagelist;

import java.io.File;
import java.util.LinkedList;

public class Demo {
	
	/** 
	 * Find (and load) all classes in a given package.
	 * The search relies on a directory listing.
	 */
	public static Iterable<Class<?>> getClassesInPackage(Package p) {	
		LinkedList<Class<?>> l = new LinkedList<Class<?>>();
		String name = p.getName();
		System.out.println("Package to be listed: " + name);
        name = name.replace('.',File.separatorChar);
        File dir = new File(name);
        System.out.println("Absolute path of package: " + dir.getAbsoluteFile());
        if (!dir.exists())
        	throw new RuntimeException("Can't find package!");
        for (String f : dir.list())
        	if (f.endsWith(".class")) {
	        	String classname = f.substring(0,f.length()-6);
	        	try {
	        		Class<?> clss = Class.forName(p.getName() + "." + classname);
	        		l.add(clss);
	        	}
	        	catch (ClassNotFoundException e) {
	        		// Ignore exception
        	}
        }
        return l;
	}

	/**
	 * List all classes that are the same package is this very class.
	 */
	public static void main(String[] args) {
		for (Class<?> c : getClassesInPackage(Demo.class.getPackage())) {
			// Show superclass for each class
			System.out.println(c.getName() + " extends " + c.getSuperclass().getName());
		}
	}	
}
	