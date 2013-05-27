package privacy;

import java.lang.reflect.*;
import org.junit.*;

public class AllTests {

	@Ignore("Too private!")
	@Test
	public void test1() {
		assert new FieldTest().publicString != null; // Compile and runs fine
//		assert new FieldTest().privateString != null; // Compile error
	}
	
	@Test(expected = NoSuchFieldException.class)
	public void test2()
	    throws Exception {
	    FieldTest.class.getField("publicString"); // Ok
	    FieldTest.class.getField("privateString"); // Throws
	}
	
	@Test
	public void test3() {
		Field fields[] = FieldTest.class.getFields();
		for (int i = 0; i < fields.length; ++i)
			System.out.println("Field: " + fields[i]);
	}	

	@Test
	public void test4() {
		Field fields[] = FieldTest.class.getDeclaredFields();
		for (int i = 0; i < fields.length; ++i)
			System.out.println("Field: " + fields[i]);
	}		
	
	@Test(expected = IllegalAccessException.class)
	public void test5()
	    throws Exception {
	    Field fields[] = FieldTest.class.getDeclaredFields();
	    for (int i = 0; i < fields.length; ++i) {
	    	if ("privateString".equals(fields[i].getName())) {
	    		System.out.println(fields[i].get(new FieldTest()));
	    		break;
	    	}
	    }
	}	
	
	@Test
	public void test6()
	    throws Exception {
	    Field fields[] = FieldTest.class.getDeclaredFields();
	    for (int i = 0; i < fields.length; ++i) {
	    	if ("privateString".equals(fields[i].getName())) {
		        fields[i].setAccessible(true);
		        System.out.println(fields[i].get(new FieldTest()));
		        break;
	    	}
	    }
	}	
}
