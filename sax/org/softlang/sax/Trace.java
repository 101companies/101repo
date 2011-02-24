package org.softlang.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * A parser that merely prints a trace for the XML input.
 */
public class Trace extends DefaultHandler
{	
	/**
	 * Handle "start document"
	 */
    public void startDocument()
    {
    	System.out.println("Start document");
    }

	/**
	 * Handle "end document"
	 */
    public void endDocument()
    {
    	System.out.println("End document");
    }

	/**
	 * Handle "start element"
	 */
    public void startElement(
    		String uri,
    		String name,
			String qName,
			Attributes atts)
    {
		if ("".equals (uri))
		    System.out.println("Start element: " + qName);
		else
		    System.out.println("Start element: {" + uri + "}" + name);
    }

	/**
	 * Handle "end element"
	 */
    public void endElement(
    		String uri,
    		String name,
    		String qName)
    {
		if (uri.equals(""))
		    System.out.println("End element: " + qName);
		else
		    System.out.println("End element: {" + uri + "}" + name);
    }

	/**
	 * Handle "characters"
	 */
    public void characters(char ch[], int start, int length)
    {
		System.out.print("Characters: \"");
		for (int i = start; i < start + length; i++) {
		    switch (ch[i]) {
		    case '\\':
			System.out.print("\\\\");
			break;
		    case '"':
			System.out.print("\\\"");
			break;
		    case '\n':
			System.out.print("\\n");
			break;
		    case '\r':
			System.out.print("\\r");
			break;
		    case '\t':
			System.out.print("\\t");
			break;
		    default:
			System.out.print(ch[i]);
			break;
		    }
		}
		System.out.print("\"\n");
    }
    
	public static void main (String args[]) throws Exception {
		SAXUtilities.parse(new Trace(), "Year2008.xml");
	}    
}
