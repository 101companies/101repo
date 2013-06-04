import java.lang.reflect.*;

/**
 * The main method constructs an object of this very class.
 * Then, an instance method with "Hello, world!" functionality is invoked.
 * Construction and method invocation is expressed in terms of reflection.
 */
public class Demo {

    // An instance method to print "Hello, world!"
    public void helloWorld() {
	System.out.println("Hello, world!");
    }

    // A main method to construct an instance and invoke helloWorld()
    public static void main(String[] args) {

	// Catch all (reflection-related?) exceptions
	try { 
	    Class<?> clss = Class.forName("Demo");
	    Constructor<?> cons = clss.getConstructor();
	    Object obj = cons.newInstance();
	    Method meth = clss.getMethod("helloWorld");
	    meth.invoke(obj);
	}
	catch (Exception e)
	{
	    System.out.println("java.lang.reflect may throw in many ways.");			
	}
    }
}
