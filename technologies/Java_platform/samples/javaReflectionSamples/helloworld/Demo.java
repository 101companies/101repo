package helloworld;

import java.lang.reflect.*;

/**
 * Construct objects and invoke methods in different ways.
 * Mainly:
 * a) Regular object construction and method invocation syntax.
 * b) Reflection API
 * b.1) Use of raw type Class
 * b.2) Use of generic class Class
 */
public class Demo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// Regular object construction and method invocation
		System.out.print("Without reflection: ");
		Exemplar obj = new Exemplar();
		obj.run();
		 
		// Reflection API with raw types for simplicity
		try { 
			System.out.print("With reflection: ");
			Class clss1 = Class.forName("helloworld.Exemplar");
			Constructor cons1 = clss1.getConstructor();
			Object obj1 = cons1.newInstance();
			Method meth = clss1.getMethod("run");
			meth.invoke(obj1);
		}
		catch (Exception e)
		{
			System.out.println("java.lang.reflect may throw in many ways.");			
		}

		// Reflection API with with generics for warnings-free code
		try { 
			System.out.print("Again, with reflection: ");
			Class<?> clss2 = Class.forName("helloworld.Exemplar");
			Constructor<?> cons2 = clss2.getConstructor();
			Object obj2 = cons2.newInstance();
			Method meth2 = clss2.getMethod("run");
			meth2.invoke(obj2);
		}
		catch (Exception e)
		{
			System.out.println("java.lang.reflect may throw in many ways.");			
		}
				
	}

}
