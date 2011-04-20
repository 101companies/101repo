package org.softlang.dom;

import org.w3c.dom.Document; // DOM trees
import org.w3c.dom.Element; // DOM subtrees
import org.w3c.dom.NodeList; // Lists of DOM subtrees
import static java.lang.Double.*;

/**
 * Cut all salaries of a company by half
 */
public class Cut {

    public static void cut(Document doc) {
	    	    
        // Get the matching elements
        NodeList nodelist = doc.getElementsByTagName("salary");
        		    
        // Process the elements in the nodelist
        for (int i=0; i<nodelist.getLength(); i++) {
        	
            // Get element
            Element elem = (Element)nodelist.item(i);
            
            // Transform content of element
            double value = parseDouble(elem.getTextContent());
            elem.setTextContent(Double.toString(value / 2));
            
        }
    }
}
