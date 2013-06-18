package classloading;

import java.io.*; 

/**
 * Load classes and compile them on-the-fly, if necessary. To this end, it 
 * is checked for nonexistent .class files, or .class files that are older 
 * than their corresponding source code. 
 */
public class CustomClassLoader extends ClassLoader 
{ 
	private String location;
	
	public CustomClassLoader(String location) {
		this.location = location;
	}

	/**
	 * Read the content of a file and return it as a byte array
	 */
	private byte[] getBytes( String filename ) throws IOException { 
		File file = new File( filename ); 
		long len = file.length(); 
		byte raw[] = new byte[(int)len]; 
		FileInputStream fin = new FileInputStream( file ); 
		int r = fin.read( raw ); 
		if (r != len) 
		throw new IOException( "Can't read all, "+r+" != "+len ); 
		fin.close(); 
		return raw; 
	}
	
	/**
	 * Compile a given .java file
	 */
	private boolean compile(String javaFile) throws IOException { 
		System.out.println( "CCL: Compiling "+javaFile+"..." ); 
		File dir = new File(location);
		Process p = Runtime.getRuntime().exec("javac "+javaFile, null, dir); 
		
		try { 
			p.waitFor(); 
		} catch( InterruptedException ie ) { System.out.println( ie ); } 
		int ret = p.exitValue(); 
		return ret==0;
	}
	
	/**
	 * The heart of the ClassLoader
	 */
	public Class<?> loadClass( String name, boolean resolve ) throws ClassNotFoundException { 

		// Our goal is to get a Class object 
		Class<?> clas = null; 

		// First, see if we've already dealt with this one 
		clas = findLoadedClass( name ); 

		// Create a pathname from the class name
		// E.g. java.lang.Object => java/lang/Object 
		String fileStub = name.replace( '.', '/' ); 

		// Build objects pointing to .java and .class files
		String javaFilename = fileStub+".java"; 
		String classFilename = fileStub+".class"; 
		File javaFile = new File(location+File.separator+javaFilename); 
		File classFile = new File(location+File.separator+classFilename); 

		// First, see if we want to try compiling. We do if (a) there 
		// is source code, and either (b0) there is no object code, 
		// or (b1) there is object code, but it's older than the source 
		if 	(javaFile.exists() && 
			(!classFile.exists() || 
			javaFile.lastModified() > classFile.lastModified())) { 
			try { 
				// Try to compile it. If this doesn't work, then 
				// we must declare failure. (It's not good enough to use 
				// and already-existing, but out-of-date, classfile) 
				if (!compile(javaFilename) || !classFile.exists()) { 
					throw new ClassNotFoundException( "Compile failed: "+javaFilename ); 
				} 
			} catch( IOException ie ) { 
				// Another place where we might come to if we fail to compile 
				throw new ClassNotFoundException( ie.toString() ); 
			} 
		} 
		// Let's try to load up the raw bytes, assuming they were 
		// properly compiled, or didn't need to be compiled 
		try { 
			// read the bytes 
			byte raw[] = getBytes( location+File.separator+classFilename ); 
			// try to turn them into a class 
			clas = defineClass( name, raw, 0, raw.length ); 
		} catch( IOException ie ) { 
			// This is not a failure! If we reach here, it might 
			// mean that we are dealing with a class in a library, 
			// such as java.lang.Object 
		} 
		// Maybe the class is in a library -- try loading  the normal way 
		if (clas==null) { 
			clas = findSystemClass( name ); 
		} 
		// Resolve the class, if any, but only if the "resolve" 
		// flag is set to true 
		if (resolve && clas != null) 
			resolveClass( clas ); 
		// If we still don't have a class, it's an error 
		if (clas == null) 
			throw new ClassNotFoundException( name ); 
		// Otherwise, return the class 
		return clas; 
	} 
}
