package de.unikoblenz.sle;

import java.net.URL;

import javax.xml.namespace.QName;

/**
 * Demo to count words through a service.
 * 
 * @author pek
 *
 */
public class WantToCount {
	
	public static final void main(String[] args) throws Exception {

		URL localWSDL = new URL("http://localhost:8080/wcservice/Wording?wsdl");
//		URL remoteWSDL = new URL("http://sl-quad.uni-koblenz.de:8080/wcservice/Wording?wsdl");
		QName qname = new QName("http://sle.unikoblenz.de/", "WordingService");
		
		Wording counter = new WordingService(localWSDL, qname).getWordingPort();
		String str = "To be or not to be?";
		int howMuchWords = counter.count(str);
		System.out.println("word count of \"" + str + "\" = " + howMuchWords);
	}

}