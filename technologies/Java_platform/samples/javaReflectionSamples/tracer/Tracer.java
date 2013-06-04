package tracer;

import java.lang.reflect.*;

/**
 * A Proxy is an object whose interface is implemented 
 * by an instance of InvocationHandler, which, essentially,
 * implements a generic invoke method. The proxy is told at
 * runtime which interfaces it handles.
 */
public class Tracer implements java.lang.reflect.InvocationHandler {

	private Object obj;

	/**
	 * We create a proxy that "inherits" attributes from the real subject.
	 * That is, the class loader and the interface of the real subject are adopted.
	 */
	public static Object newInstance(Object obj) {
		return java.lang.reflect.Proxy.newProxyInstance(
             obj.getClass().getClassLoader(),
             obj.getClass().getInterfaces(),
             new Tracer(obj));
    }

	/**
	 * A Tracer instance is the proxy.
	 * Hence, it holds on the real subject.
	 */
    private Tracer(Object obj) {
          this.obj = obj;
    }

    /**
     * Method invocations on a proxy are dispatched to the invoke method.
     * In our case, we essentially delegate invocation to the real subject.
     * ... and we add tracing output before and after the invocation.
     */
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
    {
    	Object result;
        try {
        	System.out.print("begin method " + m.getName() + "(");
        	if (args != null)
        		for(int i=0; i<args.length; i++) {
        			if(i>0) System.out.print(",");
        			System.out.print(" " + args[i].toString());
        		}
            System.out.println(" )");
            result = m.invoke(obj, args);
        } 
        catch (InvocationTargetException e) {
        	throw e.getTargetException();
        } 
        catch (Exception e) {
        	throw new RuntimeException("unexpected exception: " + e.getMessage());
        } 
        finally {
            System.out.println("end method " + m.getName());
        }
        return result;
     }
}
