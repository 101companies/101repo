package classloading;

import java.lang.reflect.*; 

/**
 * Execute a Java program through a custom class loader
 */
public class Demo {
	static public void main( String args[] ) throws Exception {

		// Define the "main" class of the application
		String mainClass = "Foo";
		
		// Create a custom class loader
		CustomClassLoader ccl = new CustomClassLoader("classpool"); 
		
		// Load the main class through the CCL 
		Class<?> clas = ccl.loadClass( mainClass ); 

		// Get a class representing the type of the main method's argument 
		Class<?> mainArgType[] = { (new String[0]).getClass() }; 
		
		// Find the standard main method in the class 
		Method main = clas.getMethod( "main", mainArgType );
		
		// Create an empty list of arguments
		String progArgs[] = new String[0]; 
		Object argsArray[] = { progArgs }; 
		
		// Call the method 
		main.invoke( null, argsArray ); 
	}
}
