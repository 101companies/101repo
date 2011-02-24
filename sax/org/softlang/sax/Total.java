package org.softlang.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Compute the total all salaries of a company
 */
public class Total extends DefaultHandler
{
	
	private static String ns = "http://www.softlang.org/company.xsd";
	private boolean isSalary = false;
	private double total = 0;
	
	/**
	 * Return the final result of query for totaling salaries.
	 */
	public double getTotal() { 
		return total; 
	}
		
	/**
	 * Handle "start element"
	 */
    public void startElement(
    		String uri, 
    		String name,
			String qName,
			Attributes atts) {
    	isSalary = (uri.equals(ns) && name.equals("salary"));
    }
	
    /**
     * Handle "end element"
     */
    public void endElement(
    		String uri,
    		String name,
    		String qName) {
    	isSalary = false;
    }
    
	/**
	 * Handle "characters"
	 */
    public void characters(
    		char ch[],
    		int start,
    		int length) {
    	if (isSalary) {
    		String str = String.valueOf(ch, start, length);
    		double salary = Double.parseDouble(str);
    		total += salary;
	    }
    }
}