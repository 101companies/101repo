package org.softlang.tests;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.softlang.sax.Validator.*;

public class Validate {
    
    @Test
    public void testValidate() {
     	assertTrue(validate("sampleCompany.xml", "Company.xsd"));
     	assertTrue(validate("output.xml", "Company.xsd")); 	
    }    
}
