package dumper;

import java.util.Arrays;
import java.lang.reflect.*;

/**
 * Dump (print) the state of an object.
 * That is, all pairs of field names and values are printed for the given object.
 * Whenever a value is of a non-primitive type, we recurse into the object.
 * Recursion indeed ceases for primitive values and null.
 * We use indentation with hyphens to indicate the nesting structure of objects.
 * IMPORTANT NOTE: cycles in the incoming object graph implies infinite recursion.
 */
public class Dumper {

	public static void indent(int indentation) {
		char chars[] = new char[indentation];
		Arrays.fill(chars,'-');
		System.out.print(chars);
	}
	
	public static void dump(Object obj) {
		if (obj != null) {
			System.out.println(obj.getClass().getName());
			dump(1,obj);
		}
	}
	public static void dump(int i, Object obj) {
		for (Field f : obj.getClass().getFields()) {
			indent(i);
			try {
				Object v = f.get(obj);
				System.out.print(f.getType().getName() + " " + f.getName() + " = ");
				if (f.getType().isPrimitive())
					System.out.println(v);
				else if (v==null)
					System.out.println("NULL");
				else {
					System.out.println();
					dump(i+1,f.get(obj));
				}
			}
			catch (IllegalAccessException e) {
				// DEAD CODE
			}
		}
	}	
}
