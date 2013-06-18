import baz.*; 

public class Bar 
{ 
	public Bar() { 
		System.out.println( "Bar!"); 
		new Baz(); 
		try { 
			Class booClass = Class.forName( "Boo" ); 
			Object boo = booClass.newInstance(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} 
	} 
} 
