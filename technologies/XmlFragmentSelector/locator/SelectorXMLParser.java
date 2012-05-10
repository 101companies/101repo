/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Martin
 */
public class SelectorXMLParser {
    private HashMap<Element, Tupel> elementRanges = new HashMap<Element, Tupel>();
    private Document doc;
    
    public SelectorXMLParser(File xmlFile) throws IOException, SAXException {
        doc = readXML(xmlFile);
    }
    
    public Document getDocument() {
        return doc;
    }
    
    public Tupel getLineRange(Element e) {
        return elementRanges.get(e);
    }
    
    /* 
     * Basically the same as seen in http://eyalsch.wordpress.com/2010/11/30/xml-dom-2/ ,
     * just some minor modifications
     */
    private Document readXML(File f) throws IOException, SAXException {
        final Document doc;
        SAXParser parser;
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newSAXParser();
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            doc = docBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Can't create SAX parser / DOM builder.", e);
        }

        DefaultHandler handler = new DefaultHandler() {
            private Stack<Element> elementStack = new Stack<Element>();
            private StringBuilder textBuffer = new StringBuilder();
            private Locator locator;

            @Override
            public void setDocumentLocator(Locator locator) {
                this.locator = locator;
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                addTextIfNeeded();
                //Element el = doc.createElement(qName);
                Element el = doc.createElementNS(uri,qName);
                for (int i = 0; i < attributes.getLength(); i++) {
                    el.setAttribute(attributes.getQName(i), attributes.getValue(i));
                }
                elementRanges.put(el, new Tupel(locator.getLineNumber(), -1));
                elementStack.push(el);
                
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                addTextIfNeeded();
                Element closedEl = elementStack.pop();
                elementRanges.get(closedEl).setTo(locator.getLineNumber());
                if (elementStack.isEmpty()) { // Is this the root element?
                    doc.appendChild(closedEl);
                } else {
                    Element parentEl = elementStack.peek();
                    parentEl.appendChild(closedEl);
                }
            }

            @Override
            public void characters(char ch[], int start, int length) throws SAXException {
                textBuffer.append(ch, start, length);
            }

            private void addTextIfNeeded() {
                if (textBuffer.length() > 0) {
                    Element el = elementStack.peek();
                    Node textNode = doc.createTextNode(textBuffer.toString());
                    el.appendChild(textNode);
                    textBuffer.delete(0, textBuffer.length());
                }
            }
        };
        parser.parse(f, handler);
       
        return doc;
    }
}
