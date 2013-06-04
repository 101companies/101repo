package junitlight;

import java.lang.reflect.*;

public class RunTests {
	/**
	 * @param Name of class to be scanned for test methods
	 * @throws Exception
	 * 
	 * Sample invocation:
	 * java junitlight/RunTests junitlight.Exemplar
	 */
   public static void main(String[] args) throws Exception {
      int passed = 0, failed = 0;
      for (Method m : Class.forName(args[0]).getMethods()) {
         if (m.isAnnotationPresent(Test.class)) {
            try {
               m.invoke(null);
               passed++;
            } catch (Exception ex) {
               System.out.printf("Test %s failed: %s %n", m, ex.getCause());
               failed++;
            }
         }
      }
      System.out.printf("Passed: %d, Failed %d%n", passed, failed);
   }
}