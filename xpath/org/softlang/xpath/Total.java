package org.softlang.xpath;

import org.apache.xpath.XPathAPI;
import org.w3c.dom.Document; // DOM trees
import org.w3c.dom.Element; // DOM subtrees
import org.w3c.dom.NodeList; // Lists of DOM subtrees

/**
 * Compute the total all salaries of a company
 */
public class Total {

    public static double aggregate(Document doc) 
    	throws Exception {
	    
	    // The aggregation variable 
	    double total = 0;
	    
        // Get the matching elements
        NodeList nodelist = XPathAPI.selectNodeList(doc, "//salary");
        		    
        // Process the elements in the nodelist
        for (int i=0; i<nodelist.getLength(); i++) {
            // Get element
            Element elem = (Element)nodelist.item(i);
            total += Double.parseDouble(elem.getTextContent());
        }
	    return total;
    }
 }
