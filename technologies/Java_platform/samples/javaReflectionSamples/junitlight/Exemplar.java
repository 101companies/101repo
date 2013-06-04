package junitlight;

public class Exemplar {

	// A test method that succeeds
	@Test 
    public static void m1() { }
    
    // Not a test method
    public static void m2() { }
    
	// A test method that fails
    @Test 
    public static void m3() {
        throw new RuntimeException("Boom");
    }
    
}