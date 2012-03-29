package org.softlang.operations;

import org.apache.xpath.XPathAPI;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document; // DOM trees
import org.w3c.dom.Element; // DOM subtrees
import org.w3c.dom.NodeList; // Lists of DOM subtrees

/**
 * Cut all or some salaries of a company in half
 */
public class Cut {

    public static void cutSalaries(Document doc, String xpath) 
    	throws TransformerException {
    	    	    
        // Get the matching elements
        NodeList nodelist = XPathAPI.selectNodeList(doc, xpath);
        		    
        // Process the elements in the nodelist
        for (int i=0; i<nodelist.getLength(); i++) {
        	
            // Get element
            Element elem = (Element)nodelist.item(i);
            
            // Transform content of element
            double before = Double.parseDouble(elem.getTextContent());
            double after = before / 2;            
            elem.setTextContent(Double.toString(after));
        }
    }
    
    public static void cutAllEmployees(Document doc) 
    	throws TransformerException {
    	cutSalaries(doc, "//salary");
    }
    
    public static void cutManagersOnly(Document doc)
    	throws TransformerException {
    	cutSalaries(doc, "//manager/salary");
    }
    
}
